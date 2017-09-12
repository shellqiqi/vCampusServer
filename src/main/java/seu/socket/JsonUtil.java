package seu.socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonUtil {

    private ObjectMapper objectMapper;

    JsonUtil() {
        objectMapper = new ObjectMapper();
    }

    public String serializeClientRequest(ClientRequest request) throws JsonProcessingException {
        return objectMapper.writeValueAsString(request);
    }

    public ClientRequest deserializeClientRequest(String s) throws IOException {
        return objectMapper.readValue(s, ClientRequest.class);
    }
}
