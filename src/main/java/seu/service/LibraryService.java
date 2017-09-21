package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.LibraryDao;
import seu.domain.Library;

import java.util.Date;
import java.util.List;

@Service
public class LibraryService {

    private LibraryDao libraryDao;

    @Autowired
    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    public int borrowBook(int studentID, int bookID) {
        try {
            return libraryDao.updateBookByBookId(bookID,studentID,new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int returnBook(int bookID) {
        try {
            return libraryDao.updateBookByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //续借
    public int reNewBook(int bookID) {
        try {
            Library book = libraryDao.queryBookByBookId(bookID);
            return libraryDao.updateBookByBookId(bookID, book.getStudentId(), new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    //学生查询自己借的所有书
    public List<Library> getAllBookList(int studentID) {
        try {
            return libraryDao.queryBooksByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //管理员根据bookID,bookName增加图书
    public int insertBook(int bookID,String bookName){
        try{
            return libraryDao.insertBook(bookID,bookName);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    //管理员删除借书记录，以及图书
    public int deleteBook(int bookID) {
        try {
            return libraryDao.deleteBookByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Library> getBookByBookName(String bookName){
        try{
            return libraryDao.queryBooksByBookName(bookName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    //学生通过图书id获取所借图书信息
    public Library getBookByBookId(int id) {
        try {
            return libraryDao.queryBookByBookId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //学生通过学生id获取图书
    public List<Library> getBooksByStudentId(int studentId) {
        try {
            return libraryDao.queryBooksByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //管理员更新图书信息
    public int updateBook(Library book) {
        try {
            return libraryDao.updateBookByBookId(book.getBookId(), book.getStudentId(), book.getStartDate());
        } catch (Exception e) {
            return -1;
        }
    }

    //学生获取所有可以借的图书
    public List<Library> getAllAvailableBook(){
        try{
            List<Library> noAvaliableBook = libraryDao.queryAllBorrowedBook();
            List<Library> result = libraryDao.queryAll();
            int SIZE = noAvaliableBook.size();
            for( int i = 0 ; i < SIZE ;i++){
                Library borrowedBook = noAvaliableBook.get(i);
                for(int j = 0 ; j < result.size(); j++){
                    if( borrowedBook.getBookId() == result.get(j).getBookId() )
                    {
                        result.remove(j);
                        break;
                    }
                }
            }
            //result.removeAll(noAvaliableBook);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //管理员获取所有学生所借图书全部信息
    public List<Library> getLibraryAll() {
        try {
            return libraryDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
