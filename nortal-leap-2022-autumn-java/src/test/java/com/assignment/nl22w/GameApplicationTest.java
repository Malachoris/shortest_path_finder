package com.assignment.nl22w;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.DescriptiveResource;
import org.springframework.core.io.Resource;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameApplicationTest {

    @Autowired
    private Game game = new GameImpl();

    @Test
    void main() throws  IOException{
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/map1.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        org.assertj.core.api.Assertions.assertThat(shortestPath).isEqualTo(4);
    }
}

/*
    @Autowired
    private Game game = new GameImpl();

    @Test
    public void map1ShouldReturnFour() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/map1.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(4);
    }*/
