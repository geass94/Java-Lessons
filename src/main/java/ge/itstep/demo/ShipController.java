package ge.itstep.demo;

import ge.itstep.demo.dto.ShipDTO;
import ge.itstep.demo.dto.ShootDTO;
import ge.itstep.demo.model.Ship;
import ge.itstep.demo.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Filter;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ships")
public class ShipController {
    @Autowired
    private ShipRepository _shipRepository;

    @GetMapping("/")
    public ResponseEntity<List<ShipDTO>> Index() {
        List<Ship> ships = this._shipRepository.findAll();
        return ResponseEntity.of(Optional.of(ships.stream().map(s-> new ShipDTO(s.getId(),s.getCoords().get("x"),s.getCoords().get("y"),s.getLayout(),s.is_Sunk())).collect(Collectors.toList())));
    }
    @PostMapping("/")
    public Ship Create(@RequestBody ShipDTO ship) {
        Map<String, Integer> coords = new HashMap<>();
        coords.put("x", ship.coordx());
        coords.put("y", ship.coordy());
        Ship newShip = this._shipRepository.save(new Ship(ship.id(),coords,ship.layout(),ship.is_Sunk()));
        return newShip;
    }
    @PostMapping("/{shoot}")
    public boolean Shoot(@PathVariable String shoot, @RequestBody ShootDTO shooting) {
       List<Ship> ships = this._shipRepository.findAll();
       List<Ship> filteredShips = ships.stream().filter(s->s.getCoords().get("x") == shooting.x() && s.getCoords().get("y") == shooting.y()).collect(Collectors.toList());
       if(filteredShips.isEmpty())
           return false;
           else
               return true;
    }
}
