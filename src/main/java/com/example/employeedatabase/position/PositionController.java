package com.example.employeedatabase.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getPosition() {
        return positionService.getPosition();
    }

    @PostMapping
    public void registerNewPosition(@RequestBody Position position) {
        positionService.addNewPosition(position);
    }

    @DeleteMapping(path="{positionId}")
    public void deletePosition(@PathVariable("positionId") Long positionId) {
        positionService.deletePosition(positionId);
    }

    @PutMapping(path="{positionId}")
    public void updatePosition(
            @PathVariable("positionId") Long positionId,
            @RequestParam(required = false) String positionName,
            @RequestParam(required = false) Integer salary) {
        positionService.updatePosition(positionId, positionName, salary);
    }
}
