package lastpencil;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] players = new String[]{"John", "Jack"};

        int pencils = 0;
        System.out.println("How many pencils would you like to use");

        while (!(pencils > 0)) {
            try {
                pencils = Integer.parseInt(sc.nextLine());
                if (pencils == 0) {
                    throw new IllegalArgumentException("Zero is not a positive number");
                }
                if (pencils < 0) {
                    throw new NumberFormatException("Negative is not a numeric symbol");
                }
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            } catch (IllegalArgumentException e) {
                System.out.println("The number of pencils should be positive");
            }
        }

        String first = "";
        System.out.println("Who will be the first (John, Jack)");

        while (first.isEmpty()) {
            String player = sc.nextLine();
            if (!Arrays.asList(players).contains(player)) {
                System.out.println("Choose between '" + players[0] + "' and '" + players[1] + "'");
            } else {
                first = player;
            }
        }

        String next = players[0].equals(first) ? players[1] : players[0];
        Game game = new Game(pencils, first, next);

        game.run();
    }
}
