package at.home.asechtl.hangmanrenew.database;

import java.util.ArrayList;
import java.util.List;

import at.home.asechtl.hangmanrenew.enums.Difficulty;

public class GuessWord {
    private String wordToGuess;
    private Difficulty difficulty;
    private java.util.List<ListDatabase> listDatabase;

    public GuessWord(String wordToGuess, Difficulty difficulty) {
        this.wordToGuess = wordToGuess;
        this.difficulty = difficulty;

        listDatabase = new ArrayList<>();
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public void setWordToGuess(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<ListDatabase> getListDatabase() {
        return listDatabase;
    }

    public void setListDatabase(List<ListDatabase> listDatabase) {
        this.listDatabase = listDatabase;
    }
}
