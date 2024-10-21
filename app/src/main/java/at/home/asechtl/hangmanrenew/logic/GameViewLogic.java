package at.home.asechtl.hangmanrenew.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import at.home.asechtl.hangmanrenew.database.GuessWord;

public class GameViewLogic {
    public String getRandomWord(List<GuessWord> list){
        Random random = new Random();
        int ran = random.nextInt(list.size());
        return list.get(ran).getWordToGuess();
    }

    public String getUnderScoreSymbols(String word){
        char[] guess = word.toCharArray();
        int temp = guess.length;
        String line = "";
        for (int i = 0; i < temp; i++){
            line = line + "_ ";
        }
        return line;
    }
    public char[] checkCorrectGuess(String word,char guessLetter){
        char[] guess = word.toCharArray();
        char[] location = new char[guess.length];
        for (int i = 0; i < guess.length; i ++ ){
            char temp = guess[i];
            if (temp == guessLetter){
                location[i] = temp;
            }

        }
        return location;
    }
    public String updateGuessWord(String word,char[]location){
        char[]actualWord = word.toCharArray();
        String line = "";

        for (int i = 0; i < actualWord.length; i++){
            if (location[i] == actualWord[i]){
                line = line + actualWord[i] + " ";
            }else{
                line = line + "_ ";
            }
        }


        return line;
    }
}
