package jo.za.services;

import jo.za.entities.Book;
import jo.za.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }

    // methods for registering new books

    public Book registerNewBow(Book book){

        return this.bookRepository.save(book);
    }

    public void registerListOfBooks(List<Book> booksToRegister){

        for(int i = 0; i < booksToRegister.size(); i++){

            Book book = booksToRegister.get(i);

            this.bookRepository.save(book);
        }
    }

    // delete a book

    public void deleteBook(long id){

        this.bookRepository.deleteById(id);
    }

    // get methods

    public List<Book> getAllBooks(){

        return this.bookRepository.findAll();
    }

    public Book getById(long id){

        return this.bookRepository.findById(id).get();
    }

    public List<Book> getByGenre(String genre){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByGenre = new ArrayList<>();

        for(Book book : allBooks){

            if(book.getGenre().contains(genre)){

                booksByGenre.add(book);
            }
        }

        return booksByGenre;
    }

    public List<Book> getByAvailability(boolean available){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByAvailability = new ArrayList<>();

        for(Book book : allBooks){

            if(book.isAvailable() == available){

                booksByAvailability.add(book);
            }
        }

        return booksByAvailability;
    }

    // search methods

    public List<Book> searchByTitle(String searchInput){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByTitleSearch = new ArrayList<>();

        for(int i = 0; i < allBooks.size(); i++){

            Book book = allBooks.get(i);

            if(book.getTitle().contains(searchInput)){

                booksByTitleSearch.add(book);
            }
        }

        return booksByTitleSearch;
    }

    public List<Book> searchByAuthor(String searchInput){

        List<Book> allBooks = getAllBooks();
        List<Book> booksByAuthorSearch = new ArrayList<>();

        for(int i = 0; i < allBooks.size(); i++){

            Book book = allBooks.get(i);

            if(book.getAuthor().contains(searchInput)){

                booksByAuthorSearch.add(book);
            }
        }

        return booksByAuthorSearch;
    }
}