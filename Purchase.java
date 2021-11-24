package by.epam.lab;

public class Purchase implements Comparable<Purchase> {

    public static final String PRODUCT_NAME = "milk";
    public static final int PRICE = 100;
    private int number;
    private double percent;
    private int weekDay;
    public WeekDay dayOfWeek;

    public Purchase() {
    }

    public Purchase(int number, double percent, WeekDay dayOfWeek) {
        this.number = number;
        this.percent = percent;
        this.dayOfWeek = dayOfWeek;
    }

    public Purchase(int number, double percent, int weekDay) {
        this.number = number;
        this.percent = percent;
        this.dayOfWeek = WeekDay.values()[weekDay];
    }

    public WeekDay getWeekDay() {
        return dayOfWeek;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.dayOfWeek = weekDay;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getCost() {
        return (int) Math.round(PRICE*number*(100 - percent)/100);
    }

    @Override
    public String toString() {
        return String.format("%d;%.1f;%s;%d.%02d", number, percent, dayOfWeek, getCost()/100, getCost()%100);
    }

    @Override
    public int compareTo(Purchase purchase) {
        return Integer.compare(number, purchase.number);
    }
}
