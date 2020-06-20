import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numOfCompanies = scanner.nextInt();

        double[] arrayIncome = new double[numOfCompanies];
        for (int i = 0; i < arrayIncome.length; i++) {
            arrayIncome[i] = scanner.nextInt();
        }

        double[] arrayPercent = new double[numOfCompanies];
        for (int i = 0; i < arrayPercent.length; i++) {
            arrayPercent[i] = scanner.nextInt() / 100.0;
        }

        int paysMost = 1;
        for (int i = 0; i < numOfCompanies - 1; i++) {
            double currentI = arrayIncome[i] * arrayPercent[i];
            double nextI = arrayIncome[i + 1] * arrayPercent[i + 1];
            if (nextI > currentI){
                paysMost = i + 2;
            }
        }
        System.out.println(paysMost);
    }
}