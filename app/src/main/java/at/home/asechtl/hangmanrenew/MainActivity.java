package at.home.asechtl.hangmanrenew;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;


import at.home.asechtl.hangmanrenew.databinding.ActivityMainBinding;
import at.home.asechtl.hangmanrenew.fragments.CreateNewGame;
import at.home.asechtl.hangmanrenew.fragments.DifficultyScreen;
import at.home.asechtl.hangmanrenew.fragments.GameView;
import at.home.asechtl.hangmanrenew.fragments.InputWordPlayer;
import at.home.asechtl.hangmanrenew.fragments.StartingScreen;
import at.home.asechtl.hangmanrenew.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.state.observe(this, state -> {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (state == MainViewModel.STARTING_SCREEN) {

                fragmentTransaction.add(R.id.main, new StartingScreen(), "Starting Screen");

            } else if (state == MainViewModel.Difficulty_SCREEN) {
                fragmentTransaction.replace(R.id.main, new DifficultyScreen(), "Difficulty Screen");
                fragmentTransaction.addToBackStack("Difficulty Screen");
            } else if (state == MainViewModel.Create_Guess_Word_SCREEN) {
                fragmentTransaction.replace(R.id.main, new InputWordPlayer(), "Set Guess Word Screen");
                fragmentTransaction.addToBackStack("Set Guess Word Screen");
            } else if (state == MainViewModel.New_Game_Screen) {
                fragmentTransaction.replace(R.id.main, new CreateNewGame(), "New Game Screen");
                fragmentTransaction.addToBackStack("New Game Screen");
            } else if (state == MainViewModel.Game_View_Screen) {
                fragmentTransaction.replace(R.id.main, new GameView(), "Game View Screen");
                fragmentTransaction.addToBackStack("Game View Screen");
            }

            fragmentTransaction.commit();

        });
    }
}