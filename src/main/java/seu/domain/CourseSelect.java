package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class CourseSelect {
    private int courseSelectId;
    private int studentId;
    private int courseId;
    private int grade;

    public int getCourseSelectId() { return courseSelectId; }

    public void setCourseSelectId(int courseSelectId) { this.courseSelectId = courseSelectId; }

    public int getStudentId() { return studentId; }

    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }

    public void setCourseId(int courseId) { this.courseId = courseId; }

    public int getGrade() { return grade; }

    public void setGrade(int grade) { this.grade = grade; }
}
