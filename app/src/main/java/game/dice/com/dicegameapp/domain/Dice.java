package game.dice.com.dicegameapp.domain;

import java.util.Random;

public class Dice {
	
	private static final int DICE_SIDES=6;
	private int value;

	public Dice() {
		value=1;
	}

	/*
	Equal to Setter
	 */
	public void rollDice() { this.value = new Random().nextInt(DICE_SIDES)+1; }

	/*
	Getter
	 */
	public int getValue() { return this.value; }
}
