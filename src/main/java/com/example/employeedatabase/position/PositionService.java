package com.example.employeedatabase.position;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getPosition() {
        return positionRepository.findAll();
    }

    public void addNewPosition(Position position) {
        positionRepository.save(position);
    }

    public void deletePosition(Long positionId) {
        boolean exists = positionRepository.existsById(positionId);

        if (!exists) {
            throw new IllegalStateException("Position with id " + positionId + " does not exists");
        }

        positionRepository.deleteById(positionId);
    }

    @Transactional
    public void updatePosition(Long positionId, String positionName, Integer salary) {
        Position position = positionRepository.findById(positionId).orElseThrow(
                () -> new IllegalStateException(
                        "Position with id " + positionId + " does not exists"));

        if (positionName != null && positionName.length() > 0
                && !Objects.equals(position.getPositionName(), positionName)) {
            position.setPositionName(positionName);
        }
        
        if (salary != null && salary > 0) {
            position.setSalary(salary);
        }
    }
}
