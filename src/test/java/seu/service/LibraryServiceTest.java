package seu.service;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import seu.config.ApplicationContextConfig;
import seu.domain.Library;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ApplicationContextConfig.class)
public class LibraryServiceTest {
    @Autowired
    private LibraryService libraryService;
    @Test
    public void borrowBook() throws Exception {
        System.out.println(libraryService.borrowBook(1,20));
    }
    @Test
    public void reNewBook() throws Exception {
        System.out.println(libraryService.reNewBook(2));
    }
    @Test
    public void returnBook() throws Exception {
        System.out.println(libraryService.returnBook(2));
    }

    @Test
    public void getAllBookList() throws Exception {
        System.out.println(libraryService.getAllBookList(1));
    }

    @Test
    public void deleteBook() throws Exception {
        System.out.println(libraryService.deleteBook(8));
    }

    @Test
    public void getBookByBookId() throws Exception {
        System.out.println(libraryService.getBookByBookId(2));
    }

    @Test
    public void getBooksByStudentId() throws Exception {
        System.out.println(libraryService.getBooksByStudentId(2));
    }

    @Test
    public void updateBookByBookId() throws Exception {
        System.out.println(libraryService.updateBook(new Library(5,"book5",2,new Date())));
    }

    @Test
    public void getLibraryAll() throws Exception {
        System.out.println(libraryService.getLibraryAll());
    }

}