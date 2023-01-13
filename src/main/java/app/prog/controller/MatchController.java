package app.prog.controller;

import app.prog.controller.mapper.MatchRestMapper;
import app.prog.controller.response.MatchResponse;
import app.prog.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatchController {
    private final MatchService service;

    private final MatchRestMapper mapper;

    @GetMapping("/match")
    public List<MatchResponse> getPlayAgainst() {
        return service.getAllMatch().stream()
                .map(mapper::toRest)
                .toList();
    }

}
