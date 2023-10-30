package ge.itstep.demo.dto;

import ge.itstep.demo.model.Cords;

public record ShipDTO(Long id, Cords cords, boolean is_sunk) {
}
