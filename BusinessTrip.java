package by.gsu.epamlab;

public class BusinessTrip {

    private final static int RATE = 10000;
    private String account;
    private int transport;
    private int days;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, int transport, int days) {
        this.account = account;
        this.transport = transport;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransport() {
        return transport;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal(){
        return transport + RATE*days;
    }

    private String toFinValue(int value){
        if (value % 100 == 0)
            return value/100 + ".00";
        else if (value % 100 < 10)
            return value/100 + ".0" + value % 100;
        else
            return value/100 + "." + value % 100;
    }

    public void show(){
        System.out.println("rate = " + toFinValue(RATE));
        System.out.println("account = " + account);
        System.out.println("transport = " + toFinValue(transport));
        System.out.println("days = " + days);
        System.out.println("total = " + toFinValue(getTotal()));
    }

    @Override
    public String toString() {
            return account + "; " + toFinValue(transport) + "; " + days + "; " + toFinValue(getTotal());
    }
}
