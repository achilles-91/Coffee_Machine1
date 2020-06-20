import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        long[] longNumbers = {100_000_000_001L, 100_000_000_002L, 100_000_000_003L};
        System.out.println(Arrays.toString(longNumbers));



        int[] nums = {1, 2, 3, 4, 5};
        Arrays.fill(nums, 1, 5, 10);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.equals(nums, nums));
    }
}