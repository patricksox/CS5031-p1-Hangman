import static org.junit.Assert.*;

import org.junit.Test;

public class CommandOptsTest {

	@Test
	public void optionsTest() {
        String[] args = {"--guesses", "10", "--hints", "2", "words.txt"};
		CommandOpts opts = new CommandOpts(args);
        assertEquals(opts.maxguesses, 10);
        assertEquals(opts.maxhints, 2);
		assertEquals(opts.wordsource, "words.txt");

	}

}
