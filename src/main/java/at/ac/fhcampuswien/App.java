package at.ac.fhcampuswien;

import sun.jvm.hotspot.tools.SysPropsDumper;

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
            if (input > 0) {

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

        int rowCnt;
        int cellIdx = 1;

        System.out.print("n: ");
        rowCnt = sc.nextInt();

        // Check for invalid input
        if (rowCnt < 1) {
            System.out.println("Invalid number!");
            return;
        }

        // Print out triangle
        for (int r = 0, c; r < rowCnt; r++) {
            for (c = 0; c <= r; c++) {
                System.out.print(cellIdx++ + " ");
            }
            System.out.println();
        }
    }

    // Final vars
    final int ROWS = 6;

    //todo Task 3
    public void printPyramid() {
        // input your solution here

        PrintPyramid(ROWS, '*', 0, false);
    }


    // nextCharFromMiddle:
    // -1: char-1
    // 0: char stays the same
    // (+)1: char+1
    private void PrintPyramid(int rows, char charToPrint, int nextCharFromMiddle, boolean willReverse) {
        int colCnt;     // number of columns in row
        int charCnt;    // number of chars in column

        if (willReverse) rows *= 2 - 1;

        // RowLoop
        for (int r = 0, c; r < rows; r++) {
            colCnt = (rows + r);
            charCnt = (r * 2) + 1;

            // ColLoop
            for (c = 0; c < colCnt; c++) {

                // Check for character to print
                if (c < colCnt - charCnt) System.out.print(" ");
                else System.out.print(charToPrint);
            }

            // ColLoop Reversed
            if (willReverse) {
                for (c = 0; c < colCnt; c++) {

                    // Check for character to print
                    if (c < colCnt - charCnt) System.out.print(" ");
                    else System.out.print(charToPrint);
                }
            }

            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus() {
        // input your solution here

        int rowCnt;
        char _char;

        System.out.print("h: ");
        rowCnt = sc.nextInt();
        System.out.print("c: ");
        _char = sc.next().charAt(0);

        // Check for invalid input
        if (rowCnt % 2 != 0) {
            System.out.println("Invalid number!");
            return;
        }

        // PrintPyramid(rowCnt, _char);
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