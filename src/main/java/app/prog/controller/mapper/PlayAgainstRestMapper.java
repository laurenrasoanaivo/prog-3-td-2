package app.prog.controller.mapper;

import app.prog.controller.response.*;
import app.prog.model.PlayAgainst;
import app.prog.service.PlayAgainstService;
import app.prog.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayAgainstRestMapper {
    private final TeamService teamService;

    public PlayAgainstResponse toRest(PlayAgainst domain) {
        return PlayAgainstResponse.builder()
                .id(domain.getId())
                .team1(domain.getTeam1())
                .team2(domain.getTeam2())
                .dateTime(domain.getDateTime())
                .build();
    }

    public PlayAgainst toDomain(CreatePlayAgainstResponse rest) {
        return PlayAgainst.builder()
                .team1(teamService.getById(rest.getId_team1()))
                .team2(teamService.getById(rest.getId_team2()))
                .dateTime(rest.getDateTime())
                .stadium(rest.getStadium())
                .build();
    }

    public PlayAgainst toDomain(UpdatePlayAgainstResponse rest) {
        return PlayAgainst.builder()
                .team1(teamService.getById(rest.getId_team1()))
                .team2(teamService.getById(rest.getId_team2()))
                .dateTime(rest.getDateTime())
                .stadium(rest.getStadium())
                .build();
    }
}
