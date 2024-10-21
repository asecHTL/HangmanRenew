package at.home.asechtl.hangmanrenew.database;

import java.util.ArrayList;
import java.util.List;

import at.home.asechtl.hangmanrenew.enums.Difficulty;

public class ListDatabase {
    private static List<GuessWord>list = new ArrayList<>();

    public List<GuessWord> createList(){
        list.add(new GuessWord("Eisenbahn", Difficulty.Hard));
        list.add(new GuessWord("Apfel", Difficulty.Simple));
        list.add(new GuessWord("Kryptographie", Difficulty.Hard));
        list.add(new GuessWord("Haus", Difficulty.Simple));
        list.add(new GuessWord("Astronomie", Difficulty.Hard));
        list.add(new GuessWord("Stuhl", Difficulty.Simple));
        list.add(new GuessWord("Wasserfall", Difficulty.Hard));
        list.add(new GuessWord("Blume", Difficulty.Simple));
        list.add(new GuessWord("Quantenphysik", Difficulty.Hard));
        list.add(new GuessWord("Baum", Difficulty.Simple));
        list.add(new GuessWord("Schmetterling", Difficulty.Simple));
        list.add(new GuessWord("Galaxie", Difficulty.Hard));
        list.add(new GuessWord("Taschenlampe", Difficulty.Simple));
        list.add(new GuessWord("Dinosaurier", Difficulty.Hard));
        list.add(new GuessWord("Brücke", Difficulty.Simple));
        list.add(new GuessWord("Meteorologie", Difficulty.Hard));
        list.add(new GuessWord("Pyramide", Difficulty.Simple));
        list.add(new GuessWord("Nanotechnologie", Difficulty.Hard));
        list.add(new GuessWord("Kaktus", Difficulty.Simple));
        list.add(new GuessWord("Bergsteigen", Difficulty.Hard));
        list.add(new GuessWord("Schneeflocke", Difficulty.Simple));
        list.add(new GuessWord("Robotik", Difficulty.Hard));
        list.add(new GuessWord("Buch", Difficulty.Simple));
        list.add(new GuessWord("Philosophie", Difficulty.Hard));
        list.add(new GuessWord("Kamera", Difficulty.Simple));
        list.add(new GuessWord("Raumfahrt", Difficulty.Hard));
        list.add(new GuessWord("Schildkröte", Difficulty.Simple));
        list.add(new GuessWord("Hydraulik", Difficulty.Hard));
        list.add(new GuessWord("Gitarre", Difficulty.Simple));
        list.add(new GuessWord("Vulkan", Difficulty.Hard));

        return list;
    }

    public static List<GuessWord> getList() {
        return list;
    }

    public static void setList(List<GuessWord> list) {
        ListDatabase.list = list;
    }
}
