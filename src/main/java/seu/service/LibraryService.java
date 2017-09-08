package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.dao.LibraryDao;
import seu.domain.Library;

import java.util.List;
@Service
public class LibraryService {

    @Autowired
    LibraryDao libraryuser;

    public LibraryDao getAdministrator() {
        return libraryuser;
    }

    public void setAdministrator(LibraryDao administrator) {
        this.libraryuser = administrator;
    }

    public void addBook(final Library book){
        //return libraryuser.addBook(book);
    }


    public void deleteLibraryById(int id) {
       // return libraryuser.deleteLibraryById(id);
    }

    public void deleteLibraryByName(String name) {
       // return libraryuser.deleteLibraryByName(name);
    }

    public void updateBookNameById(final int id, final String name) {
       // return libraryuser.updateBookNameById(id,name);
    }


    public List<Library> queryBooksByStudentId(final int id) {
        return libraryuser.queryBooksByStudentId(id);
    }

    public List<Library> queryAll() {
        return libraryuser.queryAll();
    }
}
