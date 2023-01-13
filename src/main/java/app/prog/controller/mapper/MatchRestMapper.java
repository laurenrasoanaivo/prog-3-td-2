package app.prog.controller.mapper;

import app.prog.controller.response.*;
import app.prog.model.MatchEntity;
import app.prog.service.MatchService;
import app.prog.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MatchRestMapper {
    private TeamRestMapper mapper;
    private ScoreRestMapper scoreRestMapper;
    private MatchService service;
    private ScoreService scoreService;

    public MatchResponse toRest(MatchEntity domain) {
        return MatchResponse.builder()
                .id(domain.getId())
                .teamA(mapper.toRest(domain.getTeamA()))
                .teamB(mapper.toRest(domain.getTeamB()))
                .dateTime(domain.getDateTime())
                .scores(scoreService.getByMatch(domain).stream().map(scoreRestMapper::toRest).toList())
                .scoreTeamA(service.scoreTeamA(domain))
                .scoreTeamB(service.scoreTeamB(domain))
                .build();
    }

}
