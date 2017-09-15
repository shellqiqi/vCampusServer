package seu.socket;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;

@Component
public class ClientRequest implements Serializable {

    private String serviceName;
    private String methodName;
    private Class<?>[] paramTypes;
    private Object[] params;

    public ClientRequest() {
        super();
    }

    public ClientRequest(String serviceName, String methodName, Class<?>[] paramTypes, Object[] params) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public ClientRequest(String serviceName, String methodName) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.paramTypes = null;
        this.params = null;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", paramTypes=" + Arrays.toString(paramTypes) +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
