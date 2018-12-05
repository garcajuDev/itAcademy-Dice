package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import game.dice.com.dicegameapp.application.GameController;

public class GameActivity extends AppCompatActivity {

    GameController gameControl = new GameController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        onShowPlayerName();
        onGame();
    }

    private void onGame() {
        TextView resultView = findViewById(R.id.txtResult);
        gameControl.createPlayer(getIntent().getExtras().getString("userName"));

        int[] game = gameControl.playGame();
        int dice1Value = game[0]; int dice2Value = game[1];

        onShowDice1(dice1Value);
        onShowDice2(dice2Value);

        if (game[2] == 1) resultView.setText("You Win!"); else resultView.setText("You Lose");

    }

    private void onShowPlayerName() {
        TextView nameview = findViewById(R.id.txtName);
        nameview.setText(getIntent().getExtras().getString("userName"));
    }

    private void onShowDice1(int diceValue) {
        ImageView dice1 = findViewById(R.id.imgDice1);
        switch(diceValue){
            case 1: dice1.setImageResource(R.drawable.one);
                break;
            case 2: dice1.setImageResource(R.drawable.two);
                break;
            case 3: dice1.setImageResource(R.drawable.three);
                break;
            case 4: dice1.setImageResource(R.drawable.four);
                break;
            case 5: dice1.setImageResource(R.drawable.five);
                break;
            case 6: dice1.setImageResource(R.drawable.six);
                break;
        }
    }

    private void onShowDice2(int diceValue) {
        ImageView dice2 = findViewById(R.id.imgDice2);
        switch(diceValue){
            case 1: dice2.setImageResource(R.drawable.one);
                break;
            case 2: dice2.setImageResource(R.drawable.two);
                break;
            case 3: dice2.setImageResource(R.drawable.three);
                break;
            case 4: dice2.setImageResource(R.drawable.four);
                break;
            case 5: dice2.setImageResource(R.drawable.five);
                break;
            case 6: dice2.setImageResource(R.drawable.six);
                break;
        }
    }

    public void onReplayGame(View view) { onGame(); }
}
