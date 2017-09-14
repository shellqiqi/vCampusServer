package seu.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Library implements Serializable {
    private int bookId;
    private int studentId;
    private String bookName;
    private Date startDate;

    public Library() {
        super();
    }

    public Library(int bookId, String bookName, int studentId, Date sDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.startDate = sDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    @Override
    public String toString() {
        return "Library{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", bookName='" + bookName + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
