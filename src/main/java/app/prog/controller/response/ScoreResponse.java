package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ScoreResponse {
    private int id;
    private int matchId;
    private PlayerResponse player;
    private int times;
    private Boolean isOS;
}
