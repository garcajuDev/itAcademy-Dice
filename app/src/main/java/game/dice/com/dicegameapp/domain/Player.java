package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Game> games;

	/*
	Getters & Setters
	 */
	public Player(String name){
		this.name=name;
		this.games = new ArrayList<Game>();
	}
	
	public String getName(){ return this.name; }

    public void setName(String name){this.name = name;}

	public void addGame(Game game){ games.add(game); }

	public List<Game> getAllGames() { return games; }

	public double getPlayerRanking() {
		double wins = 0.0;
		for (Game game : games) {
			if (game.hasWon())
				wins++;
		}
		return (double)Math.round((wins*100 / games.size()) * 100d) / 100d;
	}
}
