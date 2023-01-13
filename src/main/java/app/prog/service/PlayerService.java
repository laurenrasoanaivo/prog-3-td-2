package app.prog.service;

import app.prog.model.PlayerEntity;
import app.prog.model.TeamEntity;
import app.prog.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public List<PlayerEntity> getPlayers() {
        return repository.findAll();
    }

    public List<PlayerEntity> getAllByTeam(TeamEntity team){
        return repository.findByTeam(team);
    }
}
