package m.assignment.nl22w;

import com.assignment.nl22w.game.Game;
import com.assignment.nl22w.game.impl.GameImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class TestMaps {

    @Autowired
    private Game game = new GameImpl();

    @Test
    public void map1ShouldReturnFour() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/map1.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(4);
    }

    @Test
    public void map2ShouldReturnThirteen() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/map2.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(13);
    }

    @Test
    public void noExitMapShouldReturnZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/noExitMap.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

    @Test
    public void shorterThanFiveOrLongerThanMaxGivenMapShouldReturnZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/shorterThan5BlocksMap.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

    @Test
    public void corruptMapShouldReturnZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/corruptMap.pdf");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

    @Test
    public void longerOrShorterLineThanOthersMapShouldReturnZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/longerLineThanOthersMap.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

    @Test
    public void differentSymbolsOtherThanX_ĄMapShouldReturnsZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/differentSymbolsMap.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }
    @Test
    public void differentSymbolsWithX_1MapShouldReturnsZero() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/differentSymbolsWithX_1Map.txt.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

    @Test
    public void fileNotFound() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:maze/fileNotFound.txt");
        int shortestPath = game.escapeFromTheWoods(resource);
        Assertions.assertThat(shortestPath).isEqualTo(0);
    }

}
