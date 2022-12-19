package app.prog.controller;

import app.prog.controller.mapper.PlayerRestMapper;
import app.prog.controller.response.CreatePlayerResponse;
import app.prog.controller.response.PlayerResponse;
import app.prog.controller.response.UpdatePlayerResponse;
import app.prog.model.PlayerEntity;
import app.prog.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {
    private final PlayerService service;

    private final PlayerRestMapper mapper;

    @GetMapping("/players")
    public List<PlayerResponse> getBooks() {
        return service.getPlayers().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/players")
    public List<PlayerResponse> createBooks(@RequestBody List<CreatePlayerResponse> toCreate) {
        List<PlayerEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createPlayers(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/players")
    public List<PlayerResponse> updateBooks(@RequestBody List<UpdatePlayerResponse> toUpdate) {
        List<PlayerEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updatePlayers(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/players/{id}")
    public PlayerResponse deleteBook(@PathVariable int id) {
        return mapper.toRest(service.deletePlayer(id));
    }
}
