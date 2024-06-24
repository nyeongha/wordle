package wordle_minyeong;

import java.util.ArrayList;
import java.util.Random;

public class WordGenerate {
    public ArrayList<Character> getWord() {
        ArrayList<Character> word = new ArrayList<>();
        for(int i=0;i<4;i++)
            word.add((char) (new Random().nextInt(26) + 'A'));
        return word;

    }
}