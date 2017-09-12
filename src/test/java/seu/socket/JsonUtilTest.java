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
public class JsonUtilTest {

    @Autowired
    private JsonUtil jsonUtil;

    private String json;

    @Before
    public void setUp() throws Exception {
        ClientRequest<Integer> request = new ClientRequest<>(
                "userService",
                "getAdminById",
                1,
                Integer.class.toString(),
                "getAll");
        json = jsonUtil.serializeClientRequest(request);
    }

    @Test
    public void serializeMessage() throws Exception {
        System.out.println(json);
    }

    @Test
    public void deserializeMessage() throws Exception {
        ClientRequest<Integer> clientRequest = jsonUtil.deserializeClientRequest(json);
        System.out.println(clientRequest.getMethodName());
        System.out.println(clientRequest.getServiceName());
        System.out.println(clientRequest.getParamType());
        System.out.println(clientRequest.getParam());
        System.out.println(clientRequest.getRequestType());
    }
}