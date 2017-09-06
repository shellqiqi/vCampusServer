package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Class {
    private int classId;
    private String className;
    private String major;
    private int classSize;
    private int teacherId;

    public Class(){
    }

    public Class(int classId, String name, String major, int size, int teacherId){
         this.setClassId(classId);
         this.setClassName(name);
         this.setMajor(major);
         this.setClassSize(size);
         this.setTeacherId(teacherId);
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
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", classSize=" + classSize +
                ", teacherId=" + teacherId +
                '}';
    }
}
