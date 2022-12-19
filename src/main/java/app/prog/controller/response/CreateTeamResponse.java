package app.prog.controller.response;

import app.prog.model.PlayerEntity;
import app.prog.model.SponsorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CreateTeamResponse {
    private String name;
    private List<PlayerEntity> players;
    private List<SponsorEntity> sponsors;
}
