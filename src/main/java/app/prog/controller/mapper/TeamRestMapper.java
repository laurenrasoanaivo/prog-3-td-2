package app.prog.controller.mapper;

import app.prog.controller.response.TeamResponse;
import app.prog.model.TeamEntity;
import app.prog.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamRestMapper {
    private final PlayerRestMapper mapper;
    private final PlayerService playerService;

    public TeamResponse toRest(TeamEntity domain) {
        return TeamResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .players(playerService.getAllByTeam(domain).stream().map(mapper::toRest).toList())
                .sponsors(domain.getSponsors())
                .build();
    }

}
