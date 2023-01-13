package app.prog.service;

import app.prog.model.MatchEntity;
import app.prog.model.ScoreEntity;
import app.prog.repository.MatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MatchService {
    private final MatchRepository repository;
    private final ScoreService scoreService;

    public List<MatchEntity> getAllMatch() {
        return repository.findAll();
    }

    public List<ScoreEntity> scores(MatchEntity match){
        List<ScoreEntity> scores = scoreService.getAllScores();
        List<ScoreEntity> matchScore = new ArrayList<>();
        for (ScoreEntity score : scores) {
            if (score.getMatch() == match)
                matchScore.add(score);
        }
        return matchScore;
    }

    public int scoreTeamA(MatchEntity match){
        List<ScoreEntity> scores = scores(match);
        int scoreTeamA = 0;
        for (ScoreEntity score : scores) {
            if (score.getPlayer().getTeam() == match.getTeamA() && score.getIsOS()) {
                scoreTeamA++;
            } else if (score.getPlayer().getTeam() == score.getMatch().getTeamB() && !score.getIsOS()) {
                scoreTeamA++;
            }

        }
        return scoreTeamA;
    }

    public int scoreTeamB(MatchEntity match){
        List<ScoreEntity> scores = scores(match);
        int scoreTeamB = 0;
        for (ScoreEntity score : scores) {
            if (score.getPlayer().getTeam() == match.getTeamA() && !score.getIsOS()) {
                scoreTeamB++;
            } else if (score.getPlayer().getTeam() == score.getMatch().getTeamB() && score.getIsOS()) {
                scoreTeamB++;
            }

        }
        return scoreTeamB;
    }

}
