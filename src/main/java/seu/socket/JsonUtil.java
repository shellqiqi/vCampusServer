package seu.socket;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import org.springframework.stereotype.Component;
import seu.domain.*;
import seu.domain.Class;

@Component
public class JsonUtil {

    private Genson genson;

    public JsonUtil() {
        genson = new Genson();
    }

    String serializeClientRequest(ClientRequest clientRequest) {
        return genson.serialize(clientRequest);
    }
    //TODO: 尝试函数泛型
    ClientRequest deserializeClientRequest(String json) {
        ClientRequest clientRequest = genson.deserialize(json, ClientRequest.class);
        String paramType = clientRequest.getParamType();
        //TODO: 对各个结构进行测试
        if (paramType.equals(CONSTANTS.INT)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Integer>>() {});
        } else if (paramType.equals(CONSTANTS.ADMIN)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Admin>>() {});
        } else if (paramType.equals(CONSTANTS.CLASS)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Class>>() {});
        } else if (paramType.equals(CONSTANTS.COMMODITY)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Commodity>>() {});
        } else if (paramType.equals(CONSTANTS.COURSE)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Course>>() {});
        } else if (paramType.equals(CONSTANTS.courseSELECT)) {
            return genson.deserialize(json, new GenericType<ClientRequest<CourseSelect>>() {});
        } else if (paramType.equals(CONSTANTS.DORMITORY)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Dormitory>>() {});
        } else if (paramType.equals(CONSTANTS.LIBRARY)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Library>>() {});
        } else if (paramType.equals(CONSTANTS.STUDENT)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Student>>() {});
        } else if (paramType.equals(CONSTANTS.TEACHER)) {
            return genson.deserialize(json, new GenericType<ClientRequest<Teacher>>() {});
        }
        return null;
    }

    private static final class CONSTANTS {
        static final String INT = Integer.class.toString();
        static final String ADMIN = Admin.class.toString();
        static final String CLASS = Class.class.toString();
        static final String COMMODITY = Commodity.class.toString();
        static final String COURSE = Course.class.toString();
        static final String courseSELECT = CourseSelect.class.toString();
        static final String DORMITORY = Dormitory.class.toString();
        static final String LIBRARY = Library.class.toString();
        static final String STUDENT = Student.class.toString();
        static final String TEACHER = Teacher.class.toString();
    }
}
