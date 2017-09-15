package seu.socket;

import javafx.application.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import seu.controller.MainController;

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

    public ServerThread(Socket client) {
        this.client = client;
    }

    private RequestRouter requestRouter;

    private MainController mainController;

    @Autowired
    public void setRequestRouter(RequestRouter requestRouter) {
        this.requestRouter = requestRouter;
    }

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void run() {
        Server.count++;

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mainController.log("Request " + Server.count + " from " + client.getInetAddress().toString() + "\n");
            }
        });

        try {
            //获取Socket的输出流，用来向客户端发送数据
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            //获取Socket的输入流，用来接收从客户端发送过来的数据
            ObjectInputStream buf = new ObjectInputStream(new BufferedInputStream(client.getInputStream()));
            Object object = buf.readObject();
            if (object != null) {
                out.writeObject(requestRouter.handleRequest((ClientRequest) object));
                out.flush();
            }
            out.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}