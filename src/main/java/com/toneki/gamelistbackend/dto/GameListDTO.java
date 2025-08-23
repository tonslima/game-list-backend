package com.toneki.gamelistbackend.dto;

import com.toneki.gamelistbackend.domain.GameList;

public record GameListDTO(
        Long id,
        String name
) {
    public GameListDTO(GameList gameList) {
        this(
                gameList.getId(),
                gameList.getName());
    }
}
