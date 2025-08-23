package com.toneki.gamelistbackend.repository;

import com.toneki.gamelistbackend.domain.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
}
