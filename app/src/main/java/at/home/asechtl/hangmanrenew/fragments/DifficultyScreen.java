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
import at.home.asechtl.hangmanrenew.databinding.FragmentDifficultyScreenBinding;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;


public class DifficultyScreen extends Fragment {
    FragmentDifficultyScreenBinding binding;

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



        binding.btLevelEasy.setOnClickListener(s -> {
            GuessWordLogic.setGuessWordList(listSimple);
            viewModel.show_GameViewScreen();
        });
        binding.btLevelHard.setOnClickListener(s -> {
            GuessWordLogic.setGuessWordList(listHard);
            viewModel.show_GameViewScreen();
        });


        return binding.getRoot();
    }
}