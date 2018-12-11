package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import game.dice.com.dicegameapp.application.GameController;
import game.dice.com.dicegameapp.domain.Player;

public class GamePlayer extends AppCompatActivity {

    GameController gameController;
    ArrayList<String> gameList;

    RecyclerView recyclerGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_player);

        gameController = new GameController();
        String name = getIntent().getExtras().getString("name");

        gameList = gameController.getPlayerGamesToList(name);
        recyclerGames = findViewById(R.id.recyclerplayergame);
        recyclerGames.setLayoutManager(new LinearLayoutManager(this));
        GameAdapter adapter = new GameAdapter(gameList);

        recyclerGames.setAdapter(adapter);
    }
}
