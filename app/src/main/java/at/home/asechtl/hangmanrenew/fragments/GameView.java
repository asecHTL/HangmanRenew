package at.home.asechtl.hangmanrenew.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import at.home.asechtl.hangmanrenew.R;
import at.home.asechtl.hangmanrenew.databinding.FragmentCreateNewGameBinding;
import at.home.asechtl.hangmanrenew.databinding.FragmentGameViewBinding;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;

public class GameView extends Fragment {

    FragmentGameViewBinding binding;


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


        binding.btGuess.setOnClickListener(s ->{

        });



        return binding.getRoot();
    }
}