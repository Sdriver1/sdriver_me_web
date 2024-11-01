/* AI Chatbot program that simulates meaning someone for the first time
 * Steven Driver 09-12-2024
 * Version 1.0 
 */

import java.util.Scanner;

public class Chatbot1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String name = new String("");

        /* Introduction */
        System.out.println("Hello! My name is David. What is your name?");
        name = scn.nextLine();
        System.out.println("Nice to meet you, " + name + "!");

        /* Questions */
        // First question
        System.out.println("Where are you from?");
        String location = new String(scn.nextLine());
        System.out.println("How many years have you lived in " + location + "?");
        int years = scn.nextInt();
        scn.nextLine();
        System.out.println(years + " years is a long time! You must love living in " + location + ".");

        // Second question
        System.out.println("What is your favorite color?");
        String color = new String(scn.nextLine());
        System.out.println(color + " is a beautiful color!");

        // Third question
        System.out.println("What is your favorite food?");
        String food = new String(scn.nextLine());
        System.out.println(food + " sounds delicious! I will have to try it sometime.");

        /* GPA Calculator */
        System.out.println("What is your current GPA?");
        double currGPA = scn.nextDouble();
        scn.nextLine();

        System.out.println("How many assessments have you completed so far?");
        int completedAssessments = scn.nextInt();
        scn.nextLine();

        System.out.println("How many assessments do you have left?");
        int numAssessmentsLeft = scn.nextInt();
        scn.nextLine();

        System.out.println("What is your desired GPA?");
        double desiredGPA = scn.nextDouble();
        scn.nextLine();

        int totalAssessments = completedAssessments + numAssessmentsLeft;
        double sumOfCurrentGrades = currGPA * completedAssessments;
        double neededAvg = (desiredGPA * totalAssessments - sumOfCurrentGrades) / numAssessmentsLeft;

        if (neededAvg > 100) {
            double maxPossibleGPA = (sumOfCurrentGrades + (100.0 * numAssessmentsLeft)) / totalAssessments;
            System.out.printf("Even if you make 100 on every assignment, you will only end with a GPA of %.2f. "
                    + "You needed %.2f to reach a GPA of %.2f.%n", maxPossibleGPA, neededAvg, desiredGPA);
        } else {
            System.out.printf(
                    "You need to get a %.2f%% on your remaining assessments to achieve your desired GPA. You can do it!%n",
                    neededAvg);
        }

        /* Quadratic equation */
        System.out.println("Enter the value of a: ");
        int a = scn.nextInt();
        System.out.println("Enter the value of b: ");
        int b = scn.nextInt();
        System.out.println("Enter the value of c: ");
        int c = scn.nextInt();

        double numerator1 = -b + Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double numerator2 = -b - Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        double denominator = 2 * a;

        double x1 = numerator1 / denominator;
        double x2 = numerator2 / denominator;

        if (Double.isNaN(x1) || Double.isNaN(x2)) {
            System.out.println("The equation has no real roots.");
        } else if (x1 == x2) {
            System.out.printf("x = %.2f", x1);
        } else {
            System.out.printf("x = %.2f, x= %.2f.%n", x1, x2);
        }

        /* Average calculator */
        System.out.println("Enter grade 1: ");
        int grade1 = scn.nextInt();

        System.out.println("Enter grade 2: ");
        int grade2 = scn.nextInt();

        System.out.println("Enter grade 3: ");
        int grade3 = scn.nextInt();

        System.out.println("Enter grade 4: ");
        int grade4 = scn.nextInt();

        System.out.println("Enter grade 5: ");
        int grade5 = scn.nextInt();

        double average = ((double) (grade1 + grade2 + grade3 + grade4 + grade5)) / 5;
        System.out.println("The average is: " + average);

        System.out.println("\nThank you for chatting with me, " + name + "!");
        System.out.println(" ************** ");
        System.out.println(" *            * ");
        System.out.println(" * **      ** * ");
        System.out.println(" * **      ** * ");
        System.out.println(" *            * ");
        System.out.println(" *            * ");
        System.out.println(" *            * ");
        System.out.println(" ************** ");

        /* Closing */
        scn.close();
    }
}

