package seu.socket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Student;
import seu.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class RequestRouterTest {

    private ClientRequest clientRequest1;
    private ClientRequest clientRequest2;
    private ClientRequest clientRequest3;

    @Autowired
    private RequestRouter requestRouter;
    @Autowired
    private AdminService adminService;

    @Before
    public void setUp() throws Exception {
        clientRequest1 = new ClientRequest("dormitoryService", "getDormitoryAll");
        clientRequest2 = new ClientRequest("studentService", "login", new Class[]{int.class, String.class}, new Object[]{8, "8888"});
        clientRequest3 = new ClientRequest("adminService", "changeStudentNameByStudentId", new Class[]{Student.class}, new Object[]{adminService.getStudentByStudentId(2)});
    }

    @Test
    public void getResponse1() throws Exception {
        ServerResponse serverResponse = requestRouter.getResponse(clientRequest1);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }

    @Test
    public void getResponse2() throws Exception {
        ServerResponse serverResponse = requestRouter.getResponse(clientRequest2);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }

    @Test
    public void getResponse3() throws Exception {
        ServerResponse serverResponse = requestRouter.getResponse(clientRequest3);
        System.out.println(serverResponse);
        System.out.println(serverResponse.getData().getClass());
    }

}