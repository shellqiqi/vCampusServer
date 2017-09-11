package seu.socket;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import seu.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Component
public class Server implements Runnable {

    private ApplicationContext context;
    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    //客户端计数
    static int count = 0;
    //监听循环标志
    public static boolean runFlag = true;

    //程序退出终止监听
/*
    public Server() {
        Main.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                runFlag = false;
            }
        });
    }
*/

    public void run() {
        //服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server = null;
        try {
            server = new ServerSocket(20006);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket client = null;
        while(runFlag){
            //等待客户端的连接，如果没有获取连接
            System.out.println("等待客户端的连接");
            try {
                //定时重试防止阻塞
                server.setSoTimeout(3000);
                //阻塞
                client = server.accept();
                System.out.println("与客户端连接成功！");
                //为每个客户端连接开启一个线程
                ServerThread serverThread = context.getBean(ServerThread.class);
                serverThread.setClient(client);
                new Thread(serverThread).start();
            } catch (SocketTimeoutException e) {
                System.out.println("3秒超时，重试");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}