package ge.itstep.demo.controller;

import ge.itstep.demo.dto.CordsDTO;
import ge.itstep.demo.dto.ShipDTO;
import ge.itstep.demo.model.Ship;
import ge.itstep.demo.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    @Autowired
    ShipRepository shipRepository;

    @PostMapping("/")
    public ResponseEntity<Ship> Create(@RequestBody ShipDTO dto){
        Ship ship = shipRepository.save(new Ship(dto.id(), dto.cords(), dto.is_sunk()));
        return ResponseEntity.of(Optional.of(ship));
    }
    @GetMapping("/")
    public ResponseEntity<Boolean> shoot(@RequestBody CordsDTO cords){
        //logic
        Ship shipsOnCords = shipRepository.getByCordsXAndCordsY(cords.x(), cords.y());
        if (shipsOnCords != null){
            return ResponseEntity.of(Optional.of(true));
        }
        return ResponseEntity.of(Optional.of(false));
    }

}
