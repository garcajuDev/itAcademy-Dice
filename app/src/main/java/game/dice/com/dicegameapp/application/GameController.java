package game.dice.com.dicegameapp.application;

import java.util.List;
import game.dice.com.dicegameapp.domain.*;
import game.dice.com.dicegameapp.persistence.PlayerRepository;


public class GameController {

	private Player player;
	private PlayerRepository repository = new PlayerRepository();


	public GameController() { }

	/*
	Getters & setters
	*/
	public void createPlayer(String name) { this.player = new Player(name); }

	public String getPlayerName() { return player.getName(); }

	/*
	* run the game
	*/
	public boolean playGame() {
		Game game = new Game();
		boolean hasWon = game.playGame();
		player.addGame(game);
		repository.addPlayer(player);
		return hasWon;
	}

	/*
	* Convert the last player stats to a string
	*/
	public String getPlayerGamesToString() {
		String text = "";
		List<Game> games = player.getAllGames();

		for (Game game : games) {
			text += "SUMA: " + game.getSumDices() + " RESULTAT: " + game.hasWon();
		}
		return text;
	}

	/*
	* Get the player's stats from the repository
	*/
	public double getPlayerRanking() {
		List<Game> games = player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins / games.size();
	}

}
