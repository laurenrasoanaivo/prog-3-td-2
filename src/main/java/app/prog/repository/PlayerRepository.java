package app.prog.repository;

import app.prog.model.PlayerEntity;
import app.prog.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    List<PlayerEntity> findByTeam(TeamEntity team);
}
