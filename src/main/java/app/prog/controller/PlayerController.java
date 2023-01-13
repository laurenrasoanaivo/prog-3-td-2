package app.prog.controller;

import app.prog.controller.mapper.PlayerRestMapper;
import app.prog.controller.response.PlayerResponse;
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

}
