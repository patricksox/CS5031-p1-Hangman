import java.util.Scanner;

public class Hangman {

    private static void setGame(Scanner sc, CommandOpts opts) {

        boolean correct;

        GameState state;
        if (opts.wordSource.equals("")) {

            System.out.println("  1. Counties");
            System.out.println("  2. Countries");
            System.out.println("  3. Cities");

            System.out.print("Pick a category:");

            state = new GameState(Words.randomWord(sc.nextInt()), opts.maxGuesses, opts.maxHints);
        } else {
            state = new GameState(Words.randomWord(opts.wordSource), opts.maxGuesses, opts.maxHints);
        }

        while (!state.won() && !state.lost()) {
            state.showWord(state.word);

            System.out.println("Guesses remaining: " + state.guessRemain);

            correct = state.guessLetter();

            if (correct) System.out.println("Good guess!");
            if (!correct) System.out.println("Wrong guess!");
        }

        if (state.won()) {
            System.out.println("Well done!");
            System.out.println("You took " + state.guessTime + " guesses");
        } else {
            System.out.println("You lost! The word was " + state.word);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        GameState state = null;
        CommandOpts opts;


        opts = new CommandOpts(args);

        setGame(sc, opts);

    }
}
