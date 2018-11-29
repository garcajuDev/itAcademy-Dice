package game.dice.com.dicegameapp.application;

import java.util.ArrayList;
import java.util.List;
import game.dice.com.dicegameapp.domain.*;
import game.dice.com.dicegameapp.persistence.PlayerRepository;


public class GameController {

	Player player;
	private static PlayerRepository repository = new PlayerRepository();


	public GameController() {
	}

	/*
	Getters & setters
	*/
	public void createPlayer(String name) {
	    player = new Player(name);
        repository.addPlayer(player);
	}

	public String getPlayerName() {
		List<Player> playerList = repository.getRepository();
		if (playerList.isEmpty())System.out.println("empty repository!");
		for (Player player : playerList) {
			if (player.getName().equals(this.player.getName())) return player.getName();
		}
		return "";
	}

	public void printPlayersName(){
        List<Player> playerList = repository.getRepository();
        for (Player player : playerList){
            System.out.println(player.getName());
        }
    }

    public void printGame(){
	    String resultGame = this.getPlayerGame();

	    System.out.println(resultGame);
    }

	public void printGames(){
		String resultGame = this.getPlayerGamesToString();

		System.out.println(resultGame);
	}

	public void printPlayerRanking(){
		double ranking = this.getPlayerRanking();
		System.out.println("Wins average: " + ranking + "%");
	}
	/*
	* run the game
	*/
	public boolean playGame() {
		Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		return hasWon;
	}

	public String getPlayerGame(){
        List<Game> games = this.player.getAllGames();
        Game lastGame = games.get(games.size()-1);

        return "SUMA: " +  lastGame.getSumDices() + " RESULTAT: " + lastGame.hasWon();
    }

	/*
	* Convert the last player stats to a string
	*/
	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = this.player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon() + "\n";
		}
		return text;
	}

	/*
	* Get the player's stats from the repository
	*/
	public double getPlayerRanking() {
		List<Game> games = this.player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins*100 / games.size();
	}
}
