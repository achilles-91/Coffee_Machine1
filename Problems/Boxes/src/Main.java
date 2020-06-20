import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        fillArray(box1);
        fillArray(box2);
        Arrays.sort(box1);
        Arrays.sort(box2);

        if (Arrays.equals(box1, box2)) {
            System.out.println("Box 1 = Box 2");
        } else if (canFit(box1, box2)) {
            System.out.println("Box 1 > Box 2");
        } else if (canFit(box2, box1)) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incomparable");
        }
    }

    public static boolean canFit(int[] a, int[] b) {
        boolean canFit = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= b[i]) {
                continue;
            } else {
                canFit = false;
                break;
            }
        }
        return canFit;
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }
}