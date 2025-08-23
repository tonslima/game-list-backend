package com.toneki.gamelistbackend.controller;

import com.toneki.gamelistbackend.domain.GameList;
import com.toneki.gamelistbackend.dto.ApiResponse;
import com.toneki.gamelistbackend.dto.GameListDTO;
import com.toneki.gamelistbackend.dto.GameMinDTO;
import com.toneki.gamelistbackend.projection.GameMinProjection;
import com.toneki.gamelistbackend.service.GameListService;
import com.toneki.gamelistbackend.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<GameListDTO>>> getAllGameLists() {
        List<GameList> gameList = gameListService.list();

        List<GameListDTO> gameListDTO = gameList.stream()
                .map(GameListDTO::new)
                .toList();

        return ResponseEntity.ok(ApiResponse.of(gameListDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameListDTO> getListById(@PathVariable Long id) {
        GameList gameList = gameListService.detail(id);

        GameListDTO gameListDTO = new GameListDTO(gameList);

        return ResponseEntity.ok(gameListDTO);
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<ApiResponse<List<GameMinDTO>>> getAllGamesByListId(@PathVariable Long id) {
        List<GameMinProjection> gamesMinProjection = gameService.findByList(id);

        List<GameMinDTO> gamesMinDTO = gamesMinProjection.stream()
                .map(GameMinDTO::new)
                .toList();

        return ResponseEntity.ok(ApiResponse.of(gamesMinDTO));
    }
}
