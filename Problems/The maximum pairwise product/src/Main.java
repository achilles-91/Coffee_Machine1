import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int maximum = Integer.MIN_VALUE;


        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] * array[i + 1] > maximum) {
                maximum = array[i] * array[i + 1];
            }
        }
        System.out.println(maximum);

    }
}