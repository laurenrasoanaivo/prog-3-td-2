package app.prog.controller.mapper;

import app.prog.controller.response.ScoreResponse;
import app.prog.model.ScoreEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScoreRestMapper {
    private PlayerRestMapper playerRestMapper;

    public ScoreResponse toRest(ScoreEntity rest){
        return ScoreResponse.builder()
                .id(rest.getId())
                .matchId(rest.getMatch().getId())
                .player(playerRestMapper.toRest(rest.getPlayer()))
                .times(rest.getTimes())
                .isOS(rest.getIsOS())
                .build();
    }
}
