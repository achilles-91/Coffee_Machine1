import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int indexOfMax = 0;

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
//            System.out.print("\n[" + i +"] element has value of " + array[i]);
            if (array[i] > array[indexOfMax]) {
                indexOfMax = i;
            }
//            System.out.print("\tindex of max is " + indexOfMax);
        }
        System.out.println(indexOfMax);
    }
}