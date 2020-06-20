import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int toCheck = scanner.nextInt();
        int count = 0;
        for (int a : array) {
            if (toCheck == a) {
                count++;
            }
        }
        System.out.println(count);
    }
}