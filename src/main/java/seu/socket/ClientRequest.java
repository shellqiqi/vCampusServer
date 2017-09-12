package seu.socket;

import org.springframework.stereotype.Component;
import seu.domain.Admin;

@Component
public class ClientRequest<T> {

    String destination;
    String type;

    T data;
    String aClass;

    public ClientRequest() {
        super();
    }

    public ClientRequest(String destination, String type, T data, String aClass) {
        this.destination = destination;
        this.type = type;
        this.data = data;
        this.aClass = aClass;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                ", aClass=" + aClass +
                '}';
    }
}
