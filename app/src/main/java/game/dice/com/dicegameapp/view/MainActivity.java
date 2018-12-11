package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import game.dice.com.dicegameapp.application.GameController;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View View){
        TextView namePlayer = findViewById(R.id.txtNamePlayer);
        String name = namePlayer.getText().toString();

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("userName", name);

        startActivity(intent);
    }

    public void onShowStats(View view) {
        Intent intent = new Intent(this, PlayersActivity.class);
        startActivity(intent);
    }
}
