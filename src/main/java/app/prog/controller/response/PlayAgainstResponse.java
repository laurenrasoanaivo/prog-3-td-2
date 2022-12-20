package app.prog.controller.response;

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
    private TeamResponse team1;
    private TeamResponse team2;
    private LocalDateTime dateTime;
}
