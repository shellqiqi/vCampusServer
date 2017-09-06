package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherPhoneNumber;

    public Teacher(){

    }

    public Teacher(int teacherId, String teacherName, String teacherPhoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public int getTeacherId() { return teacherId; }

    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }

    public String getTeacherName() { return teacherName; }

    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getTeacherPhoneNumber() { return teacherPhoneNumber; }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) { this.teacherPhoneNumber = teacherPhoneNumber; }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhoneNumber='" + teacherPhoneNumber + '\'' +
                '}';
    }
}
