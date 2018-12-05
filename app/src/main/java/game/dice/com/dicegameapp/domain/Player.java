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
}
