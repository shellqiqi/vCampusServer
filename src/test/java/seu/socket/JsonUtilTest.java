package seu.socket;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Admin;
import seu.service.UserService;

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
    }

    @Test
    public void serializeMessage() throws Exception {
    }

    @Test
    public void deserializeMessage() throws Exception {
    }

}