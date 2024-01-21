import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int toBeShipped = 0;
        int toBeFixed = 0;
        int toBeRejected = 0;

        for (int i = 0; i < n; i++) {
            int line = scanner.nextInt();
            if (line == 0) {
                toBeShipped++;
            } else {
                toBeFixed += line == 1 ? 1 : 0;
                toBeRejected += line == -1 ? 1 : 0;
            }
        }

        System.out.printf("%d %d %d%n", toBeShipped, toBeFixed, toBeRejected);
    }
}
