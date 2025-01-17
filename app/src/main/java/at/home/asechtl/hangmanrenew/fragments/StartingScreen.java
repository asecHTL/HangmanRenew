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
import at.home.asechtl.hangmanrenew.databinding.FragmentStartingScreenBinding;
import at.home.asechtl.hangmanrenew.enums.Difficulty;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;

public class StartingScreen extends Fragment {

    FragmentStartingScreenBinding binding;
    private GuessWord guessWordInstance;
    private ListDatabase listDatabaseInstance;

    public StartingScreen() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartingScreenBinding.inflate(inflater, container, false);
        MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        guessWordInstance = new GuessWord("test", Difficulty.Simple);
        listDatabaseInstance = new ListDatabase();

        binding.btPVSc.setOnClickListener(s -> {
            viewModel.show_Difficulty_SCREEN();
        });
        binding.btPVSp.setOnClickListener(s -> {
            viewModel.show_CreateGuessWordScreen();
        });


        return binding.getRoot();
    }
}