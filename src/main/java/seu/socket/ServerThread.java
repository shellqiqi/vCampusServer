package seu.socket;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component
@Scope("prototype")
public class ServerThread implements Runnable {

    private Socket client = null;
    void setClient(Socket client) {
        this.client = client;
    }

    public ServerThread() {
        super();
    }
    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        Server.count++;
        System.out.println("客户端数量: " + Server.count);

        try{
            //获取Socket的输出流，用来向客户端发送数据
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            ObjectInputStream buf = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
            boolean flag =true;
            while(flag){
                Object obj = buf.readObject();
                if (obj != null) {
                    //TODO: 添加服务端响应
                } else {
                    flag = false;
                }
            }
            out.close();
            client.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        Server.count--;
        System.out.println("客户端数量: " + Server.count);
    }
}