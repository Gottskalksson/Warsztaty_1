package pl.coderslab.warsztaty1.zad2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        System.out.println(drawingResult());
    }

    private static int[] userDraw() {
        int[] tab = new int[6];
        System.out.println("Write down numbers between 1-49. Press Enter after write every number. " +
                "Remember, every number must be only once.");
        // user fills their coupon
        for (int i = 0; i < tab.length; i++) {
            tab[i] = userNumber();
        }
        Arrays.sort(tab);

        //checked any repeats in user's coupon
        int errors;

        do {
            errors = 0;
            for (int i = 0; i < tab.length - 1; i++) {
                for (int j = i + 1; j < tab.length; j++) {
                    if (tab[i] == tab[j]) {
                        while (tab[i] == tab[j]) {
                            errors++;
                            System.out.println("Number " + tab[i] + " is more than once. Write another number.");
                            tab[j] = userNumber();
                        }
                    }
                }
            }
            Arrays.sort(tab);
        } while (errors != 0);
        System.out.println("Your numbers: ");
        System.out.println(Arrays.toString(tab));
        return tab;
    }

    private static int userNumber() {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        while (num < 1 || num > 49) {
            try {
                num = Integer.parseInt(scan.nextLine());
                while (num < 1 || num > 49) {
                    System.out.println("You wrote incorrect number. Please write down new number between 1-49.");
                    num = Integer.parseInt(scan.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("You didn't write a number! Try again:");
            }
        }
        return num;
    }

    //computer draws lucky numbers
    private static Integer[] drewNumber() {
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arr));
        Integer[] result = Arrays.copyOf(arr, 6);
        Arrays.sort(result);
        System.out.println("The result of draw: ");
        System.out.println(Arrays.toString(result));
        return result;
    }

    //here computer checked user coupon with lucky numbers and return result of drawing
    private static String drawingResult() {
        int[] tab = userDraw();
        Integer[] drew = drewNumber();

        int result = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i] == drew[j]) {
                    result++;
                }
            }
        }

        if (result > 2) {
            return "Congratulations! You have today " + result + " numbers of 6!";
        } else {
            return "Unfortunately you have today only " + result + " number(s) of 6. You won nothing.";
        }
    }
}

