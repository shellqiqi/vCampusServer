package seu.socket;

import org.springframework.stereotype.Component;

@Component
public class ClientRequest<T> {
    //TODO: 转用Java序列化实现
    private String serviceName;
    private String methodName;

    private T param;
    private String paramType;

    private String requestType;

    public ClientRequest() {
        super();
    }

    public ClientRequest(String serviceName, String methodName, T param, String paramType, String requestType) {
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.param = param;
        this.paramType = paramType;
        this.requestType = requestType;
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

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return "ClientRequest{" + "serviceName='" + serviceName + '\'' + ", methodName='" + methodName + '\'' + ", param=" + param + ", paramType='" + paramType + '\'' + ", requestType='" + requestType + '\'' + '}';
    }
}
