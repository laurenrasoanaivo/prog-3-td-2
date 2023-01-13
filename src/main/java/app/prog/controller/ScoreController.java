package app.prog.controller;

import app.prog.controller.mapper.ScoreRestMapper;
import app.prog.controller.response.ScoreResponse;
import app.prog.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ScoreController {
    private final ScoreService service;

    private final ScoreRestMapper mapper;

    @GetMapping("/scores")
    public List<ScoreResponse> getAllScores() {
        return service.getAllScores().stream()
                .map(mapper::toRest)
                .toList();
    }

}
