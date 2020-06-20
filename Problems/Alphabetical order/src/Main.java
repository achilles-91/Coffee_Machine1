import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        boolean alphabetical = true;
        String previousString = array[0];

        for (int i = 1; i < array.length; i++) {
            if (previousString.compareTo(array[i]) > 0) {
                alphabetical = false;
                break;
            }
            previousString = array[i];

        }
        System.out.println(alphabetical);
    }
}


//        String[] arr = scanner.nextLine().trim().split(" ");
//
//        boolean alphabetical = true;
//        String lastOne = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i].compareTo(lastOne) < 0) {
//                alphabetical = false;
//                break;
//            }
//            lastOne = arr[i];
//        }
//
//        System.out.println(alphabetical);


//        final Scanner scanner = new Scanner(System.in);
//        boolean toOutput = true;
//        String[] mainArray = scanner.nextLine().split(" ");
//
//        for (int i = 0; i < mainArray.length - 1 && toOutput; i++) {
//            String[] firstOne = mainArray[i].split("");
//            String[] secondOne = mainArray[i + 1].split("");
//
//            for (int j = 0; j < firstOne.length && j < secondOne.length; j++) {
//                String x = firstOne[j];
//                String y = secondOne[j];
//
//                int compare = x.compareTo(y);
//                if (compare > 0) {
//                    toOutput = false;
//                    break;
//                }
//
//                if (j + 1 < firstOne.length &&  j + 1 >= secondOne.length) {
//                    toOutput = false;
//                    break;
//                }
//            }
//        }
//        System.out.println(toOutput);
//    }
