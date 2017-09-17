package seu.socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class ServerTest {

    @Autowired
    Server server;

    @Test
    public void testServerStartAndStop() throws Exception {
        Server.runFlag = true;
        Thread thread = new Thread(server);
        thread.start();
        Thread.sleep(5000);
        Server.runFlag = false;
        Thread.sleep(5000);
    }

    @Test
    public void testServer() throws Exception {
        Server.runFlag = true;
        Thread thread = new Thread(server);
        thread.start();
        for (int i = 60; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println(i + " seconds left");
        }
    }
}