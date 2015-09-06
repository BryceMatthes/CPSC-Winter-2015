/*
 * A simple program that can determine the largest
 * possible number that can be comtructed using 5 digits
 * this is all done using only
 *
 * I hope my BINGO made of asterisks looks good :)
 * ------------------------------------------------------
 * @uofcid 10147880
 * @version 1.0
 * @date 1/27/2015
 * @email BryceMatthes@gmail.com
 * @author Bryce Matthes
 * LC: 107
 */

import java.util.Scanner;

class A1Part1 {

    public static void main(String[] args) {
        
        int largestNumber, tenThousands, thousands, hundreds, tens, ones, fiveDigitNum, larger1 = 0, larger2 = 0, larger3 = 0, larger4 = 0, larger5 = 0;
        boolean usedTenThousands = false, usedThousands = false, usedHundreds = false, usedTens = false, usedOnes = false;
        
        Scanner userInput = new Scanner(System.in); //Scanner is nammed userInput
        
        System.out.print("Please enter your 5 didgit number: ");
        fiveDigitNum = userInput.nextInt();
        userInput.close();
        
        tenThousands = fiveDigitNum/10000; //Find the TenThousands place digit
        thousands = (fiveDigitNum-(10000*tenThousands))/1000; //Thousands place digit
        hundreds = (fiveDigitNum-(10000*tenThousands)-(1000*thousands))/100; //Hundreds place digit
        tens = (fiveDigitNum-(10000*tenThousands)-(1000*thousands)-(100*hundreds))/10; //Tens place digit
        ones = (fiveDigitNum-(10000*tenThousands)-(1000*thousands)-(100*hundreds)-(10*tens)); //Ones place digit
        
        System.out.println("The digits in " +fiveDigitNum +" are: " +tenThousands +", " +thousands +", " +hundreds +", " +tens +", " +ones);
        
        //Find the largest digit [The if statements are on a single line to save space, expansion isn't really necessary] 
        if (larger1 < tenThousands && usedTenThousands == false){larger1 = tenThousands;}
        if (larger1 < thousands && usedThousands == false){larger1 = thousands;}
        if (larger1 < hundreds && usedHundreds == false){larger1 = hundreds;}
        if (larger1 < tens && usedTens == false){larger1 = tens;}
        if (larger1 < ones && usedOnes == false){larger1 = ones;}
        if(larger1 == tenThousands && usedTenThousands == false){usedTenThousands = true;} //Find which number is used, backlist it
        else if(larger1 == thousands && usedThousands == false){usedThousands = true;}
        else if(larger1 == hundreds && usedHundreds == false){usedHundreds = true;}
        else if(larger1 == tens && usedTens == false){usedTens = true;}
        else if(larger1 == ones && usedOnes == false){usedOnes = true;}
        
        //Find the 2nd largest digit
        if (larger2 < tenThousands && usedTenThousands == false){larger2 = tenThousands;}
        if (larger2 < thousands && usedThousands == false){larger2 = thousands;}
        if (larger2 < hundreds && usedHundreds == false){larger2 = hundreds;}
        if (larger2 < tens && usedTens == false){larger2 = tens;}
        if (larger2 < ones && usedOnes == false){larger2 = ones;}
        if(larger2 == tenThousands && usedTenThousands == false){usedTenThousands = true;} //Find which number is used and backlist it
        else if(larger2 == thousands && usedThousands == false){usedThousands = true;}
        else if(larger2 == hundreds && usedHundreds == false){usedHundreds = true;}
        else if(larger2 == tens && usedTens == false){usedTens = true;}
        else if(larger2 == ones && usedOnes == false){usedOnes = true;}
        
        //Find the 3rd largest digit
        if (larger3 < tenThousands && usedTenThousands == false){larger3 = tenThousands;} //Find which number is used and backlist it
        if (larger3 < thousands && usedThousands == false){larger3 = thousands;}
        if (larger3 < hundreds && usedHundreds == false){larger3 = hundreds;}
        if (larger3 < tens && usedTens == false){larger3 = tens;}
        if (larger3 < ones && usedOnes == false){larger3 = ones;}
        if(larger3 == tenThousands && usedTenThousands == false){usedTenThousands = true;} //Find which number is used and backlist it
        else if(larger3 == thousands && usedThousands == false){usedThousands = true;}
        else if(larger3 == hundreds && usedHundreds == false){usedHundreds = true;}
        else if(larger3 == tens && usedTens == false){usedTens = true;}
        else if(larger3 == ones && usedOnes == false){usedOnes = true;}
        
        //Find the 4th largest digit
        if (larger4 < tenThousands && usedTenThousands == false){larger4 = tenThousands;}
        if (larger4 < thousands && usedThousands == false){larger4 = thousands;}
        if (larger4 < hundreds && usedHundreds == false){larger4 = hundreds;}
        if (larger4 < tens && usedTens == false){larger4 = tens;}
        if (larger4 < ones && usedOnes == false){larger4 = ones;}
        if(larger4 == tenThousands && usedTenThousands == false){usedTenThousands = true;} //Find which number is used and backlist it
        else if(larger4 == thousands && usedThousands == false){usedThousands = true;}
        else if(larger4 == hundreds && usedHundreds == false){usedHundreds = true;}
        else if(larger4 == tens && usedTens == false){usedTens = true;}
        else if(larger4 == ones && usedOnes == false){usedOnes = true;}
        
        //Find the smallest (5th largest) digit
        if (larger5 < tenThousands && usedTenThousands == false){larger5 = tenThousands;}
        if (larger5 < thousands && usedThousands == false){larger5 = thousands;}
        if (larger5 < hundreds && usedHundreds == false){larger5 = hundreds;}
        if (larger5 < tens && usedTens == false){larger5 = tens;}
        if (larger5 < ones && usedOnes == false){larger5 = ones;} //No need to updated the used booleans here because we are only using 5 digits.
        
        largestNumber = (larger1*10000)+(larger2*1000)+(larger3*100)+(larger4*10)+larger5; //Combine all of the digits into one number   
        System.out.println("The largest number that can be made from these digits is: "+largestNumber);
        
        if (largestNumber == fiveDigitNum){ //The hardest and most important part of the program Kappa
            System.out.println("******   *  *     *  *******   ***** ");
            System.out.println("*     *     **    *  *        *     *");
            System.out.println("*     *  *  * *   *  *        *     *");
            System.out.println("******   *  *  *  *  *  ****  *     *");
            System.out.println("*     *  *  *   * *  *     *  *     *");
            System.out.println("*     *  *  *    **  *     *  *     *");
            System.out.println("******   *  *     *  *******   ***** ");
        }
    } 
}