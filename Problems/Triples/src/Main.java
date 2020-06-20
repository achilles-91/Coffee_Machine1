import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int triples = 0;
        for (int i = 2; i < len; i++) {
            if (array[i] - array[i - 1] == 1 && (array[i - 1]) - array[i - 2] == 1) {
                triples++;
            }
        }
        System.out.println(triples);
    }
}




















//        int[] array = new int[scanner.nextInt()];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        int triples = 0;
//        for (int i = 0; i < array.length - 1; i++) {
//            int count = 0;
//            for (int j = i; j < array.length -1; j++) {
//                boolean ascendingByOne = array[j] + 1 == array[j + 1];
//                if (ascendingByOne) {
//                    count++;
//                    if (count == 2) {
//                        triples++;
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//        System.out.println(triples);
