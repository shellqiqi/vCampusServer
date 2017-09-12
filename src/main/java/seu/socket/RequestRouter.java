package seu.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

@Component
public class RequestRouter {
    //TODO: 做好网络接口格式与路由方法对应关系
    @Autowired
    ApplicationContext context;

    public Object router(String serviceName, String methodName) {
        Method method = ReflectionUtils.findMethod(context.getBean(serviceName).getClass(), methodName);
        return ReflectionUtils.invokeMethod(method, context.getBean(serviceName));
    }

//    public Object router(String className, String methodName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Class aClass = Class.forName(className);
//        Method method = aClass.getMethod(methodName);
//        return method.invoke();
//    }
}
