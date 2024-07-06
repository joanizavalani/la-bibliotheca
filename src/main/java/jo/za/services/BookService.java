package jo.za.services;

import jo.za.entities.Book;
import jo.za.entities.Member;
import jo.za.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    // methods for registering new books

    public Book registerNewBow(Book book){

        return this.bookRepository.save(book);
    }

    public List<Book> registerListOfBooks(List<Book> booksToRegister){

        return this.bookRepository.saveAll(booksToRegister);
    }

    // delete a book

    public void deleteBook(long id){

        this.bookRepository.deleteById(id);
    }

    // get methods

    public List<Book> getAllBooks(){

        return this.bookRepository.findAll();
    }

    public Book getBookById(long id){

        return this.bookRepository.findById(id).get();
    }

    public List<Book> getBooksByAvailability(boolean available){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByAvailability = new ArrayList<>();

        for(Book book : allBooks) {

            if(book.isAvailable() == available) {

                booksByAvailability.add(book);
            }
        }

        return booksByAvailability;
    }

    public List<Book> getBooksByGenre(String genre){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByGenre = new ArrayList<>();

        String genreToLowerCase = genre.toLowerCase();

        for(Book book : allBooks) {

            if(book.getGenre().toLowerCase().contains(genreToLowerCase)){

                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }

    // search methods

    public List<Book> searchBookByTitle(String searchInput){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByTitleSearch = new ArrayList<>();

        String lowerCaseSearchInput = searchInput.toLowerCase();

        for(Book book : allBooks){

            if(book.getTitle().toLowerCase().contains(lowerCaseSearchInput)){

                booksByTitleSearch.add(book);
            }
        }

        return booksByTitleSearch;
    }

    public List<Book> searchBookByAuthor(String searchInput){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByAuthorSearch = new ArrayList<>();

        String lowerCaseSearchInput = searchInput.toLowerCase();

        for(Book book : allBooks) {

            if(book.getAuthor().toLowerCase().contains(lowerCaseSearchInput)){

                booksByAuthorSearch.add(book);
            }
        }

        return booksByAuthorSearch;
    }
}