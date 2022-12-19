package app.prog.controller.response;

import app.prog.model.SponsorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeamResponse {
    private int id;
    private String name;
    private List<PlayerResponse> players;
    private List<SponsorEntity> sponsors;
}
