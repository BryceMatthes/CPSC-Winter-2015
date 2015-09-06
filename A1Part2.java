/*
 * Using a Bubble Sort this program takes the users input and determines the
 * largest possible number that can be made from its digits.
 * It then shows the frequency of the digits in the number using a histagram
 * for visual representation.
 *
 * NOTES
 *
 * "You may use other sorting algorithms if you wish." So I used a Bubble Sort
 * 
 * There is an error in the marking scheme PDF on D2L which
 * contradicts instructions outlined in the A1Part2 PDF
 * "Your program should have only one method, namley the main method. All your code should be in this method."
 * compared to the marking penalty of 10 marks for not using multiple methods http://i.imgur.com/duOXW5V.png
 * "main method includes the entire code and no other methods are declared" http://i.imgur.com/FCBSXRe.png
 *
 * GG
 *
 * @uofcid 10147880
 * @version 1.0
 * @date 2/06/2015
 * @email BryceMatthes@gmail.com
 * @author Bryce Matthes
 */

import  java.util.Scanner;

class A1Part2 {

    public static void main(String[] args) {
        String largestNumber = "", graphLine = "";
        int mostOcc = 0, myCounter = 0, i, holdVal;
        boolean swapCheck = true; // set flag to true to begin first pass
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter your number: ");
        String userNumIntString = keyboard.next();
        
        int[] userNumInt = new int[userNumIntString.length()];
        
        //Turn the String into an int Array
        for (i = 0; i < userNumIntString.length(); i++){
            int holder = userNumIntString.charAt(i) - '0';
            //Error checking values for non-integers
            if (holder != 0 && holder != 1 && holder != 2 && holder != 3 && holder != 4 && holder != 5 && holder != 6 && holder != 7 && holder != 8 && holder != 9){
                System.out.println("Value Error");
                System.exit(0); //Exit    
            }
            userNumInt[i] = userNumIntString.charAt(i) - '0'; //Add the int to the Array
        }
        
        //Using a Bubble Sort to find the largest elements
        while (swapCheck){
            swapCheck = false;
            for(i=0;  i < userNumInt.length -1;  i++){
                if (userNumInt[i] < userNumInt[i+1]){
                    holdVal = userNumInt[i];//swap the two elements
                    userNumInt[i] = userNumInt[i+1];
                    userNumInt[i+1] = holdVal;
                    swapCheck = true;
                }
            } 
        }
        //Add all elements to the String largestNumber
        for (i=0;  i < userNumInt.length;  i++){
            largestNumber = largestNumber +(userNumInt[i]); 
        }
        //Print the largest number
        System.out.println("The largest number with those digits is: "+largestNumber);
        System.out.println(); //Blank line
        //Make an Array containing the frequency of digits 0-9
        int [] freqArray = new int[10];
        while (myCounter < 10){
            int freq = 0;
            for(final int v : userNumInt){
                if(v == myCounter){
                    freq++;
                }
            }
            if (freq > mostOcc){
                mostOcc = freq;
        }
        freqArray[myCounter] = freq;
        myCounter++;
    }
        //Add the digits to their correct locations in the Array
        for (i=0;  i < freqArray.length;  i++){
            largestNumber = largestNumber +(freqArray[i]) +" ";
        }
        //Prints histogram
        while (mostOcc > 0){
           myCounter = 0;
           while (myCounter < 10){
           if(freqArray[myCounter] >= mostOcc && myCounter == 0){
               graphLine = graphLine +" " +mostOcc + "|* "; //Starting bar
            }
            else if (myCounter == 0){
                if (mostOcc >= 10){
                    graphLine = graphLine +mostOcc + "|  "; //Staring bar
                }
                if (mostOcc < 10){
                    graphLine = graphLine +" " +mostOcc + "|  "; //Starting bar
                }     
            }
            if(freqArray[myCounter] >= mostOcc && myCounter != 0){
                graphLine = graphLine + "* ";
            }
            else if (myCounter != 0){
               graphLine = graphLine + "  ";  
            }
            myCounter++;
            }
        System.out.println(graphLine);
        graphLine = "";
        mostOcc = mostOcc -1;  
        }
        System.out.println("  --------------------");
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
    }
}