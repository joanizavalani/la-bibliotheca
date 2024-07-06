package jo.za.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter

@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String author;

    private String genre;

    private String publisher;

    private boolean available;

    @OneToOne
    private Member rentedBy;

    @OneToMany(mappedBy = "book")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "book")
    private List<Return> returns;

}