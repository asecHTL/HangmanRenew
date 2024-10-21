package at.home.asechtl.hangmanrenew.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import at.home.asechtl.hangmanrenew.R;
import at.home.asechtl.hangmanrenew.database.GuessWord;
import at.home.asechtl.hangmanrenew.database.ListDatabase;
import at.home.asechtl.hangmanrenew.databinding.FragmentCreateNewGameBinding;
import at.home.asechtl.hangmanrenew.databinding.FragmentGameViewBinding;
import at.home.asechtl.hangmanrenew.enums.Difficulty;
import at.home.asechtl.hangmanrenew.logic.GameViewLogic;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;

public class GameView extends Fragment {

    FragmentGameViewBinding binding;
    private GuessWord guessWordInstance;
    private ListDatabase listDatabaseInstance;
    private GameViewLogic gameViewLogic;
    private static String wordToGuess;
    private static List<GuessWord> listRightNow;
    private static char[] location;
    private static int errors = 0;
    private static List<Integer>listImages = new ArrayList<>();

    public GameView() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGameViewBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        guessWordInstance = new GuessWord("test", Difficulty.Simple);
        listDatabaseInstance = new ListDatabase();
        gameViewLogic = new GameViewLogic();
        location = new char[100];
        loadPictures();

        wordToGuess = ListDatabase.getWordToGuessRightNow();

        if (wordToGuess == null){
            listRightNow = ListDatabase.getListRightNow();
            wordToGuess = gameViewLogic.getRandomWord(listRightNow);

            String line = gameViewLogic.getUnderScoreSymbols(wordToGuess);
            binding.tvCaptureWord.setText(line);
        }else{
            String line = gameViewLogic.getUnderScoreSymbols(wordToGuess);
            binding.tvCaptureWord.setText(line);
        }

        binding.btGuess.setOnClickListener(s ->{
            location = gameViewLogic.checkCorrectGuess(wordToGuess,binding.tiInputGuess.getText().charAt(0));
            if (location != null){
                String line = gameViewLogic.updateGuessWord(wordToGuess, location);
                binding.tvCaptureWord.setText(line);
            }else{
                binding.imageView.setImageResource(listImages.get(errors));
                errors++;
            }
        });



        return binding.getRoot();
    }

    public void loadPictures(){
        listImages.add(R.drawable.hangman01);
        listImages.add(R.drawable.hangman02);
        listImages.add(R.drawable.hangman03);
        listImages.add(R.drawable.hangman04);
        listImages.add(R.drawable.hangman05);

    }
}