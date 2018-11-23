package game.dice.com.dicegameapp.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Game> games=new ArrayList<Game>();

	/*
	Getters & Setters
	 */
	public Player(String name){ this.name=name; }
	
	public String getName(){ return this.name; }

    public void setName(String name){this.name = name;}

	public void addGame(Game game){ this.games.add(game); }

	public List<Game> getAllGames() { return games; }
}
