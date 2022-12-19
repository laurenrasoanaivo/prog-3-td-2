package app.prog.controller.response;

import app.prog.model.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlayAgainstResponse {
    private int id;
    private TeamEntity team1;
    private TeamEntity team2;
    private LocalDateTime dateTime;
}
