package seu.socket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Admin;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class RequestRouterTest {
    @Autowired
    RequestRouter requestRouter;

    @Test
    public void router() throws Exception {
        List<Admin> adminList = (List) requestRouter.router("userService", "getAdmin");
        System.out.println(adminList.get(0).getPassword());
    }

}