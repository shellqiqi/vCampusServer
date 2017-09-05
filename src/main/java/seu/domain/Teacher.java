package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private int TeacherID;
    private String TeacherName;
    private String TeacherPhoneNumber;

    public int getTeacherID() {
        return TeacherID;
    }

    public void setTeacherID(int teacherID) {
        TeacherID = teacherID;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getTeacherPhoneNumber() {
        return TeacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        TeacherPhoneNumber = teacherPhoneNumber;
    }
}
