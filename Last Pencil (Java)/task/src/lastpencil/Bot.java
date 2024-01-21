package lastpencil;

import java.util.Random;

public class Bot {
    public final String name;
    private final int limit;

    public Bot(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public int turn(int pencilsLeft) {
        int grab;

        // current turn win condition
        boolean winning = (pencilsLeft - 1) % (this.limit + 1) != 0;

        if (winning) {
            grab = (pencilsLeft - 1) % (this.limit + 1);
        } else if (pencilsLeft > this.limit) {
            grab = (new Random()).nextInt(1, this.limit + 1);
        } else {
            grab = (new Random()).nextInt(1, pencilsLeft + 1);
        }

        return grab;
    }
}
