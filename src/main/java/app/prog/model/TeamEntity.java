package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "team")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany
    @OrderBy("number")
    @JoinTable(
            name = "team_player",
            joinColumns = @JoinColumn(name = "id_team"),
            inverseJoinColumns = @JoinColumn(name = "id_player"))
    private List<PlayerEntity> players;
    @ManyToMany
    @JoinTable(
            name = "team_sponsor",
            joinColumns = @JoinColumn(name = "id_team"),
            inverseJoinColumns = @JoinColumn(name = "id_sponsor"))
    private List<SponsorEntity> sponsors;
}
