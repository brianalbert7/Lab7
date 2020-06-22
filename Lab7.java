package lab7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Brian Albert
 */
public class Lab7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare Variables
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int randomNumber;
        int[] arrayKept = new int[20];
        int[] arrayDiscard = new int[20];
        boolean Q = false;
        char choice;
        int i = 0;
        int j = 0;
        int totalKept = 0;
        int totalDiscard = 0;
        double averageKept;
        double averageDiscard;
        boolean kept = false;
        boolean discard = false;
        int maxReached = 0;

        while (Q != true) {
            //Giving user a random number 1-100
            randomNumber = rand.nextInt(100);
            randomNumber += 1;
            System.out.println("\nNew number to consider: " + randomNumber);

            if (maxReached == 24) {
                System.out.println("^^^ last number, choose wisely ^^^");
            }

            //Asking the user what they want to do with the number
            if (i == 19 && j != 19) {
                System.out.print("Enter option (D, Q): ");
            } else if (j == 19 && i != 19) {
                System.out.print("Enter option (K, Q): ");
            } else if (j == 19 && i == 19) {
                System.out.print("Enter option (Q): ");
            } else {
                System.out.print("Enter option (K, D, Q): ");
            }

            choice = input.next().charAt(0);
            if (maxReached == 24) {
                choice = 'q';
            }

            switch (choice) {
                case 'k':
                    if (i == 19) {
                        System.out.println("\nUnable to keep - keep list full");
                    } else {
                        arrayKept[i] = randomNumber;
                        i++;
                        totalKept += randomNumber;
                        kept = true;
                        maxReached++;
                    }
                    break;
                case 'd':
                    if (j == 19) {
                        System.out.println("\nUnable to discard - discard list full");
                    } else {
                        arrayDiscard[j] = randomNumber;
                        j++;
                        totalDiscard += randomNumber;
                        discard = true;
                        maxReached++;
                    }
                    break;
                case 'q':
                    Q = true;
                    break;
                default:
                    System.out.println("\nInvalid option");
            }
        }

        //After user quits
        averageKept = (double) totalKept / i;
        averageDiscard = (double) totalDiscard / j;

        if (kept == true) {
            System.out.println("\nYou kept:");
            for (int q = 0; q < i; q++) {
                System.out.printf(" " + q + " -%4d \n", arrayKept[q]);
            }

            System.out.println("\n      Total " + totalKept
                    + " - Average " + averageKept);
        } else {
            System.out.println("\nNothing kept!");
        }

        if (discard == true) {
            System.out.println("\nYou discarded:");
            for (int q = 0; q < j; q++) {
                System.out.printf(" " + q + " -%4d \n", arrayDiscard[q]);
            }

            System.out.println("\n      Total " + totalDiscard
                    + " - Average " + averageDiscard + "\n");
        } else {
            System.out.println("\nNothing discarded!\n");
        }
    }
}
