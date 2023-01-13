package app.prog.service;

import app.prog.model.MatchEntity;
import app.prog.model.ScoreEntity;
import app.prog.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public List<ScoreEntity> getByMatch(MatchEntity match){
        return scoreRepository.findByMatch(match);
    }

    public List<ScoreEntity> getAllScores(){
        List<ScoreEntity> scores = scoreRepository.findAll();
        for(int i=0; i<scores.size(); i++){
            if(Objects.equals(scores.get(i).getPlayer().getPost(), "goal")){
                scores.remove(scores.get(i));
            } else if(scores.get(i).getTimes() > 90){
                scores.remove(scores.get(i));
            } else if(scores.get(i).getPlayer().getTeam() != scores.get(i).getMatch().getTeamA() && scores.get(i).getPlayer().getTeam() != scores.get(i).getMatch().getTeamB()){
                scores.remove(scores.get(i));
            }
        }
        return scores;
    }

}
