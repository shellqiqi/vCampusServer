package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Course implements Serializable {
    private int courseId;
    private String courseName;
    private int credit;
    private int period;
    private int teacherId;


    public Course() {
        super();
    }

    public Course(int courseId, String courseName, int credit, int period, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.period = period;
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName='" + courseName + '\'' + ", credit=" + credit + ", period=" + period + ", teacherId=" + teacherId + '}';
    }
}
