package by.epam.lab;

public class Purchase implements Comparable<Purchase> {

    private final String PRODUCT_NAME = "milk";
    private final int PRICE = 100;
    private int number;
    private int percent;
    public enum WeekDay {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
    public WeekDay weekDay;

    public Purchase() {
    }

    public Purchase(int number, int percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getCost() {
        return Math.round(PRICE*number*(100 - percent)/100);
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%s;%d.%02d", number, percent, weekDay, getCost()/100, getCost()%100);
    }

    @Override
    public int compareTo(Purchase purchase) {
        if (number < purchase.number){
            return -1;
        }
        return 0;
    }
}
