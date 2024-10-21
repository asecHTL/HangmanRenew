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
import at.home.asechtl.hangmanrenew.databinding.FragmentDifficultyScreenBinding;
import at.home.asechtl.hangmanrenew.enums.Difficulty;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;


public class DifficultyScreen extends Fragment {
    FragmentDifficultyScreenBinding binding;
    private GuessWord guessWordInstance;
    private ListDatabase listDatabaseInstance;

    private static List<GuessWord>listAll;
    private static List<GuessWord>listHard;
    private static List<GuessWord>listSimple;

    public DifficultyScreen() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDifficultyScreenBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        guessWordInstance = new GuessWord("test", Difficulty.Simple);
        listDatabaseInstance = new ListDatabase();
        listHard = new ArrayList<>();
        listSimple = new ArrayList<>();
        listAll = listDatabaseInstance.createList();


        for (int i = 0; i < listAll.size(); i ++){
            GuessWord temp = listAll.get(i);
            if (temp.getDifficulty().equals(Difficulty.Hard)){
                listHard.add(temp);
            } else if (temp.getDifficulty().equals(Difficulty.Simple)) {
                listSimple.add(temp);
            }
        }
        binding.btLevelEasy.setOnClickListener(s -> {
            ListDatabase.setListRightNow(listSimple);
            viewModel.show_GameViewScreen();
        });
        binding.btLevelHard.setOnClickListener(s -> {
            ListDatabase.setListRightNow(listHard);
            viewModel.show_GameViewScreen();
        });


        return binding.getRoot();
    }
}