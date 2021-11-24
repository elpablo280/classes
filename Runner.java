import by.epam.lab.Purchase;
import by.epam.lab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))){
            sc.useLocale(Locale.ENGLISH);

            // creating an array
            final int PURCHASES_NUMBER = Integer.parseInt(sc.nextLine());
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            // initialise an array
            int[] number = new int[PURCHASES_NUMBER];
            double[] percent = new double[PURCHASES_NUMBER];
            int[] day = new int[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                number[i] = sc.nextInt();
                percent[i] = sc.nextDouble();
                day[i] = sc.nextInt();
                purchases[i] = new Purchase(number[i], percent[i], day[i]);
            }

            // output the array, calculating the mean cost of all purchases, the total cost of al purchases on Monday, the day with whe max purchase cost
            Purchase maxPurchase = new Purchase();
            int meanCost = 0;
            int costMonday = 0;
            System.out.printf("%s;%d.%02d%n", Purchase.PRODUCT_NAME, Purchase.PRICE/100, Purchase.PRICE%100);
            for (Purchase purchase : purchases){
                if (purchase.getCost() > maxPurchase.getCost()){
                    maxPurchase = purchase;
                }
                if (purchase.getWeekDay() == WeekDay.MONDAY){
                    costMonday += purchase.getCost();
                }
                System.out.println(purchase);
                meanCost += purchase.getCost();
            }
            System.out.printf("Day with maximum purchase cost : %s", maxPurchase.getWeekDay());
            System.out.printf("\nMean cost of all purchases : %d.%02d", meanCost/100, meanCost%100);
            System.out.printf("\nTotal cost of all purchases on Monday : %d.%02d", costMonday/100, costMonday%100);

            // sort the array by the field number
            Arrays.sort(purchases);

            // output the array
            System.out.printf("\n%s;%d.%02d%n", Purchase.PRODUCT_NAME, Purchase.PRICE/100, Purchase.PRICE%100);
            for (Purchase purchase : purchases) {
                System.out.println(purchase.toString());
            }

            // find some purchase with number = 5 and output it
            int[] arr = new int[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                arr[i] = purchases[i].getNumber();
            }
            System.out.println("Purchase with number 5 : " + purchases[Arrays.binarySearch(arr, 5)]);
        } catch (FileNotFoundException e){
            System.out.println("Input file is not found");
        }
    }
}