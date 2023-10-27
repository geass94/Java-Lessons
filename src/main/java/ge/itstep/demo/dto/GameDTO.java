package ge.itstep.demo.dto;


import ge.itstep.demo.model.Game;
import ge.itstep.demo.model.Ship;

import java.util.List;

public class GameDTO {
    public Long id;
    public List<Ship> ships;
    public int gridSize;
    public int hits;
    public UserDTO user;

    public GameDTO(Long id, List<Ship> ships, int gridSize, int hits, UserDTO user) {
        this.id = id;
        this.ships = ships;
        this.gridSize = gridSize;
        this.hits = hits;
        this.user = user;
    }

    public GameDTO(Game game) {
        this.id = game.getId();
        this.ships = game.getShips();
        this.gridSize = game.getGridSize();
        this.hits = game.getHits();
        this.user = new UserDTO(game.getUser());
    }
}
