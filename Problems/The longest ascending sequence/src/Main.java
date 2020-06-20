import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int longestSequence = 1;
//        int temp = 1;
//        for (int i = 0; i < array.length - 1; i++) {
//            boolean ascending = array[i] < array[i + 1];
//            if (ascending) {
//                temp++;
//            } else {
//                temp = 1;
//            }
//            longestSequence = Math.max(longestSequence, temp);
//        }

        // moze i ovako
        for (int i = 0; i < array.length; i++) {
            int temp = 1;
            while (i < array.length - 1 && array[i] < array[i + 1]) {
                temp++;
                i++;
            }
            longestSequence = Math.max(longestSequence, temp);
        }
        System.out.println(longestSequence);
    }
}