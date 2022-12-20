package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "play_against")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayAgainst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private TeamEntity team1;
    @ManyToOne
    private TeamEntity team2;
    private LocalDateTime dateTime;
    private String stadium;
}
