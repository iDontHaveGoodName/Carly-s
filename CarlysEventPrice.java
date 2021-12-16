import java.text.DecimalFormat;
import java.util.Scanner;

/*
    This program will ask the user to enter the ammount of people
    attending a party. Then the program will calculate the total
    price with the rate per person being $35. It will also determine
    if it will be a big party, which is a party with 50 or more people
    attending.

    Chris Harter
    11/9/2021
 */

public class CarlysEventPrice {

    //Global Variables
    static String oGuests, oCost, oRatePerPerson;
    static int RATE_PER_PERSON = 35;

    //Defines the object scanner for input
    static Scanner inputDevice;

    //Defines the objects for Decimal Format class
    static DecimalFormat dfInt3, dfDouble3V2, dfDouble5V2;

    public static void main(String[] args) {
        init();
        double iGuests = inputGuests();
        double cCost = calcs(iGuests);
        CarlysMotto2.output();
        output(iGuests, cCost);
    }

    private static void init() {
        inputDevice = new Scanner(System.in);

        dfInt3 = new DecimalFormat("##0");
        dfDouble5V2 = new DecimalFormat("$##,###.00");
        dfDouble3V2 = new DecimalFormat("$###.00");
    }

    private static double inputGuests() {
        System.out.println("Please enter the number of guests attending: ");
        String iData = inputDevice.nextLine();
        double iGuests = Double.parseDouble(iData);
        return iGuests;
    }

    private static double calcs(double iGuests) {
        double cCost = ((iGuests * RATE_PER_PERSON) * 100) / 100;
        return cCost;
    }

    private static void output(double iGuests, double cCost) {
        boolean oPartyClass = (iGuests >= 50);

        oGuests = dfInt3.format(iGuests);
        oCost = dfDouble5V2.format(cCost);
        oRatePerPerson = dfDouble3V2.format(RATE_PER_PERSON);

        System.out.printf("%-19s%5s%-12s%5s%-12s%5s%-25s\n",
                "Number of Guests", " ", "Price Per Guest", " ", "Total Price", " ", "Is it a big party");
        System.out.printf("%7s%-17s%5s%-11s%5s%-12s%11s%-5s\n",
                " ", oGuests, " ", oRatePerPerson, " ", oCost, " ", oPartyClass);
        //System.out.print("This " + cPartyClass + "a big party.");
    }
}
