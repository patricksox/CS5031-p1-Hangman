import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class GameStateTest {

    //GameState initialization for all test below

    GameState gState = new GameState("Argyll and Bute", 10, 2);//counties value
    GameState gState2 = new GameState("Scotland", 10, 2); //countries value
    GameState gState3 = new GameState("St Andrews", 10, 2); //cities value

    CommandOpts opts;
    Words words = new Words();
    ByteArrayOutputStream msg = new ByteArrayOutputStream();
    
    @Test
    public void GameStateTest() {


        //check for equality
        assertEquals(10, gState.guessRemain);
        assertEquals(2, gState.hint);

        //check for false condition
        assertFalse(gState.guessRemain > 10);
        assertFalse(gState.hint > 2);

        //check for not null value
        assertNotNull(gState.word);
        assertNotNull(gState2.word);
        assertNotNull(gState3.word);
    }
//        fail("Not yet implemented");


    @Test
    public void showWordTest() {
//        if (opts.wordSource.equals("")) {
//            GameState state = new GameState(Words.randomWord(1), 10, 2);
//        }
        GameState state2 = new GameState(Words.randomWord(1), 10, 2);
        state2.showWord(state2.word);
//        System.out.println(msg.toString());

        assertNotNull(msg.toString());

    }

}
