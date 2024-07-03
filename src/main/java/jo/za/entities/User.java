package jo.za.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter

@Entity
@Table(name = "books")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private boolean isRenting;

    @OneToOne(mappedBy = "books")
    private Book bookRentingNow;

    @OneToMany(mappedBy = "users")
    private List<Rental> allRented;

    @OneToMany(mappedBy = "users")
    private List<Return> allReturned;
}