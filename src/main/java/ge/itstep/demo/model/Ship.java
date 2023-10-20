package ge.itstep.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_x")
    private int startX;
    @Column(name = "start_y")
    private int startY;
    @Column(name = "end_x")
    private int endX;
    @Column(name = "end_y")
    private int endY;
    @Column(name = "hits")
    private int hits = 0;
    @Column(name = "type")
    private ShipType type;

    public Ship() {
    }

    public Ship(Long id, int startX, int startY, int endX, int endY, int hits, ShipType type) {
        this.id = id;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.hits = hits;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }
}
