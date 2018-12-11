package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import game.dice.com.dicegameapp.application.GameController;

public class GameActivity extends AppCompatActivity {

    GameController gameControl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameControl = new GameController();

        onShowPlayerName();
        onGame();
    }

    private void onGame() {
        TextView resultView = findViewById(R.id.txtResult);
        String name = getIntent().getExtras().getString("userName");

        if(gameControl.existPlayer(name) == true){
            gameControl.createPlayer(name);
            Toast.makeText(this, "New player created!", Toast.LENGTH_LONG )
                    .show();
        }

        int[] game = gameControl.playGame(name);
        int dice1Value = game[0]; int dice2Value = game[1];

        onShowDice(dice1Value, dice2Value);

        if (game[2] == 1) resultView.setText("You Win!"); else resultView.setText("You Lose");

    }

    private void onShowPlayerName() {
        TextView nameview = findViewById(R.id.txtName);
        nameview.setText(getIntent().getExtras().getString("userName"));
    }

    private void onShowDice(int diceValue1, int diceValue2) {
        ImageView dice1 = findViewById(R.id.imgDice1);
        ImageView dice2 = findViewById(R.id.imgDice2);

        String dice1img = "dice_"+diceValue1;
        String dice2img = "dice_"+diceValue2;

        int id1 = getResources().getIdentifier(dice1img,"drawable",getPackageName());
        int id2 = getResources().getIdentifier(dice2img,"drawable",getPackageName());

        dice1.setImageResource(id1);
        dice2.setImageResource(id2);

    }

    public void onReplayGame(View view) { onGame(); }
}
