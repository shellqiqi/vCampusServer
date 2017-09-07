package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int stuentId;
    private String studentName;
    private int classId;
    private int dormitoryId;
    private int balance;
    public Student(){ super();
    }

    public Student(int stuentId, String studentName, int classId, int dormitoryId, int balance) {
        this.stuentId = stuentId;
        this.studentName = studentName;
        this.classId = classId;
        this.dormitoryId = dormitoryId;
        this.balance = balance;
    }
    public int getStuentId() { return stuentId; }

    public void setStuentId(int stuentId) { this.stuentId = stuentId; }

    public String getStudentName() { return studentName; }

    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getClassId() { return classId; }

    public void setClassId(int classId) { this.classId = classId; }

    public int getDormitoryId() { return dormitoryId; }

    public void setDormitoryId(int dormitoryId) { this.dormitoryId = dormitoryId; }

    public int getBalance() { return balance; }

    public void setBalance(int balance) { this.balance = balance; }
}
