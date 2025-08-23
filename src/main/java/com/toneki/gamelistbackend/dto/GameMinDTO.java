package com.toneki.gamelistbackend.dto;

import com.toneki.gamelistbackend.domain.Game;
import com.toneki.gamelistbackend.projection.GameMinProjection;

public record GameMinDTO(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {

    public GameMinDTO(Game game) {
        this(
                game.getId(),
                game.getTitle(),
                game.getYear(),
                game.getImgUrl(),
                game.getShortDescription());
    }
    public GameMinDTO(GameMinProjection projection) {
        this(
                projection.getId(),
                projection.getTitle(),
                projection.getYear(),
                projection.getImgUrl(),
                projection.getShortDescription()
        );
    }
}
