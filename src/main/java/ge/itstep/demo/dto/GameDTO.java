package ge.itstep.demo.dto;


import ge.itstep.demo.model.Ship;

import java.util.List;

public class GameDTO {
    public Long id;
    public List<ShipDTO> ships;
    public int gridSize;
    public int hits;
    public UserDTO user;

    public GameDTO(Long id, List<ShipDTO> ships, int gridSize, int hits, UserDTO user) {
        this.id = id;
        this.ships = ships;
        this.gridSize = gridSize;
        this.hits = hits;
        this.user = user;
    }
}
