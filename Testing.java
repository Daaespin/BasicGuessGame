import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {
    
    @Test
    public void testCorrectGuess() {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
        assertEquals(1, game.getAttempts());
    }

    public void getNumberToGuess() {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
        assertEquals(1, game.getAttempts());
       
        }
    public void getAttempts() {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
        assertEquals(1, game.getAttempts());
        
    }
}
