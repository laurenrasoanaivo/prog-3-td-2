package app.prog.controller.mapper;

import app.prog.controller.response.CreateTeamResponse;
import app.prog.controller.response.TeamResponse;
import app.prog.controller.response.UpdateTeamResponse;
import app.prog.model.TeamEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeamRestMapper {
    private final PlayerRestMapper mapper;

    public TeamResponse toRest(TeamEntity domain) {
        return TeamResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .players(domain.getPlayers().stream().map(mapper::toRest).toList())
                .sponsors(domain.getSponsors())
                .build();
    }

    public TeamEntity toDomain(CreateTeamResponse rest) {
        return TeamEntity.builder()
                .name(rest.getName())
                .players(rest.getPlayers())
                .sponsors(rest.getSponsors())
                .build();
    }

    public TeamEntity toDomain(UpdateTeamResponse rest) {
        return TeamEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .players(rest.getPlayers())
                .sponsors(rest.getSponsors())
                .build();
    }
}
