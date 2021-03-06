package game.dice.com.dicegameapp.domain;

public class Game {

	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private boolean gameStatus = false;
	
	public Game(){
		
	}

	public int getDice1Value(){ return dice1.getValue(); }


	public int getDice2Value(){ return dice2.getValue(); }
	
	public boolean playGame() {
		dice1.rollDice();
		dice2.rollDice();

		this.gameStatus = hasWon();

		return this.gameStatus;
	}
	
	public int getSumDices(){ return dice1.getValue()+dice2.getValue(); }
	
	public boolean hasWon(){
		int result = getSumDices();
		if (result == 7) return true;

		return false;
	}

	public boolean getStatus(){ return this.gameStatus; }

}
