package seu.socket;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Component;
import seu.domain.Admin;

@Component
public class JsonUtil {

    private Genson genson;

    public JsonUtil() {
        genson = new Genson();
    }

    String serialize(ClientRequest clientRequest) {
        return genson.serialize(clientRequest);
    }

    ClientRequest deserialize(String json) {
        if (genson.deserialize(json, ClientRequest.class).getaClass().equals(Admin.class.toString())) {
            return genson.deserialize(json, new GenericType<ClientRequest<Admin>>(){});
        }
        return null;
    }
}
