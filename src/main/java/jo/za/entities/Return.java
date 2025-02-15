package jo.za.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter

@Entity
@Table(name = "returns")

public class Return {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime returnedAt;

}