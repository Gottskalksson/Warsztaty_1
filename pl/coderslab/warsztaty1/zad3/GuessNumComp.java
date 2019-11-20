package pl.coderslab.warsztaty1.zad3;

import java.util.Scanner;

public class GuessNumComp {
    public static void main(String[] args) {
        System.out.println("Please drew a number between 1-1000 and I will try to guess, which one is it! And I have only 10 chances.");
        System.out.println("If You are ready to play, press Enter.");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        int tryNumber = 10;
        int min = 1;
        int max = 1000;
        int guess = guessNum(min, max);
        while (tryNumber > 0) {
            System.out.println("I guess, it is " + guess);
            System.out.println("Is it this number correct? Write down 'yes' or 'no': ");
            String answer = forCheaters(scan.next());

            if (answer.equalsIgnoreCase("no")) {
                tryNumber--;
                if (tryNumber == 0) {
                    System.out.println("NOOOOO! I lost! ;<");
                    break;
                }
                System.out.println("Is it too big?");
                String nextAnswer = forCheaters(scan.next());

                if (nextAnswer.equalsIgnoreCase("yes")) {
                    max = guess;
                    guess = guessNum(min, max);

                } else {
                    System.out.println("Is it too small?");
                    String lastAnswer = forCheaters(scan.next());

                    if (lastAnswer.equalsIgnoreCase("yes")) {
                        min = guess;
                        guess = guessNum(min, max);

                    } else {
                        System.out.println("Don't cheated me!");
                    }
                }

            } else {
                System.out.println("YES! I'm the best!");
                System.out.println("Thanks for the play!");
                break;
            }
        }
    }

    private static String forCheaters (String answer) {
        while (!(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no"))) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Wrong answer!");
            System.out.println("Write down 'yes' or 'no': ");
            answer = scan.next();
        }
        return answer;
    }

    private static int guessNum (int min, int max) {
        return ((max - min) / 2) + min;
    }
}
