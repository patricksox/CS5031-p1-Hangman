import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 */
// The game state
public class GameState {
    public String word; // letters
    public int guessTime; // the time that user have used to guess the answer
    public int guessRemain; // the remain time that user can guess the answer
    public int hint; // the hint that user have used

    ArrayList<Character> gotWord; //the letter that user has guessed right
    ArrayList<Character> notInArray; //check the target letter whether has been recorded in the array

    public Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public GameState(String target, int maxGuesses, int maxHints) {
        this.word = target;
        notInArray = new ArrayList<Character>();
        gotWord = new ArrayList<Character>();

        for (int i = 0; i < target.length(); ++i) {
            if (!notInArray.contains(Character.toLowerCase(target.charAt(i))))
                notInArray.add(Character.toLowerCase(target.charAt(i)));
        }
        //System.out.println(missing);

        this.guessTime = 0; // guesses made
        guessRemain = maxGuesses; // guesses remaining
        this.hint = maxHints;
    }

//    public String getTargetWord(String word){
//        String record = null;
//
//        for (int i = 0; i < word.length(); ++i) {
//
//            if (gotWord.contains(word.charAt(i))) {
//                System.out.println(word.charAt(i));
//            } else {
//                System.out.print("-");
//                record += "-"；
//            }
//        }
//        return record;
//    }

    /*
     * display the word to user
     *
     * */
    void showWord(String word) {
        for (int i = 0; i < word.length(); ++i) {

            if (gotWord.contains(word.charAt(i))) {
                System.out.println(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
//            System.out.println(" ");
//         System.out.println("missing");
    }

    /*
     * let user guess the letter
     *
     * */
    boolean guessLetter() {
        int i;
        char letter;

        System.out.print("Guess a letter or word (? for a hint): ");

        String str = sc.next().toLowerCase();

        if (str.length() > 1) {
            if (str == word) {
                notInArray.clear();
                return true;
            } else return false;
        }

        letter = str.charAt(0);

        if (letter == '?') {
            hint();
            return false;
        }

        for (i = 0; i < notInArray.size(); ++i) { // Loop over the notInArray, gotWord
            if (notInArray.get(i) == letter) {
                notInArray.remove(i);
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
        if (notInArray.size() == 0) return true;
        else return false;
    }

    boolean lost() {
        if (notInArray.size() > 0 && guessRemain == 0) return true;
        else return false;
    }

    private void hint() {
        if (hint == 0) {
            System.out.println("No more hints allowed");
        } else {
            hint--;
            System.out.println("Hints left: " + hint);
            System.out.print("Try: ");
            System.out.println(notInArray.get((int) (Math.random() * notInArray.size())));
        }
    }
}
