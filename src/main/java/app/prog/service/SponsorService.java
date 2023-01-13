package app.prog.service;

import app.prog.model.SponsorEntity;
import app.prog.repository.SponsorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SponsorService {
    private final SponsorRepository repository;

    public List<SponsorEntity> getCategories() {
        return repository.findAll();
    }

}
