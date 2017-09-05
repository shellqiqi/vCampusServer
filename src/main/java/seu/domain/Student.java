package seu.domain;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private int StuentID;
    private String StudentName;
    private int ClassID;
    private int DormitoryID;
    private int Balance;

    public int getStuentID() {
        return StuentID;
    }

    public void setStuentID(int stuentID) {
        StuentID = stuentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClassID(int classID) {
        ClassID = classID;
    }

    public int getDormitoryID() {
        return DormitoryID;
    }

    public void setDormitoryID(int dormitoryID) {
        DormitoryID = dormitoryID;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
