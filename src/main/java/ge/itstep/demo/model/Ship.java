package ge.itstep.demo.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Ships")
public class Ship {
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ElementCollection
    @MapKeyColumn(name = "coord_key")
    @Column(name = "coord_value")
    private Map<String, Integer> coords = new HashMap<>();
    @Getter
    @Setter
    @Column(name = "Layout")
    private String layout;
    @Getter
    @Setter
    @Column(name = "Is_Sunk")
    private boolean is_Sunk;
    @Getter
    @Setter
    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;
    @Getter
    @Setter
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public Ship(Long id, Map<String, Integer> coords, String layout, Boolean sunk) {
        this.coords = coords;
        this.layout = layout;
        this.is_Sunk = sunk;
    }


    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", coords=" + coords +
                ", layout='" + layout + '\'' +
                ", is_Sunk=" + is_Sunk +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
