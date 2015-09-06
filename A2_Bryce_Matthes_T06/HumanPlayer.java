

/**
 * Used to control the Human part of the game of Pig.
 * 
 *
 * If a real user is playing it will prompt for a (r) or (h) to hold or roll again.
 * else it will use the value the user requests are the base value for holding or rolling again.
 *
 * The method "play" is called by the Controller
 * 
 * @author(s) Bryce Matthes & Majid Ghaderi
 * @source Majid Ghaderi
 * @since Feb 5, 2015
 */
import java.util.Scanner;
public class HumanPlayer {
	int base2;
	boolean realPlayer = false;
	/**
	 * ## Majid Ghaderi documentation ##
	 * 
	 * Constructor for creating an interactive human player.
	 */
	public HumanPlayer() {

		realPlayer = true; // A real player will be entering (r) and (h)
	}
	
	/**
	 * ## Majid Ghaderi documentation ##
	 * 
	 * Constructor for creating an automated human player.
	 * 
	 * @param	base	The value of the base when deciding whether to Roll or Hold.
	 */
	public HumanPlayer(int base) {
		base2 = base; // setting base value.
		System.out.println("Base set to: "+base); //prints a message confirming that the base has been set to your value.
	}
	
	/**
	 * ## Majid Ghaderi documentation ##
	 * 
	 * The method play() is called by the Controller after each die roll.
	 * The scores do not change in the middle of a turn.
	 * Only at the end of a turn, the Controller updates the scores.
	 *  
	 * @param	computerScore	the computer player score at the beginning of this turn 
	 * @param	humanScore		the human player score at the beginning of this turn
	 * @param	points			the sum of rolls collected so far in this turn
	 * @return	the next move of the player as an integer: Roll or Hold	
	 */
	public boolean play(int computerScore, int humanScore, int points) {
		//for real human players
		if(realPlayer == true){
			System.out.println(" Computer Score: "+computerScore+" | Human Score: "+humanScore+" | Points this turn: "+points); //Display users scores and current turn points total
			System.out.print(" >hold (h) or roll (r): ");
			Scanner userInput = new Scanner(System.in);
			char userChoice = userInput.next().trim().charAt(0); //take the user choice for holding or rolling again.
			if (userChoice == 'h'){
				return true;//hold
			}
			else{
				return false;//roll
			}
		}
		//for automated mode
		else{
			System.out.println(" Computer Score: "+computerScore+" | Human Score: "+humanScore+" | Points this turn: "+points); //Display users scores and current turn points total
			if (points >= base2){
				System.out.println(" >Automated User Holds. " +"("+points+">="+base2+")"); //using user input for base choose to hold (>=)
				return true;//hold
			}
			else{
				System.out.println(" >Automated User Roll Again. " +"("+points+"!>="+base2+")"); //using user input for base chooce to roll agian (!>=)
				return false;//roll
			}
		}
	}	
}
