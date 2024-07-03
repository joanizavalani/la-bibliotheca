package jo.za.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter

@Entity
@Table(name = "members")

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phoneNumber;

    private boolean isRenting;

    @OneToOne
    private Book bookRentingNow;

    @OneToMany(mappedBy = "member")
    private List<Rental> allRented;

    @OneToMany(mappedBy = "member")
    private List<Return> allReturned;
}