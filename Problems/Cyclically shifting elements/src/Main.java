import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int[] copyArray = new int[len];
        System.arraycopy(array, 0, copyArray, 1, len - 1);
        copyArray[0] = array[len - 1];
        for (int a : copyArray) {
            System.out.print(a + " ");
        }


//
//        int firstOne = array[len - 1];
//        for (int i = len - 1; i > 0; i--) {
//            array[i] = array[i - 1];
//            if (i == 1) {
//                array[0] = firstOne;
//                break;
//            }
//        }
//        for (int a : array) {
//            System.out.print(a + " ");
//        }



    }
}