package seu.dao;

import org.junit.Test;
import seu.config.ApplicationContextConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.domain.Library;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class LibraryDaoTest {


    @Autowired
    LibraryDao libraryDaoItem;

    @Test
    public void insertBookTest() throws Exception {
        queryAllTest();
        Library book = new Library(9,"Book9",4, new Date());
        System.out.println(libraryDaoItem.insertBook(book));
        queryAllTest();
    }
    @Test
    public void queryBooksByBookName() throws Exception {
        System.out.println(libraryDaoItem.queryBooksByBookName("book4"));

    }
    @Test
    public void deleteBookByBookIdTest() throws Exception {
        queryAllTest();
        System.out.println(libraryDaoItem.deleteBookByBookId(9));
        queryAllTest();
    }

    @Test
    public void updateBookByBookIdTest() throws Exception {
        queryAllTest();
        System.out.println(libraryDaoItem.updateBookByBookId(3,2,new Date()));
        queryAllTest();
    }

    @Test
    public void queryBookByBookIdTest() throws Exception {
        System.out.println(libraryDaoItem.queryBookByBookId(2));
    }

    @Test
    public void queryBooksByStudentIdTest() throws Exception {
        System.out.println(libraryDaoItem.queryBooksByStudentId(2));
    }

    @Test
    public void queryAllTest() throws Exception {
        System.out.println(libraryDaoItem.queryAll());
    }

}