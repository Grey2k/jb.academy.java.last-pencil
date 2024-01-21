import java.util.Scanner;

class Main {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public static final int FIZZ_DIVISOR = 3;
    public static final int BUZZ_DIVISOR = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int finish = scanner.nextInt();

        for (int i = start; i <= finish; i++) {
            StringBuilder result = new StringBuilder();

            if (i % FIZZ_DIVISOR == 0) {
                result.append(FIZZ);
            }
            if (i % BUZZ_DIVISOR == 0) {
                result.append(BUZZ);
            }

            System.out.println(result.isEmpty() ? i : result.toString());
        }
    }
}