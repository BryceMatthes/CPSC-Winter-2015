
/**
 *
 * The Controller class manages the turns of both players and the scores.
 * it also handles the points per turn.
 *
 * The controller class loops untl a player reaches 100 or more points. As soon
 * as a player reaches 100 the loops will top and they will be the winner.
 * 
 * This Controller class doesn't include a start() method from the A2 outline and
 * instead simply uses the contructor method for everything.
 *
 * @author(s) Bryce Matthes & Majid Ghaderi
 * @source Majid Ghaderi
 * @since Feb 5, 2015
 */
public class Controller {
	/**
     * ## Majid Ghaderi documentation ##
     * {
	 * 
	 * @param	cpuPlayer	The computer player object
	 * @param	userPlayer	The human player object
	 * @param	dice		The die to be used in the game
	 * }
	 */
	public Controller(ComputerPlayer cpuPlayer, HumanPlayer userPlayer, Dice dice) {

		boolean gameOver = false; //To stop the game.
		boolean	holdCheck = false; //holdCheck is used to stop the players turn for holding their score.
		int computerScore = 0, humanScore = 0, points = 0, counter = 0, turnCounter = 1;
		
		while(gameOver == false){
			System.out.println(); //used for spacing
			System.out.print("---- Turn ["+turnCounter+"]");
			if (turnCounter % 2 == 0){
				System.out.println(" Computer Turn ----"); //all even turns are computer turns
			}
			else{
				System.out.println(" Human Turn    ----"); //all odds are human turns
			}
			System.out.println();
			holdCheck = false; //reset holdCheck for new turn
			points = 0; //reset points for new turn
			if (counter % 2 == 0){
				points = 0;
				while(holdCheck == false){
					int rolled = dice.roll(); //roll the dice for the turn
					System.out.print("Rolled: " +rolled);
					points = points + rolled;
					if (rolled == 1){
						System.out.println(" | ## Rolled a 1, points busted. Turn over. ##"); //rolled a 1 message
						points = 0;
						holdCheck = true; //end turn.
					}
					else if (humanScore + points >= 100){
						gameOver = true; //end game if the combined rolls are over 100, no need to hold or roll again.
						holdCheck = true;
					}
					else{
						holdCheck = userPlayer.play(computerScore, humanScore, points); //run HumanPlayer play methmod.
					}
				} //close while for turn.
				humanScore = humanScore + points; //add points
			}
			else{
				points = 0; //reset points for new turn.
				holdCheck = false; //reset holdCheck for new turn.
				while(holdCheck == false){
					int rolled = dice.roll(); //roll the dice for the new turn.
					System.out.print("Rolled: " +rolled);
					points = points + rolled;
					if (rolled == 1){
						System.out.println(" | Rolled a 1, points busted. Turn over."); //roll 1 message.
						points = 0;
						holdCheck = true;
					}
					else if (computerScore + points >= 100){
						gameOver = true; //end game if the combined rolls are over 100, no need to hold or roll again.
						holdCheck = true; 
					}
					else{
						holdCheck = cpuPlayer.play(computerScore, humanScore, points); //run the ComputerPlayer play method.
					}
				}
				computerScore = computerScore + points; //add points
			}
			counter++; //increment the counters.
			turnCounter++; //increment the counters.
	}
		gameOver = true;
		System.out.println();
		System.out.println();
		System.out.println("**Game Over**"); //game over message
		System.out.println("**Final Scores: Human Player: "+humanScore+" | Computer Player: "+computerScore+"**"); // display scores.
		if (humanScore > computerScore){
			System.out.println("## Human Player Wins! ##"); //if the Human has more points they must have won.
		}
		else{
			System.out.println("## Computer Wins! ##"); //if the Computer has more points it must have won.
		}
	}
}