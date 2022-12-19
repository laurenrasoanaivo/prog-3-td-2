package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Builder
public class UpdatePlayAgainstResponse {
    private int id;
    private int id_team1;
    private int id_team2;
    private LocalDateTime dateTime;
    private String stadium;
}
