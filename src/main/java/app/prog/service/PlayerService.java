package app.prog.service;

import app.prog.model.PlayerEntity;
import app.prog.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public List<PlayerEntity> getPlayers() {
        return repository.findAll();
    }

    public List<PlayerEntity> createPlayers(List<PlayerEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<PlayerEntity> updatePlayers(List<PlayerEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public PlayerEntity deletePlayer(int id) {
        Optional<PlayerEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Player." + id + " not found");
        }
    }
}
