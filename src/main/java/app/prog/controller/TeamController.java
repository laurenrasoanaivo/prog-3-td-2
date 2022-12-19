package app.prog.controller;

import app.prog.controller.mapper.TeamRestMapper;
import app.prog.controller.response.CreateTeamResponse;
import app.prog.controller.response.TeamResponse;
import app.prog.controller.response.UpdateTeamResponse;
import app.prog.model.TeamEntity;
import app.prog.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService service;

    private final TeamRestMapper mapper;

    @GetMapping("/teams")
    public List<TeamResponse> getTeams() {
        return service.getTeams().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/teams")
    public List<TeamResponse> createBooks(@RequestBody List<CreateTeamResponse> toCreate) {
        List<TeamEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createTeams(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/teams")
    public List<TeamResponse> updateBooks(@RequestBody List<UpdateTeamResponse> toUpdate) {
        List<TeamEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateTeams(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/teams/{id}")
    public TeamResponse deleteBook(@PathVariable int id) {
        return mapper.toRest(service.deleteTeam(id));
    }
}
