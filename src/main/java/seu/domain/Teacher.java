package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherPhoneNumber;
    private String password;

    public Teacher() {
        super();
    }

    public Teacher(int teacherId, String teacherName, String teacherPhoneNumber, String password) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPhoneNumber = teacherPhoneNumber;
        this.password = password;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Teacher{" + "teacherId=" + teacherId + ", teacherName='" + teacherName + '\'' + ", teacherPhoneNumber='" + teacherPhoneNumber + '\'' + ",password='" + password + '\'' + '}';
    }
}
