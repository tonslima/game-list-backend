package com.toneki.gamelistbackend.controller;

import com.toneki.gamelistbackend.domain.Game;
import com.toneki.gamelistbackend.dto.GameMinDTO;
import com.toneki.gamelistbackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> list() {
        List<Game> games = gameService.findAll();

        List<GameMinDTO> gamesDTO = games.stream()
                .map(GameMinDTO::new)
                .toList();

        return ResponseEntity.ok(gamesDTO);
    }
}
