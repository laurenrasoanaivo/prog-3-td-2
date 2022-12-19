package app.prog.controller.mapper;

import app.prog.controller.response.PlayerResponse;
import app.prog.controller.response.CreatePlayerResponse;
import app.prog.controller.response.UpdatePlayerResponse;
import app.prog.model.PlayerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlayerRestMapper {

    public PlayerResponse toRest(PlayerEntity domain) {
        return PlayerResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public PlayerEntity toDomain(CreatePlayerResponse rest) {
        return PlayerEntity.builder()
                .name(rest.getName())
                .build();
    }

    public PlayerEntity toDomain(UpdatePlayerResponse rest) {
        return PlayerEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }
}
