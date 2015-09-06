
/**
 * This is the controller class for the Computer Player in the game
 * of Pig. It takes the scores of both players in the game and decides if
 * it should risk its points and rush to 100 based on if either player
 * curently holds 71 or more points
 *
 * If neiter player currently holds 71 or more points
 * the Computer Player will use the formula posted in the PDF
 * that is {holdNumber = 21 + round([cpuScore - userScore]/8)}
 * using this hold number the program will choose to hold or roll again.
 *
 * Built using the skeleton code posted on D2L
 *
 * @author(s) Bryce Matthes & Majid Ghaderi
 * @source Majid Ghaderi
 * @since Feb 5, 2015
 */
public class ComputerPlayer {
	
	public ComputerPlayer() {
	}

	/**
	 * Makes the choice to hold or roll for the computer player.
	 * based on the values described in the class header.
	 *
     * ## Majid Ghaderi documentation ##
     * { 
	 * @param	computerScore	the computer player score at the beginning of this turn 
	 * @param	humanScore		the human player score at the beginning of this turn
	 * @param	points			the sum of rolls collected so far in this turn
	 * }
	 *
	 * @return	returns a boolean value of true or false for holding. true = hold, false = roll. 
	 */
	public boolean play(int computerScore, int humanScore, int points) {

		int base2 = 21 + Math.round((computerScore - humanScore)/8); //formula for base hold value

		System.out.println(" Computer Score: "+computerScore+" | Human Score: "+humanScore+" | Points this turn: "+points); //Display users scores and current turn points total
		
		if (points >= base2 && computerScore < 71 && humanScore < 71){
			System.out.println(" >Computer Player Holds. " +"("+points+">="+base2+")"); //Holding the points
			return true;
		}
		else{
			if (computerScore < 71 && humanScore < 71){
				System.out.println(" >Computer Player Rolls Again. " +"("+points+"!>="+base2+")"); //Posts that it follows that formula for the base hold.
			}
			else{
				System.out.println(" >Computer Player Rolls Again. " +"(rushing because a user has 71 or higher points)"); //A User has 71 or more points. Rushing to 100
			}
			return false;

		}
	}
}
