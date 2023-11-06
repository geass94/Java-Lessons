package ge.itstep.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Primary;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    @Column(name = "full_name")
    private String fullName;
    @Getter
    @Setter
    @Column(name = "power")
    private int power;
}
