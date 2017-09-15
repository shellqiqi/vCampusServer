package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Student implements Serializable {
    private int studentId;
    private String studentName;
    private int classId;
    private int dormitoryId;
    private int balance;
    private String password;

    public Student() {
        super();
    }

    public Student(int studentId, String studentName, int classId, int dormitoryId, int balance, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classId = classId;
        this.dormitoryId = dormitoryId;
        this.balance = balance;
        this.password = password;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(int dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", studentName='" + studentName + '\'' + ", classId=" + classId + ", dormitoryId=" + dormitoryId + ", balance=" + balance + ",password='" + password + '\'' + '}';
    }
}

