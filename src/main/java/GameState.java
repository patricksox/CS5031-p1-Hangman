import java.util.ArrayList;
import java.util.Scanner;

// The game state
public class GameState {
    public String word; // letters
    public int guessTime;
    public int guessRemain;
    public int hint;

    ArrayList<Character> gotWord;
    ArrayList<Character> notStored;

    public Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public GameState(String target, int maxGuesses, int maxHints) {
        this.word = target;
        notStored = new ArrayList<Character>();
        gotWord = new ArrayList<Character>();

        for (int i = 0; i < target.length(); ++i) {
            if (!notStored.contains(Character.toLowerCase(target.charAt(i))))
                notStored.add(Character.toLowerCase(target.charAt(i)));
        }
        //System.out.println(missing);

        this.guessTime = 0; // guesses made
        guessRemain = maxGuesses; // guesses remaining
        this.hint = maxHints;
    }

    void showWord(String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (gotWord.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println(" ");
        // System.out.println(missing);
    }

    boolean guessLetter() {
        int i;
        char letter;

        System.out.print("Guess a letter or word (? for a hint): ");

        String str = sc.next().toLowerCase();

        if (str.length() > 1) {
            if (str == word) {
                notStored.clear();
                return true;
            } else return false;
        }

        letter = str.charAt(0);

        if (letter == '?') {
            hint();
            return false;
        }

        for (i = 0; i < notStored.size(); ++i) { // Loop over the notStored gotWord
            if (notStored.get(i) == letter) {
                notStored.remove(i);
                gotWord.add(letter);
                guessTime++;
                return true;
            }
        }

        guessTime++; // One more guessTime
        guessRemain--;
        return false;
    }

    boolean won() {
        if (notStored.size() == 0) return true;
        else return false;
    }

    boolean lost() {
        if (notStored.size() > 0 && guessRemain == 0) return true;
        else return false;
    }

    private void hint() {
        if (hint == 0) {
            System.out.println("No more hints allowed");
        }

        System.out.print("Try: ");
        System.out.println(notStored.get((int) (Math.random() * notStored.size())));
    }
}
