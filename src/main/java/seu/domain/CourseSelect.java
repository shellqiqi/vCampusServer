package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CourseSelect implements Serializable {
    private int courseSelectId;
    private int studentId;
    private int courseId;
    private int grade;

    public CourseSelect() {
        super();
    }

    public CourseSelect(int courseSelectId, int studentId, int courseId, int grade) {
        this.courseSelectId = courseSelectId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getCourseSelectId() {
        return courseSelectId;
    }

    public void setCourseSelectId(int courseSelectId) {
        this.courseSelectId = courseSelectId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseSelect{" + "courseSelectId=" + courseSelectId + ", studentId=" + studentId + ", courseId=" + courseId + ", grade=" + grade + '}';
    }
}
