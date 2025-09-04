package com.toneki.gamelistbackend.service;

import com.toneki.gamelistbackend.domain.Game;
import com.toneki.gamelistbackend.projection.GameMinProjection;
import com.toneki.gamelistbackend.repository.GameListRepository;
import com.toneki.gamelistbackend.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Game detail(Long id) {
        return gameRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<GameMinProjection> findByList(Long id) {

        if(gameListRepository.findById(id).isPresent()) {
            return gameRepository.findByList(id);
        } else {
            throw new EntityNotFoundException("Game list with id:" + id + " not found");
        }
    }
}