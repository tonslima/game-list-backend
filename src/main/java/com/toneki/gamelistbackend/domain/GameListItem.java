package com.toneki.gamelistbackend.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_game_list_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class GameListItem {

    @EmbeddedId
    private GameListItemId id = new GameListItemId();
    private Integer position;

    public GameListItem(Game game, GameList list, Integer position) {
        id.setGame(game);
    }
}
