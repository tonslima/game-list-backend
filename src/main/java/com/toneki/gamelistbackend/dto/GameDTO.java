package com.toneki.gamelistbackend.dto;

import com.toneki.gamelistbackend.domain.Game;

public record GameDTO(
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String shortDescription,
        String longDescription
) {
    public GameDTO(Game game) {
        this(
                game.getTitle(),
                game.getYear(),
                game.getGenre(),
                game.getPlatforms(),
                game.getScore(),
                game.getImgUrl(),
                game.getShortDescription(),
                game.getLongDescription()
        );
    }
}
