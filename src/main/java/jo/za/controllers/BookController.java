package jo.za.controllers;

import jo.za.entities.Book;
import jo.za.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/book")

public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){

        this.bookService = bookService;
    }

    // methods for registering new books

    @PostMapping("/register")
    public Book registerNewBook(@RequestBody Book book){

        return this.bookService.registerNewBow(book);
    }

    @PostMapping("/register-many")
    public List<Book> registerListOfBooks(@RequestBody List<Book> booksToRegister){

        return this.bookService.registerListOfBooks(booksToRegister);
    }

    // delete a book

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable("id") long id){

        this.bookService.deleteBook(id);
    }

    // get methods

    @GetMapping("/all")
    public List<Book> getAllBooks(){

        return this.bookService.getAllBooks();
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable("id") long id){

        return this.bookService.getBookById(id);
    }

    @GetMapping("/available/{available}")
    public List<Book> getBookByAvailability(@PathVariable("available") boolean available){

        return this.bookService.getBooksByAvailability(available);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable("genre") String genre){

        return this.bookService.getBooksByGenre(genre);
    }

    // search methods

    @GetMapping("/search/title/{search-input}")
    public List<Book> searchBookByTitle(@PathVariable("search-input") String searchInput){

        return this.bookService.searchBookByTitle(searchInput);
    }

    @GetMapping("/search/author/{search-input}")
    public List<Book> searchBookByAuthor(@PathVariable("search-input") String searchInput){

        return this.bookService.searchBookByAuthor(searchInput);
    }
}