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
    LibraryDao libraryDao;

    public LibraryDao getLibraryUser() {
        return libraryDao;
    }

    public void setLibraryUser(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    //学生通过图书id获取所借图书信息
    public Library getBookByBookId(int id) {
        return libraryDao.queryBookByBookId(id);
    }

    //学生通过学生id获取图书
    public List<Library> getBooksByStudentId(int studentId) {
        return libraryDao.queryBooksByStudentId(studentId);
    }
}
