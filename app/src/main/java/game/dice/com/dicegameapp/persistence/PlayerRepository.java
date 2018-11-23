package game.dice.com.dicegameapp.persistence;

import java.util.ArrayList;

import game.dice.com.dicegameapp.domain.Player;

public class PlayerRepository {

    private ArrayList<Player> players = new ArrayList<>();

    public PlayerRepository() {}

    public void addPlayer(Player player) {
        if (!players.contains(player))players.add(player);
    }

    public ArrayList<Player> getRepository(){
        return players;
    }
}
