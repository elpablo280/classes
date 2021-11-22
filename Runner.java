import by.epam.lab.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(new FileReader("src/in.txt"))){
            sc.useLocale(Locale.ENGLISH);
            sc.useDelimiter(System.getProperty("line.separator"));

            // creating an array
            int purchasesNumber = Integer.parseInt(sc.nextLine());
            Purchase[] purchases = new Purchase[purchasesNumber];

            // initialise an array
            String[][] var = new String[purchasesNumber][3];
            for (int i = 0; i < purchasesNumber; i++) {
                var[i] = sc.nextLine().split(" ");
                purchases[i] = new Purchase(Integer.parseInt(var[i][0]), Integer.parseInt(var[i][1]), Purchase.WeekDay.values()[Integer.parseInt(var[i][2])]);
            }

            // output the array, calculating the mean cost of all purchases, the total cost of al purchases on Monday, the day with whe max purchase cost
            Purchase maxPurchase = new Purchase();
            int meanCost = 0;
            int costMonday = 0;
            System.out.println(String.format("%s;%d.%02d", purchases[0].getPRODUCT_NAME(), purchases[0].getPRICE()/100, purchases[0].getPRICE()%100));
            for (Purchase purchase : purchases){
                if (purchase.getCost() > maxPurchase.getCost()){
                    maxPurchase = purchase;
                }
                if (purchase.getWeekDay() == Purchase.WeekDay.MONDAY){
                    costMonday += purchase.getCost();
                }
                System.out.println(purchase.toString());
                meanCost += purchase.getCost();
            }
            System.out.print("Day with maximum purchase cost : ");
            System.out.println(maxPurchase.getWeekDay());
            System.out.print("Mean cost of all purchases : ");
            System.out.println(String.format("%d.%02d", meanCost/100, meanCost%100));
            System.out.print("Total cost of all purchases on Monday : ");
            System.out.println(String.format("%d.%02d", costMonday/100, costMonday%100));

            // sort the array by the field number
            Arrays.sort(purchases);

            // output the array
            System.out.println(String.format("%s;%d.%02d", purchases[0].getPRODUCT_NAME(), purchases[0].getPRICE()/100, purchases[0].getPRICE()%100));
            for (Purchase purchase : purchases) {
                System.out.println(purchase.toString());
            }

            // find some purchase with number = 5 and output it
            int[] arr = new int[purchasesNumber];
            for (int i = 0; i < purchasesNumber; i++) {
                arr[i] = purchases[i].getNumber();
            }
            System.out.print("Purchase with number 5 : ");
            System.out.println(purchases[Arrays.binarySearch(arr, 5)].toString());

        } catch (FileNotFoundException e){
            System.out.println("Input file is not found");
        }

    }
}
