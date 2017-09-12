package seu.socket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.Phased;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Admin;
import seu.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class JsonUtilTest {

    @Autowired
    private JsonUtil jsonUtil;

    @Autowired
    private UserService userService;

    private String json;

    @Before
    public void setUp() throws Exception {
        ClientRequest request = new ClientRequest("arg0", "arg1", userService.getAdmin(), List.class.toString());
        json = jsonUtil.serialize(request);
    }

    @Test
    public void serializeMessage() throws Exception {
        System.out.println(json);
        System.out.println(Admin.class.toString());
    }

    @Test
    public void deserializeMessage() throws Exception {
        ClientRequest<List<Admin>> request = jsonUtil.deserialize(json);
        System.out.println(request.getData().getClass());
        System.out.println(request.getData().get(0).getPassword());
//        List<Admin> list = (List<Admin>) request.getData();
//        System.out.println(list);
//        System.out.println(list.get(0));
//        System.out.println(list.get(0).getAdminId());

//        Admin admin = new Admin();
//        HashMap<String, String> hashMap = (HashMap) request.getData();
//        admin.setPassword(hashMap.get("password"));
//        System.out.println(admin.getPassword());
//        ArrayList<>
    }

}