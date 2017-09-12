package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.LibraryDao;
import seu.domain.Library;

import java.util.Date;
import java.util.List;
@Service
public class LibraryService {

    @Autowired
    LibraryDao libraryUser;

    public LibraryDao getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryDao libraryUser) {
        this.libraryUser = libraryUser;
    }

    //添加图书
    public int insertBook(Library book){
        if(libraryUser.queryBookByBookId(book.getBookId()) == null)
            return libraryUser.insertBook(book);
        else
            return 0;
    }

    //删除图书
    public int deleteBookByBookId(Library book) {
       if(libraryUser.queryBookByBookId(book.getBookId()) == book)
           return libraryUser.deleteBookByBookId(book.getBookId());
       else
           return 0;
    }

    //更新图书信息
    public int updateBookByBookId(Library book) {
        if(libraryUser.queryBookByBookId(book.getBookId()) == book)
            return libraryUser.updateBookByBookId(book.getBookId(),book.getStudentId(),book.getStartDate());
        else
            return 0;
    }

    //通过图书id获取图书
    public Library getBookByBookId(int id) {
        return libraryUser.queryBookByBookId(id);
    }

    //通过学生id获取图书
    public List<Library> getBooksByStudentId(int studentId) {
        return libraryUser.queryBooksByStudentId(studentId);
    }

    //获取该图书全部信息
    public List<Library> getLibraryAll() {
        return libraryUser.queryAll();
    }
}
