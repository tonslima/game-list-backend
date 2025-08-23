package com.toneki.gamelistbackend.service;

import com.toneki.gamelistbackend.domain.GameList;
import com.toneki.gamelistbackend.repository.GameListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameListService {

    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameList> list() {
        return gameListRepository.findAll();
    }

    @Transactional(readOnly = true)
    public GameList detail(Long id) {
        return gameListRepository.findById(id).get();
    }
}
