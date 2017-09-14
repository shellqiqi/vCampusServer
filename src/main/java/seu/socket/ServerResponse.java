package seu.socket;

import org.springframework.stereotype.Component;

@Component
public class ServerResponse<T> {

    private T data;
    private String dataType;
    private String genericType;
}
