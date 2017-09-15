package seu.socket;

import org.junit.Before;
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
public class RequestRouterTest {

    private ClientRequest clientRequest1;
    private ClientRequest clientRequest2;

    @Autowired
    private RequestRouter requestRouter;

    @Before
    public void setUp() throws Exception {
        clientRequest1 = new ClientRequest("dormitoryService", "getDormitoryAll");
        clientRequest2 = new ClientRequest("studentService", "login", new Class[]{int.class, String.class}, new Object[]{8, "8888"});
    }

    @Test
    public void getResponse1() throws Exception {
        ServerResponse serverResponse = requestRouter.handleRequest(clientRequest1);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }

    @Test
    public void getResponse2() throws Exception {
        ServerResponse serverResponse = requestRouter.handleRequest(clientRequest2);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }
}