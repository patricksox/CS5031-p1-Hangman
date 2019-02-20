import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptsTest {

	@Test
	public void optionsTest() {

        //test data
        String[] args = {"--guesses", "10", "--hints", "2", "words.txt"};
		CommandOpts opts = new CommandOpts(args);

        //check for equality
        assertEquals(10, opts.maxGuesses);
        assertEquals(2, opts.maxHints);
        assertEquals("words.txt", opts.wordSource);
	}

}
