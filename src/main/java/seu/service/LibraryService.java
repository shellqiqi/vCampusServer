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

    /**
     * 设置图书馆DAO
     * @param libraryDao 图书馆DAO
     */
    @Autowired
    public void setLibraryDao(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    /**
     * 借书
     * @param studentID 借书学生的ID
     * @param bookID 图书的ID
     * @return 借书成功返回1，不成功返回0，异常返回-1
     */
    public int borrowBook(int studentID, int bookID) {
        try {
            return libraryDao.updateBookByBookId(bookID,studentID,new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 还书
     * @param bookID 图书ID
     * @return 还书成功返回1，不成功返回0，异常返回-1
     */
    public int returnBook(int bookID) {
        try {
            return libraryDao.updateBookByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 续借
     * @param bookID 图书ID
     * @return 续借成功返回1，不成功返回0，异常返回-1
     */
    public int reNewBook(int bookID) {
        try {
            Library book = libraryDao.queryBookByBookId(bookID);
            return libraryDao.updateBookByBookId(bookID, book.getStudentId(), new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 学生查询自己借的所有书
     * @param studentID 学生ID
     * @return 所有借书的List
     */
    public List<Library> getAllBookList(int studentID) {
        try {
            return libraryDao.queryBooksByStudentId(studentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 管理员根据bookID,bookName增加图书
     * @param bookID 图书ID
     * @param bookName 书名
     * @return 增加图书成功返回1，不成功返回0，异常返回-1
     */
    public int insertBook(int bookID,String bookName){
        try{
            return libraryDao.insertBook(bookID,bookName);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 管理员删除借书记录，以及图书
     * @param bookID 图书ID
     * @return 删除图书成功返回1，不成功返回0，异常返回-1
     */
    public int deleteBook(int bookID) {
        try {
            return libraryDao.deleteBookByBookId(bookID);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * 获得书对象通过书名
     * @param bookName 书名
     * @return 返回所有该书名的借书信息List
     */
    public List<Library> getBookByBookName(String bookName){
        try{
            return libraryDao.queryBooksByBookName(bookName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 学生通过图书id获取所借图书信息
     * @param id 图书ID
     * @return 返回借书信息，异常返回null
     */
    public Library getBookByBookId(int id) {
        try {
            return libraryDao.queryBookByBookId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 学生通过学生id获取图书
     * @param studentId 学生ID
     * @return 返回学生所有借书信息，异常返回null
     */
    public List<Library> getBooksByStudentId(int studentId) {
        try {
            return libraryDao.queryBooksByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 管理员更新图书信息
     * @param book 借书信息对象
     * @return 更新图书信息成功返回1，不成功返回0，异常返回-1
     */
    public int updateBook(Library book) {
        try {
            return libraryDao.updateBookByBookId(book.getBookId(), book.getStudentId(), book.getStartDate());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 学生查询所有可以借的书籍
     * @return 返回所有可以借的书籍
     */
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

    /**
     * 管理员获取所有学生所借图书全部信息
     * @return 返回所有学生所借图书全部信息
     */
    public List<Library> getLibraryAll() {
        try {
            return libraryDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
