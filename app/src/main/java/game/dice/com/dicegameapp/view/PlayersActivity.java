package game.dice.com.dicegameapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rawName = ""+ playersList.get(recyclerPlayers.getChildAdapterPosition(view));
                int endNamePositition = rawName.indexOf('|')-1;
                String name = rawName.substring(0, endNamePositition);

                Intent intent = new Intent(getApplicationContext(), GamePlayer.class);
                intent.putExtra("name", name);

                startActivity(intent);
            }
        });

        recyclerPlayers.setAdapter(adapter);
    }
}
