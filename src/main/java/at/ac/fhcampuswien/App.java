package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {

    // Global vars
    Scanner sc = new Scanner(System.in);

    //todo Task 1
    public void largestNumber() {
        // input your solution here

        double input;
        double largestNum = 0;
        int numCnt = 0;

        do {
            System.out.printf("Number %d: ", numCnt + 1);
            input = sc.nextDouble();

            // Check for invalid input
            if (numCnt < 1 && input <= 0) {
                System.out.println("No number entered.");
                return;
            }

            // Check for stop-condition
            if (input > 0){

                // Check for new largestNum and increment numCnt
                if (input > largestNum) {
                    largestNum = input;
                }
                numCnt++;
            } else break;

        } while (true);

        System.out.printf("The largest number is %.2f" + System.lineSeparator(), largestNum);
    }

    //todo Task 2
    public void stairs() {
        // input your solution here


    }

    //todo Task 3
    public void printPyramid() {
        // input your solution here
    }

    //todo Task 4
    public void printRhombus() {
        // input your solution here
    }

    //todo Task 5
    public void marks() {
        // input your solution here
    }

    //todo Task 6
    public void happyNumbers() {
        // input your solution here
    }

    public static void main(String[] args) {
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}