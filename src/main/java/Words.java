import java.io.*;
import java.util.ArrayList;

public class Words {

    static String[] counties = {"Argyll and Bute", "Caithness", "Kingdom of Fife",
            "East Lothian", "Highland", "Dumfries and Galloway",
            "Renfrewshire", "Scottish Borders", "Perth and Kinross"};
    static String[] countries = {"Scotland", "England", "Wales", "Northern Ireland", "Ireland",
            "France", "Germany", "Netherlands", "Spain", "Portugal",
            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece"};
    static String[] cities = {"St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk"};
    static String[] others = {"Out of range"};

    static ArrayList<String> customWords;

    public static String randomWord(int category) {

        if (category == 1) {
            return counties[(int) (Math.random() * 9)];
        } else if (category == 2) {
            return countries[(int) (Math.random() * 15)];
        } else if (category == 3) {
            return cities[(int) (Math.random() * 10)];
        } else {
            int random = (int) (Math.random() * 3);
            System.out.println("Out of range and give you random category: " + random);
            if (random == 1) {
                return counties[(int) (Math.random() * 9)];
            } else if (random == 2) {
                return countries[(int) (Math.random() * 15)];
            } else {
                return cities[(int) (Math.random() * 10)];
            }
        }
    }

    public static String randomWord(String wordSource) {
        String line;
        customWords = new ArrayList<String>();

        try {
            FileReader file = new FileReader(wordSource);
            BufferedReader reader = new BufferedReader(file);
            while ((line = reader.readLine()) != null) {
                customWords.add(line);
            }
            return customWords.get((int) (Math.random() * customWords.size()));
        } catch (FileNotFoundException e) {
            System.out.println("File error");
            return "";
        } catch (IOException e) {
            System.out.println("IO error");
            return "";
        }
    }
}
