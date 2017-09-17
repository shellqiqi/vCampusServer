package seu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seu.socket.Server;

import java.util.Date;

@Controller
public class MainController {

    @FXML
    Button toggleButton;

    @FXML
    TextArea logTextArea;

    @FXML
    TextField portText;

    private Thread thread;
    private Server server;

    @Autowired
    public void setServer(Server server) {
        this.server = server;
    }

    public void toggleServer(MouseEvent mouseEvent) {
        if (thread == null) {
            startServer();
        } else if (thread.getState() == Thread.State.RUNNABLE){
            stopServer();
        } else {
            startServer();
        }
    }

    public void log(String s) {
        Date date = new Date();
        logTextArea.appendText(date.toString() + ":\n  ");
        logTextArea.appendText(s);
    }

    private void startServer() {
        try {
            if (portText.getLength() == 0)
                Server.port = Integer.parseInt(portText.getPromptText());
            else
                Server.port = Integer.parseInt(portText.getText());
        } catch (Exception e) {
            log(e.getMessage() + ".\n");
            return;
        }
        toggleButton.setText("stop");
        Server.runFlag = true;
        thread = new Thread(server);
        thread.start();
    }

    public void stopServer() {
        Server.runFlag = false;
        toggleButton.setText("start");
        log("Server will be shutdown.\n");
    }
}
