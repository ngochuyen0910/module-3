package service.position;

import model.Position;
import repository.position.IPositionRepository;
import repository.position.PositionRepository;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository positionRepository= new PositionRepository();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
