/* Unit 2 Lab | Chatbot2
 * Steven Driver
 * 10-11-2024
 * Version 1.0
 */

import java.util.Scanner;

public class Chatbot2 {

    public static void main(String[] args) {
        /* Initialize Scanner and variables */
        Scanner scn = new Scanner(System.in);
        String fname, lname, init, color, food, Answer;
        Integer favnum;

        /* Introduction | Prompts user for first and last name */
        System.out.println("Hello! My name is David. What is your name?");
        fname = scn.nextLine();
        fname = fname.substring(0, 1).toUpperCase() + fname.substring(1).toLowerCase();
        System.out.println("Nice to meet you, " + fname + "! What is your last name?");
        lname = scn.nextLine();
        lname = lname.substring(0, 1).toUpperCase() + lname.substring(1).toLowerCase();
        init = fname.substring(0, 1) + lname.substring(0, 1);
        System.out.println("Welcome " + fname + " " + lname + ", I will call you " + init + " from now on.");

        /* 3 Questions */
        /* Question 1 */
        System.out.println("What is your favorite color?");
        color = scn.nextLine();
        color = color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
        System.out.println("Nice! " + color + " is a great color!");

        /* Question 2 */
        System.out.println("What is your favorite food?");
        food = scn.nextLine();
        food = food.substring(0, 1).toUpperCase() + food.substring(1).toLowerCase();
        System.out.println("Yum! " + food + " sounds delicious!");

        /* Question 3 */
        System.out.println("What is your favorite number?");
        favnum = scn.nextInt();
        scn.nextLine();
        System.out.println(
                "Great choice! " + favnum + " is a cool number! Speaking of numbers, let's play a numbers game!");

        /* Ask the user if they like to play the dice game */
        while (true) {
            System.out.println("Would you like to play a game? (yes or no)");
            Answer = scn.nextLine().toLowerCase();
            if (Answer.equals("yes")) { // If the user enters yes, the Dicegame method is called
                Dicegame(scn);
                break;
            } else if (Answer.equals("no")) { // If the user enters no, the program will ask again
                System.out.println("Try again");
            } else {
                System.out.println("Invalid answer: Please enter 'yes' or 'no'"); // If the user enters anything other
                                                                                  // than yes or no, the program will
                                                                                  // ask again
            }
        }

        /* Ask the user if they like to play the guess number game */
        System.out.println("How about we play another game");
        while (true) {
            System.out.println("Would you like to play another game? (yes or no)");
            Answer = scn.nextLine().toLowerCase();
            if (Answer.equals("yes")) { // If the user enters yes, the GuessMyNumber method is called
                GuessMyNumber(scn);
                break;
            } else if (Answer.equals("no")) { // If the user enters no, the program will ask again
                System.out.println("Try again");
            } else {
                System.out.println("Invalid answer: Please enter 'yes' or 'no'"); // If the user enters anything other
                                                                                  // than yes or no, the program will
                                                                                  // ask again
            }
        }

        System.out.print("Thank you for playing have a good day, " + init);

        scn.close();
    }

    /* Dicegame method */
    private static void Dicegame(Scanner scn) {
        Integer input, maxvalue, facevalue, facevalue1, sum;

        while (true) {
            System.out.println("Enter a number between 2 and 12");
            input = scn.nextInt();

            if (input > 12 || input < 2) {
                System.out.println("Please enter a valid number!");
            } else {
                maxvalue = 6;
                facevalue = (int) (Math.random() * maxvalue) + 1;
                facevalue1 = (int) (Math.random() * maxvalue) + 1;
                sum = facevalue + facevalue1;

                if (input == sum) {
                    System.out.println("You win! The sum of the dice is " + sum);
                } else {
                    System.out.println("You lose! The sum of the dice is " + sum);
                }

                System.out.println("Would you like to play again? (yes or no)");
                scn.nextLine();
                String playAgain = scn.nextLine().toLowerCase();

                if (!playAgain.equals("yes")) {
                    break;
                }
            }
        }
    }

    /* GuessMyNumber method */
    private static void GuessMyNumber(Scanner scn) {
        Integer input;

        while (true) {
            System.out.println("Enter a number between 1 and 100");
            input = scn.nextInt();

            if (input > 100 || input < 1) {
                System.out.println("Please enter a valid number!");
            } else {
                int maxvalue = 100;
                int random = (int) (Math.random() * maxvalue) + 1;

                if (input == random) {
                    System.out.println("Congratulations! You guessed the number!");
                } else {
                    System.out.println("You lose! The number was " + random);
                }

                System.out.println("Would you like to play again? (yes or no)");
                scn.nextLine();
                String playAgain = scn.nextLine().toLowerCase();

                if (!playAgain.equals("yes")) {
                    break;
                }
            }
        }
    }
}
