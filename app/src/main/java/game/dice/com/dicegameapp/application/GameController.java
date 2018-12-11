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

	public Player getPlayer(String name){
		ArrayList<Player> cloneRepository = repository.getRepository();

		for (Player plyr : cloneRepository){
			if (plyr.getName().equals(name)) {
				this.player = plyr;
				return this.player;
			}
		}
		return null;
	}

	/*
	* run the game
	*/
	public int[] playGame(String name) {
		Game game = new Game();
		this.player = getPlayer(name);
		int[] data = {0,0,0};
		boolean hasWon = game.playGame();

		data[0] = game.getDice1Value(); data[1] = game.getDice2Value();
		if (hasWon == true) data[2] = 1; else data[2] = 0;
		this.player.addGame(game);

		return data;
	}

	/*
	* Convert the last player stats to a string
	*/
	public ArrayList<String> getPlayerGamesToList(String name) {
		this.player = getPlayer(name);
		String text = "";
		List<Game> games = this.player.getAllGames();
		List<String> sendGames = new ArrayList<>();

		for (Game game : games) {
			if (game.getStatus() == true) text = "Dice 1 result: " + game.getDice1Value() + " | Dice 2 result: " + game.getDice2Value()
					+ " | Game status: WIN :-D";
			else text = "Dice 1 result: " + game.getDice1Value() + " | Dice 2 result: " + game.getDice2Value()
					+ " | Game status: Lose :-(";
			sendGames.add(text);
		}
		return (ArrayList) sendGames;
	}

	/*
	* Get the player's stats from the repository
	*/
	/*public double getPlayerRanking(String name) {
		this.player = getPlayer(name);
		List<Game> games = this.player.getAllGames();

		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return wins*100 / games.size();
	}*/

	public boolean existPlayer(String name) {
		if (repository.playerExists(name) == false) return true;

		return false;
	}

	public ArrayList<String> playersList(){
		this.player = new Player("");
		List<String> playersName = new ArrayList<>();
		List<Player> playersrepository = repository.getRepository();

		for (Player plyr : playersrepository) {
			this.player = plyr;
			playersName.add(this.player.getName() + " | "
					+ this.player.getPlayerRanking() + " %");
		}

			return (ArrayList<String>) playersName;
	}
}
