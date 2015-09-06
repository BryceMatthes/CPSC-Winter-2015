
/**
 * A sample implementation of Assignment 2 for CPSC 233.
 * 
 *
 * This prgram is a simple imprementation of the dice game of Pig.
 * The rules of the game are the first to 100 or more points is the winner. The player rolls a single dice and can choose
 * to roll again if they roll a 2 - 6. rolling a 1 will cause you to lose all points gained that turn. They can choose to hold
 * and save their points for that turn without risking the loss by rolling a 1.
 *
 * This main class is used to check for command line arguments for a 'seed' to be used for Java's number generator.
 *
 * ## Doesn't use a start method in Controller Class. ##
 * 
 * Built using the skeleton code posted on D2L
 * 
 * ID:10147880
 * @author(s) Bryce Matthes & Majid Ghaderi
 * @source Majid Ghaderi
 * @since Feb 5, 2015
 */
import java.util.Scanner;
public class A2 {

	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);
	boolean complete = false;	
	int seed = 1234; //base seed to be used if there are no arugments

	if(args.length != 0) //check for arguments
    {
		seed = Integer.parseInt(args[0]); //use the first as the seed if there is one. | no error checking.
    }

		HumanPlayer humanPlayer = null;
		
		System.out.println("Welcome to my game of Pig."); //welcome message
		while (complete == false){
			System.out.print("Press (i) for interactive mode or (a) for automated mode: "); //ask for mode
			char userChoice = userInput.next().trim().charAt(0); //check char for choice
			//automated mode
			if (userChoice == 'a'){
				System.out.println("Starting in automated mode...");
				System.out.print("Please set the base value: ");
				humanPlayer = new HumanPlayer(userInput.nextInt()); //set automated user base for holds.
				complete = true;
			}
			//interactive mode
			else if (userChoice == 'i'){
				System.out.println("Starting in interactive mode...");
				humanPlayer = new HumanPlayer();
				complete = true;
			}
			//error checking
			else{
				System.out.println("'" +userChoice +"'" +" is not an option. Please try again."); //error prompt to try again.
			}
		}

	Controller controller = new Controller(new ComputerPlayer(), humanPlayer, new Dice(seed)); //starts the game. I don't have a start() method in Controller.

	}

}
