package com.toneki.gamelistbackend.service;

import com.toneki.gamelistbackend.domain.Game;
import com.toneki.gamelistbackend.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private  final GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }
}
