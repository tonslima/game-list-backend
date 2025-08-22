package com.toneki.gamelistbackend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_game_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
