package app.prog.repository;

import app.prog.model.MatchEntity;
import app.prog.model.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity, Integer> {
    List<ScoreEntity> findByMatch(MatchEntity match);
}
