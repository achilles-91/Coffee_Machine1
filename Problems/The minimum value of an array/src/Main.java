import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[scanner.nextInt()];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println(min);
    }
}