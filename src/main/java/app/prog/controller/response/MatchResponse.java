package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatchResponse {
    private int id;
    private TeamResponse teamA;
    private TeamResponse teamB;
    private LocalDateTime dateTime;
    private List<ScoreResponse> scores;
    private int scoreTeamA;
    private int scoreTeamB;
}
