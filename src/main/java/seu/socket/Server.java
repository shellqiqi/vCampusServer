package seu.socket;

import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import seu.controller.MainController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Component
public class Server implements Runnable {

    private ApplicationContext context;

    private MainController mainController;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    //客户端计数
    static int count = 0;
    //监听循环标志
    public static boolean runFlag = false;
    //端口号
    public static int port = 20006;

    public void run() {
        //服务端在20006端口监听客户端请求的TCP连接
        ServerSocket server;
        try {
            server = new ServerSocket(port);
        } catch (final Exception e) {
            e.printStackTrace();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    mainController.log( e.getMessage() + ".\n");
                    mainController.stopServer();
                }
            });
            return;
        }
        Socket client;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mainController.log("Server started at " + port + ".\n");
            }
        });

        while (runFlag) {
            //等待客户端的连接，如果没有获取连接
//            System.out.println("等待客户端的连接");
            try {
                //定时重试防止阻塞
                server.setSoTimeout(3000);
                //阻塞
                client = server.accept();
//                System.out.println("与客户端连接成功！");
                //为每个客户端连接开启一个线程
                ServerThread serverThread = context.getBean(ServerThread.class);
                serverThread.setClient(client);
                new Thread(serverThread).start();
            } catch (SocketTimeoutException e) {
//                System.out.println("3秒超时，重试");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mainController.log("Server is down.\n");
            }
        });
    }
}