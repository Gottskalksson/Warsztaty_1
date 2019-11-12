package pl.coderslab.warsztaty1.zad1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        int max = 5;
        int tryNumber = max;

        System.out.println("I drew a number between 1-100. Guess what? You have exactly " + max + " chances!");

        int writeNum = readNumber();

        while (writeNum != num) {

            if (writeNum > num) {
                System.out.println("Your number is too big!");
                tryNumber--;
                System.out.println(tryNumber + " chances left.");

            } else if (writeNum < num) {
                System.out.println("Your number is too small!");
                tryNumber--;
                System.out.println(tryNumber + " chances left.");

            }

            if (tryNumber == 0) {
                break;
            } else {
                writeNum = readNumber();
            }
        }
        if (writeNum == num) {
            System.out.println("Congratulations! You wrote correct number in the " + (max - tryNumber + 1) + " time!");
        } else {
            System.out.println("You lost the game!");
            System.out.println("Correct answer is: " + num);
        }
    }

    public static int readNumber() {
        System.out.print("Write your number: ");
        Scanner scan = new Scanner(System.in);
        int num = -1;
        while (!(num > 0)) {
            try {
                num = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Your number is incorrect!");
                System.out.print("Write your number again: ");
            }
        }
        return num;
    }
}
