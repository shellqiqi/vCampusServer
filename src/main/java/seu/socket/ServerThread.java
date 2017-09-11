package seu.socket;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
            PrintStream out = new PrintStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag =true;
            while(flag){
                //接收从客户端发送过来的数据
                final String str =  buf.readLine();
                //空字符防止阻塞
                if(str == null || "".equals(str)){
                    flag = false;
                }else{
                    //发送bye字符客户端退出，终止循环
                    if("bye".equals(str)){
                        flag = false;
                    }else{
                        //将接收到的字符串前面加上echo，发送到对应的客户端
                        out.println("echo:" + str);
                        System.out.println(str);
                    }
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