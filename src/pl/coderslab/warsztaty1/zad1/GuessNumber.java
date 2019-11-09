package pl.coderslab.warsztaty1.zad1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random r = new Random();
        int num = r.nextInt(100) + 1;

        System.out.println("Wylosowałem liczbę. Zganij, jaką?");

        int writeNum = readNumber();
        int max = 10;
        int tryNumber = 10;

        while (writeNum != num) {

            if (writeNum > num) {
                System.out.println("Podałeś za dużą liczbę!");
                tryNumber--;
                System.out.println("Ilość prób, jaka Ci została: "+tryNumber);

            } else if (writeNum < num) {
                System.out.println("Podałeś za małą liczbę!");
                tryNumber--;
                System.out.println("Ilość prób, jaka Ci została: "+tryNumber);

            }

            if (tryNumber == 0) {
                break;
            } else {
                writeNum = readNumber();
            }
        }
        if (writeNum == num) {
            System.out.println("Brawo! Odgadłeś liczbę za " + (max - tryNumber + 1) + " razem!");
        } else {
            System.out.println("Przegrałeś!");
            System.out.println("Prawidłowa odpowiedź to: " + num);
        }
    }

    public static int readNumber () {
        System.out.println("Podaj liczbę: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextLine()) {
            System.out.println("Musisz podać liczbę!");
        }
        return scan.nextInt();
    }
}
