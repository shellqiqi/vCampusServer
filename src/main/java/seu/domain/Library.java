package seu.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Library {
    private int bookId;
    private String bookName;
    private int studentId;
    private Date period;
    private Date returnDate;

    public Library() {
        super();
    }

    public Library(int bookId, String bookName, int studentId, Date period, Date returnDate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.studentId = studentId;
        this.period = period;
        this.returnDate = returnDate;
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

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Library{" + "bookId=" + bookId + ", bookName='" + bookName + '\'' + ", studentId=" + studentId + ", period=" + period + ", returnDate=" + returnDate + '}';
    }
}
