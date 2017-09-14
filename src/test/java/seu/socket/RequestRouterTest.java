package seu.socket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class RequestRouterTest {

    private ClientRequest clientRequest;

    @Autowired
    private RequestRouter requestRouter;

    @Before
    public void setUp() throws Exception {
        clientRequest = new ClientRequest();
    }

    @Test
    public void getResponse() throws Exception {
        ServerResponse serverResponse = requestRouter.getResponse(clientRequest);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }

}