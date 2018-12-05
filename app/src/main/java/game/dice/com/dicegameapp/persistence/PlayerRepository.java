package game.dice.com.dicegameapp.persistence;

import java.util.ArrayList;

import game.dice.com.dicegameapp.domain.Player;

public class PlayerRepository {

    private ArrayList<Player> players = new ArrayList<>();

    public PlayerRepository() {}

    public void addPlayer(Player player) {players.add(player);}

    public ArrayList<Player> getRepository(){
        return players;
    }

    public boolean playerExists(String name) {
        for (Player player : players)
            if (player.getName().equals(name)) return true;

            return false;
    }
}
