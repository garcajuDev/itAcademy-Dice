package game.dice.com.dicegameapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import game.dice.com.dicegameapp.application.GameController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame();
    }

    public void startGame(){
        GameController controller = new GameController();

        controller.createPlayer("Isaac");
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.printGames();
        controller.printPlayerRanking();

        controller.createPlayer("Juan");
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.playGame();
        controller.printGames();
        controller.printPlayerRanking();
    }
}
