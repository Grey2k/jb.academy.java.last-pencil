package lastpencil;

import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class Game {
    private final char PENCIL_SYMBOL = '|';
    private final int PENCIL_LIMIT = 3;
    private final String BOT_NAME = "Jack";
    private int pencils;

    private final String first;
    private final String next;
    private final Bot bot;

    public Game(Integer pencilsQty, String first, String next) {
        this.first = first;
        this.next = next;

        this.bot = new Bot(BOT_NAME, PENCIL_LIMIT);
        this.init(pencilsQty);
    }

    private void init(Integer pencilQty) {
        this.pencils = pencilQty;
        this.printPencils();
    }

    public void printPencils() {
        String[] result = new String[this.pencils];
        for (int i = 0; i < this.pencils; i++) {
            result[i] = String.valueOf(PENCIL_SYMBOL);
        }
        System.out.println(String.join("", result));
    }

    public void run() {
        String currentTurn = this.first;
        System.out.println(currentTurn + "'s turn!");

        Scanner sc = new Scanner(System.in);

        while (this.pencils > 0) {
            int grab;

            try {
                // bot turn logic
                if (this.bot.name.equals(currentTurn)) {
                    grab = this.bot.turn(this.pencils);
                    System.out.println(grab);
                } else {
                    grab = Integer.parseInt(sc.nextLine());
                }

                if ((grab < 1) || (grab > PENCIL_LIMIT)) {
                    throw new NumberFormatException("Not a possible value");
                } else if ((grab > this.pencils)) {
                    throw new IllegalArgumentException("Too many pencils were taken");
                }
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2' or '3'");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            this.pencils -= grab;
            this.printPencils();

            currentTurn = currentTurn.equals(this.first) ? this.next : this.first;
            if (pencils > 0) {
                System.out.println(currentTurn + "'s turn!");
            } else {
                System.out.println(currentTurn + " won!");
            }
        }
    }
}
