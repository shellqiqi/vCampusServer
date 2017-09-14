package seu.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Component
public class RequestRouter {
    //TODO: 测试
    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ServerResponse getResponse(ClientRequest clientRequest) {
//        String requestType = clientRequest.getRequestType();

//        switch (requestType) {
//            case "getAll":
//                return nonParam(clientRequest.getServiceName(), clientRequest.getMethodName());
//            case "getOne":
//            case "delete":
////                return intParam(clientRequest.getServiceName(), clientRequest.getMethodName(), Integer.class, clientRequest.getParam());
//            case "update":
//            case "add":
//                return objParam(clientRequest.getServiceName(), clientRequest.getMethodName(), Object.class, clientRequest.getParam());
//        }
        return new ServerResponse(invokeMethod(clientRequest.getServiceName(), clientRequest.getMethodName(), clientRequest.getParamTypes(), clientRequest.getParams()));
    }

//    public Object nonParam(String serviceName, String methodName) {
//        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName);
//        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName));
//    }
//
//    public Object objParam(String serviceName, String methodName, Class aClass, Object param) {
//        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName, aClass);
//        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName), aClass, param);
//    }

    private Object invokeMethod(String beanName, String methodName, Class<?>[] paramTypes, Object[] params) {
        Method method;
        if (paramTypes == null || params == null) {
            method = ReflectionUtils.findMethod(context.getBean(beanName).getClass(), methodName);
            return ReflectionUtils.invokeMethod(method, context.getBean(beanName));
        } else {
            method = ReflectionUtils.findMethod(context.getBean(beanName).getClass(), methodName, paramTypes);
            return ReflectionUtils.invokeMethod(method, context.getBean(beanName), params);
        }
    }

//    public Object intParam(String serviceName, String methodName, Class aClass, Object param) {
//        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName, aClass);
//        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName), aClass, param);
//    }
}
