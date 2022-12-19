package app.prog.service;

import app.prog.model.PlayAgainst;
import app.prog.repository.PlayAgainstRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayAgainstService {
    private final PlayAgainstRepository repository;

    public List<PlayAgainst> getPlayAgainst() {
        return repository.findAll();
    }

    public List<PlayAgainst> createPlayAgainst(List<PlayAgainst> toCreate) { return repository.saveAll(toCreate); }

    public List<PlayAgainst> updatePlayAgainst(List<PlayAgainst> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public PlayAgainst deletePlayAgainst(int id) {
        Optional<PlayAgainst> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PlayAgainst." + id + " not found");
        }
    }
}
