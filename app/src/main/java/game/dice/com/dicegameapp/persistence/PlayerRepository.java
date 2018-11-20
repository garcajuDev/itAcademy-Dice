package game.dice.com.dicegameapp.persistence;

import java.util.ArrayList;
import java.util.List;

import game.dice.com.dicegameapp.domain.Player;

public class PlayerRepository {

    private ArrayList<Player> players;

    public PlayerRepository() {
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) { if (!players.contains(player)) players.add(player); }
}
