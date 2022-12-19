package app.prog.controller;

import app.prog.controller.mapper.PlayAgainstRestMapper;
import app.prog.controller.response.CreatePlayAgainstResponse;
import app.prog.controller.response.PlayAgainstResponse;
import app.prog.controller.response.UpdatePlayAgainstResponse;
import app.prog.model.PlayAgainst;
import app.prog.service.PlayAgainstService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayAgainstController {
    private final PlayAgainstService service;

    private final PlayAgainstRestMapper mapper;

    @GetMapping("/match")
    public List<PlayAgainstResponse> getPlayAgainst() {
        return service.getPlayAgainst().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/match")
    public List<PlayAgainstResponse> createPlayAgainst(@RequestBody List<CreatePlayAgainstResponse> toCreate) {
        List<PlayAgainst> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createPlayAgainst(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/match")
    public List<PlayAgainstResponse> updatePlayAgainst(@RequestBody List<UpdatePlayAgainstResponse> toUpdate) {
        List<PlayAgainst> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updatePlayAgainst(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/match/{id}")
    public PlayAgainstResponse deletePlayAgainst(@PathVariable int id) {
        return mapper.toRest(service.deletePlayAgainst(id));
    }
}
