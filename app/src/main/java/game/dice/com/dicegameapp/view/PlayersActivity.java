package game.dice.com.dicegameapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import game.dice.com.dicegameapp.application.GameController;

public class PlayersActivity extends AppCompatActivity {

    GameController controller = new GameController();
    ArrayList<String> playersList;
    RecyclerView recyclerPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        playersList = controller.playersList();
        recyclerPlayers = findViewById(R.id.recyclerPlayers);
        recyclerPlayers.setLayoutManager(new LinearLayoutManager(this));

        PlayersAdapter adapter = new PlayersAdapter(playersList);
        recyclerPlayers.setAdapter(adapter);
    }
}
