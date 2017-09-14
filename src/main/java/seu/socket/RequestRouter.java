package seu.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Component
public class RequestRouter {
    //TODO: 做好网络接口格式与路由方法对应关系
    //TODO: 测试
    @Autowired
    ApplicationContext context;

    @Autowired
    JsonUtil jsonUtil;

    public ClientRequest execute(String json) {
        return jsonUtil.deserializeClientRequest(json);
    }

    public Object router(ClientRequest clientRequest) {
        String requestType = clientRequest.getRequestType();

        switch (requestType) {
            case "getAll":
                return nonParam(clientRequest.getServiceName(), clientRequest.getMethodName());
            case "getOne":
            case "delete":
//                return intParam(clientRequest.getServiceName(), clientRequest.getMethodName(), Integer.class, clientRequest.getParam());
            case "update":
            case "add":
                return objParam(clientRequest.getServiceName(), clientRequest.getMethodName(), Object.class, clientRequest.getParam());
        }
        return null;
    }

    public Object nonParam(String serviceName, String methodName) {
        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName);
        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName));
    }

    public Object objParam(String serviceName, String methodName, Class aClass, Object param) {
        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName, aClass);
        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName), aClass, param);
    }

//    public Object intParam(String serviceName, String methodName, Class aClass, Object param) {
//        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName, aClass);
//        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName), aClass, param);
//    }
}
