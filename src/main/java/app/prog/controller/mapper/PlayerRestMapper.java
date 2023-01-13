package app.prog.controller.mapper;

import app.prog.controller.response.PlayerResponse;
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
                .post(domain.getPost())
                .build();
    }

}
