package app.prog.controller;

import app.prog.model.SponsorEntity;
import app.prog.service.SponsorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SponsorController {
    private final SponsorService service;

    @GetMapping("/sponsors")
    public List<SponsorEntity> getSponsors() {
        return service.getCategories();
    }

    @PostMapping("/sponsors")
    public List<SponsorEntity> createSponsors(@RequestBody List<SponsorEntity> toCreate) {
        return service.createCategories(toCreate);
    }

    @DeleteMapping("/sponsors/{id}")
    public SponsorEntity deleteSponsor(@PathVariable int id) {
        return service.deleteCategory(id);
    }
}
