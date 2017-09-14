package seu.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Component
public class RequestRouter {

    private ApplicationContext context;

    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public ServerResponse getResponse(ClientRequest clientRequest) {
        return new ServerResponse(invokeMethod(clientRequest.getServiceName(), clientRequest.getMethodName(), clientRequest.getParamTypes(), clientRequest.getParams()));
    }

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
}
