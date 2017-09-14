package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Class implements Serializable {
    private int classId;
    private String className;
    private String major;
    private int classSize;
    private int teacherId;


    public Class() {
        super();
    }

    public Class(int classId, String className, String major, int classSize, int teacherId) {
        this.classId = classId;
        this.className = className;
        this.major = major;
        this.classSize = classSize;
        this.teacherId = teacherId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Class{" + "classId=" + classId + ", className='" + className + '\'' + ", major='" + major + '\'' + ", classSize=" + classSize + ", teacherId=" + teacherId + '}';
    }
}
