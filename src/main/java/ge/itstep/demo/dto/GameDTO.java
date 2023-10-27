package ge.itstep.demo.dto;


import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.Ship;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class GameDTO {
    public Long id;
    public List<Ship> ships;
    public int gridSize;
    @Getter
    public int hits;
    public UserDTO user;
    @Getter
    public boolean won;

    public String createdAt;


    public GameDTO(Game game) {
        this.id = game.getId();
        this.ships = game.getShips();
        this.gridSize = game.getGridSize();
        this.hits = game.getHits();
        this.user = new UserDTO(game.getUser());
        this.createdAt = game.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

}
