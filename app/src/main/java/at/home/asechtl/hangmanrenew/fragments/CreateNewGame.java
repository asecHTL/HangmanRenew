package at.home.asechtl.hangmanrenew.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.home.asechtl.hangmanrenew.R;
import at.home.asechtl.hangmanrenew.database.GuessWord;
import at.home.asechtl.hangmanrenew.database.ListDatabase;
import at.home.asechtl.hangmanrenew.databinding.FragmentCreateNewGameBinding;
import at.home.asechtl.hangmanrenew.enums.Difficulty;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;

public class CreateNewGame extends Fragment {
    FragmentCreateNewGameBinding binding;
    private GuessWord guessWordInstance;
    private ListDatabase listDatabaseInstance;


    public CreateNewGame() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateNewGameBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        guessWordInstance = new GuessWord("test", Difficulty.Simple);
        listDatabaseInstance = new ListDatabase();


        binding.btNewGame.setOnClickListener(s -> {

        });
        return binding.getRoot();
    }
}