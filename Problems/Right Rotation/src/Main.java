import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] sArray = scanner.nextLine().split(" ");

        int[] nums = new int[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            nums[i] = Integer.parseInt(sArray[i]);
        }

        int timesToRotate = scanner.nextInt() % nums.length;
        nums = rotate(timesToRotate, nums);
        print(nums);
    }

    public static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static int[] rotate(int numberOfRotation, int[] rotated) {
        for (int i = 0; i < numberOfRotation; i++) {
            int firstOne = rotated[rotated.length - 1];
            for (int j = rotated.length - 1; j >= 0; j--) {
                if (j == 0) {
                    break;
                } else {
                    rotated[j] = rotated[j - 1];
                }
            }
            rotated[0] = firstOne;
        }
        return rotated;
    }

}
