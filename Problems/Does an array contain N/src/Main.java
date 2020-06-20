import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        boolean contain = false;

        for (int a : array) {
            if (n == a) {
                contain = true;
            }
        }
        System.out.println(contain);
    }
}