package se.b3.kodtest.montyhall.Service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceImplTest {

    @Autowired
    GameService gameService;

    @Test
    public void testSimulationIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                gameService.startSimulation(-1),"Amount under 1");

        assertEquals(exception.getMessage(),"Amount under 1");
    }

    @Test
    public void testSimulationSuccess(){
        gameService = Mockito.mock(GameService.class);
        String[] expected = {"Staying:Amount of wins 3349, with 33.49% chance",
                "SwitchingAmount of wins 6651, with 66.51% chance"};
        Mockito.when(gameService.startSimulation(Mockito.anyInt())).thenReturn(expected);
        String[] response = gameService.startSimulation(Mockito.anyInt());
        assertEquals(expected, response);

    }
}