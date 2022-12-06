package com.assignment.nl22w;

import com.assignment.nl22w.game.interfaces.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

class GameApplicationTest {

    private Game game = new GameImpl();

    @Test
    void main() throws  IOException{
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/map1.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        org.assertj.core.api.Assertions.assertThat(shortestPath).isEqualTo(4);
    }
}

