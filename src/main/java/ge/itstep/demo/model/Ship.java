package ge.itstep.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ships")
public class Ship {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    private Cords cords;
    @Getter
    @Setter
    @Column(name = "is_sunk")
    private boolean isSunk;
    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Getter
    @Setter
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updated_at;

    public Ship(Long id, Cords cords, boolean is_sunk) {
        this.id = id;
        this.cords = cords;
        this.isSunk = is_sunk;
    }
}
