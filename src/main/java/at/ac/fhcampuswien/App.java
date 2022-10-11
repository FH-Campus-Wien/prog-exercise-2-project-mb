package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Final vars
    final int ROWS = 6;

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

    // alterCharIdxFromMiddle: relative index from charToPrint
    // targetCharIdx: relative index from middleIdx
    private void PrintIsoscelesPolygon(int rowCnt, char charToPrint, boolean willReverse, int charIdxIncrement, int targetCharIdx) {
        int colCnt;     // number of columns in row
        int maxColCnt;  // max columns in polygon

        if (willReverse) maxColCnt = rowCnt;
        else maxColCnt = (rowCnt * 2) - 1;

        // row-Loop
        for (int r = 0, i = 0; r < rowCnt; r++) {
            if (willReverse) {

                // calc coefficient to alter the row count if willReverse and r on mirrored side
                if (r > rowCnt / 2) {
                    i += 2;
                }

                // calc column count for current row
                colCnt = (rowCnt + 1) / 2 + r - i;
            } else colCnt = (rowCnt + r);

            // print current row
            System.out.println(PrintRowForIsocelesPolygon(charToPrint, colCnt, maxColCnt, charIdxIncrement, targetCharIdx));
        }
    }

    private java.lang.String PrintRowForIsocelesPolygon(char charToPrint, int colCnt, int maxColCnt, int charIdxIncrement, int targetCharIdx) {
        // number of chars in column
        // maxColCnt - colCnt corresponds to whitspaces
        int charCnt = colCnt - (maxColCnt - colCnt);

        // (charCnt + 1) / 2 corresponds to the middle index of a row
        // -1 because my indexes start with zero
        int splitIdx = (((charCnt + 1) / 2) - 1) + targetCharIdx;

        // starting index of char in current row
        int startCharIdx = splitIdx * charIdxIncrement;

        // currCharIdx increments with Abs(charIdxIncrement)
        int currCharIdx;
        int currIdx;


        // alteredCharToPrint can be initialized with startCharIdx
        // because startCharIdx defines the first char in a row
        char alteredCharToPrint = (char) (charToPrint + startCharIdx);

        StringBuilder strToPrint = new StringBuilder();

        // col-Loop
        for (int c = 0; c < colCnt; c++) {

            // check for current char to print
            if (c < (colCnt - charCnt)) strToPrint.append(" ");
            else {

                // alter char if needed
                if (charIdxIncrement != 0) {

                    // currIdx: absolute index of current character
                    // c - (colCnt - charCnt) is the current index
                    currIdx = c - (colCnt - charCnt);

                    // currCharIdx: relative index to current character
                    // Abs(charIdxIncrement) defines increment interval
                    currCharIdx = currIdx * charIdxIncrement;

                    // first segment of row
                    if (currIdx < splitIdx) {
                        // '*(-1)' changes the sign of incrementation
                        // needed because programm is defined to run from left to right
                        alteredCharToPrint = (char) (charToPrint + startCharIdx + currCharIdx * (-1));
                    }

                    // second segment of row
                    else {
                        // currCharIdx - splitIdx * charIdxIncrement: restets the starting point to charToPrint
                        // * charIdxIncrement changes splitIdx to relative indexing
                        alteredCharToPrint = (char) (charToPrint + (currCharIdx - splitIdx * charIdxIncrement));
                    }
                }

                strToPrint.append(alteredCharToPrint);
            }
        }

        return strToPrint.toString();
    }

    //todo Task 3
    public void printPyramid() {
        // input your solution here

        PrintIsoscelesPolygon(ROWS, '*', false, 0, 0);
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

        // Check for invalid height input
        if (rowCnt > 0 && rowCnt % 2 != 0) {
            PrintIsoscelesPolygon(rowCnt, _char, true, -1, 0);
        } else System.out.println("Invalid number!");
    }

    //todo Task 5
    public void marks() {
        // input your solution here

        int mark;
        int markCnt = 0;
        double markAverage = 0;
        int negMarkCnt = 0;

        while (true) {
            System.out.printf("Mark %d: ", markCnt + 1);
            mark = sc.nextInt();

            if (mark != 0) {
                if (mark > 0 && mark < 6) {
                    if (mark == 5) negMarkCnt++;
                    markAverage += mark;
                    markCnt++;
                } else System.out.println("Invalid mark!");
            } else break;
        }

        if (markCnt > 0) markAverage /= markCnt;

        System.out.printf("Average: %.2f" + System.lineSeparator(), markAverage);
        System.out.printf("Negative marks: %d" + System.lineSeparator(), negMarkCnt);
    }

    //todo Task 6
    public void happyNumbers() {
        // input your solution here

        int num;

        System.out.print("n: ");
        num = sc.nextInt();


        do {
            num = CalcNextNum(num);
        } while (num != 1 && num != 4);

        switch (num) {
            case 1:
                System.out.println("Happy number!");
                break;
            case 4:
                System.out.println("Sad number!");
                break;
            default:
                System.out.println("WTFAmI");
        }
    }

    private int CalcNextNum(int num) {
        int sumOfUnitsSquared = 0;

        ArrayList<Integer> units = new ArrayList<>();

        do {
            units.add((int) Math.pow(num % 10, 2));
            num /= 10;
        } while (num > 0);

        for (int u : units) {
            sumOfUnitsSquared += u;
        }

        return sumOfUnitsSquared;
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