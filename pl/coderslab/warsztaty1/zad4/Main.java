package pl.coderslab.warsztaty1.zad4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int finalScore = rollDice("D3-1");
        System.out.println(finalScore);
    }


    private static int rollDice(String dice) {
        int dIndex = dice.indexOf("D");
        String xStr = dice.substring(0, dIndex);
        int x = generateX(xStr);
        String str = dice.substring(dIndex+1);
        int y = generateY(str);
        int z = generateZ(str);
        return generateNumber(x, y, z);
    }

    //how many times the dice must be rolled
    private static int generateX(String xStr) {
        if (xStr.equals("")){
            return  1;
        } else {
            return Integer.parseInt(xStr);
        }
    }

    //checked, how many walls has cube
    private static int generateY(String dice) {
        if (dice.contains("+")) {
            int plusIndex = dice.indexOf("+");
            String yStr = dice.substring(0, plusIndex);
            return Integer.parseInt(yStr);
        } else if (dice.contains("-")) {
            int minusIndex = dice.indexOf("-");
            String yStr = dice.substring(0, minusIndex);
            return Integer.parseInt(yStr);
        } else {
            return Integer.parseInt(dice);
        }
    }

    //checked, how many points must be added or subtracted after all rolls
    private static int generateZ(String dice) {
        if (dice.contains("+")) {
            int plusIndex = dice.indexOf("+");
            String zStr = dice.substring(plusIndex+1);
            return Integer.parseInt(zStr);
        } else if (dice.contains("-")) {
            int minusIndex = dice.indexOf("-");
            String zStr = dice.substring(minusIndex);
            return Integer.parseInt(zStr);
        } else {
            return  0;
        }
    }

    //sum all rolls
    private static int generateNumber(int x, int y, int z) {
        int result = 0;
        Random r = new Random();
        for (int i = 0; i < x; i++) {
            result += r.nextInt(y) + 1;
        }
        result += z;
        return result;
    }

}
