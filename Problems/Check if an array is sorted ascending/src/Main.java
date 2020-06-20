import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        boolean ascending = true;

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (i >= 1 && array[i] < array[i-1]) {
                ascending = false;
            }
        }

        System.out.println(ascending);


    }
}