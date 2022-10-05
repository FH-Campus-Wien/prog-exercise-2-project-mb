package at.ac.fhcampuswien;

import java.util.Locale;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        // input your solution here
        double input;
        double max = 0;
        int count = 1;

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);  //enable us float input; eg: 2.2

        do {
            //Todo remove println for successful tests
            System.out.print("Number " + count + ": ");

            if (scan.hasNextDouble()) {         //check if is valid double
                input = scan.nextDouble();

                if(input > max){
                    max = input;
                }
                count++;
            } else {
                input = 0;
            }

        } while (input > 0);

        if(max <= 0){
            System.out.println("No number entered.");
        } else {
            System.out.println("The largest number is " + String.format(Locale.US,"%.2f", max));
        }
    }

    //todo Task 2
    public void stairs(){
        // input your solution here
        Scanner scan = new Scanner(System.in);

        System.out.print("n: ");

        int input = scan.nextInt();
        int count = 1;

        if(input > 0){
            for (int i = 0; i < input; i++){
                for (int j = 0; j <= i; j++){
                    System.out.print(count + " ");
                    count++;
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid number!");
        }
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
        final int rows = 6;
        int i, space, k = 0;

        for(i = 1; i <= rows; i++) {
            for(space = 1; space <= (rows - i); space++) {
                System.out.print(" ");
            }

            while(k != (2 * i - 1)) {
                System.out.print("*");
                k++;
            }

            k = 0;

            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
        Scanner scan = new Scanner(System.in);
        System.out.print("h: ");
        int h = scan.nextInt();
        System.out.print("c: ");
        char c = scan.next().charAt(0);

        // Quick & Dirty
        if(h % 2 == 1){
            for(int i = 0; i <= h / 2; i++){
                printChar(h, c, i);
            }
            for(int i = (h / 2) - 1; i >= 0; i--){
                printChar(h, c, i);
            }
        } else {
            System.out.println("Invalid number!");
        }
    }

    private void printChar(int h, char c, int i) {
        for(int j = i; j < h / 2; j++){
            System.out.print(" ");
        }
        for(int k = -i; k <= i; k++){
            System.out.print((char)(c - Math.abs(k)));
        }
        System.out.println();
    }

    //todo Task 5
    public void marks(){
        // input your solution here
        Scanner scan = new Scanner(System.in);
        int input;
        int sum = 0, count = 1, evil = 0;

        do{
            System.out.print("Mark " + count  + ": ");
            input = scan.nextInt();

            if( input > 0 && input < 6){
                sum += input;
                count++;

                if(input == 5){
                    evil++;
                }
            } else {
                if(input != 0){
                    System.out.println("Invalid mark!");
                }
            }

        } while (input != 0);

        count--;
        float avg = 0;
        if(sum > 0){
            avg = (float) sum/count;
        }

        System.out.println("Average: " + String.format(Locale.US,"%.2f", avg));
        System.out.println("Negative marks: " + evil);
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
        Scanner scan = new Scanner(System.in);
        int input, sum = 0;

        System.out.print("n: ");
        input = scan.nextInt();

        while(input != 1 && input != 4) {
            while (input != 0) {
                sum += Math.pow(input % 10, 2);
                input /= 10;
            }
            input = sum;
            sum = 0;
        }

        if(input == 1) {
            System.out.println("Happy number!");
        } else {
            System.out.println("Sad number!");
        }
    }

    public static void main(String[] args){
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