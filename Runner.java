import by.gsu.epamlab.BusinessTrip;

public class Runner {
    public static void main(String[] args) {

        // creating an array
        BusinessTrip[] businessTrips = {
                new BusinessTrip("Anton Shumskiy", 1620, 5),
                new BusinessTrip("Sakovich", 2840, 7),
                null,
                new BusinessTrip("Zhulinsky", 2100, 10),
                new BusinessTrip()
        };

        // output the array content and the business trip with maximum cost
        BusinessTrip maxCost = new BusinessTrip();
        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null) {
                businessTrip.show();
                if (businessTrip.getTotal() > maxCost.getTotal()) {
                    maxCost = businessTrip;
                }
            }
        }
        System.out.println("Business trip with maximum cost : ");
        maxCost.show();

        // update the transportation expenses for the last object of the array
        businessTrips[businessTrips.length - 1].setTransport(3200);

        // output the total duration of 2 initial business trips
        System.out.println("Duration = " + (businessTrips[0].getDays() + businessTrips[1].getDays()));

        // output the array content to the console
        for (BusinessTrip businessTrip : businessTrips) {
            System.out.println(businessTrip);
        }
    }
}
