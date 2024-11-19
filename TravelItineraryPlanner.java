import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Destination {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String transportation;
    private String accommodation;
    private double estimatedCost;

    // Constructor
    public Destination(String name, LocalDate startDate, LocalDate endDate, String transportation, String accommodation, double estimatedCost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.transportation = transportation;
        this.accommodation = accommodation;
        this.estimatedCost = estimatedCost;
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTransportation() {
        return transportation;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    // Method to display the itinerary for the destination
    public void displayItinerary() {
        System.out.println("Destination: " + name);
        System.out.println("Travel Dates: " + startDate + " to " + endDate);
        System.out.println("Transportation: " + transportation);
        System.out.println("Accommodation: " + accommodation);
        System.out.println("Estimated Cost: $" + estimatedCost);
    }
}

public class TravelItineraryPlanner {

    private ArrayList<Destination> destinations;
    private double totalBudget;

    // Constructor
    public TravelItineraryPlanner() {
        destinations = new ArrayList<>();
        totalBudget = 0.0;
    }

    // Method to add a destination to the itinerary
    public void addDestination(Scanner scanner) {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter travel start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Enter travel end date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateStr, DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Enter preferred transportation (e.g., Plane, Train, Car): ");
        String transportation = scanner.nextLine();

        System.out.print("Enter accommodation type (e.g., Hotel, Hostel, Airbnb): ");
        String accommodation = scanner.nextLine();

        System.out.print("Enter estimated cost for this destination: $");
        double estimatedCost = scanner.nextDouble();

        // Create a new destination object and add it to the itinerary
        Destination destination = new Destination(name, startDate, endDate, transportation, accommodation, estimatedCost);
        destinations.add(destination);

        // Update the total budget
        totalBudget += estimatedCost;
    }

    // Method to display the entire itinerary
    public void displayItinerary() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations added to your itinerary.");
        } else {
            System.out.println("\n----- Your Travel Itinerary -----");
            for (Destination destination : destinations) {
                destination.displayItinerary();
                System.out.println("--------------------------------");
            }
            System.out.println("Total estimated budget: $" + totalBudget);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();

        int choice;

        do {
            System.out.println("\n----- Travel Itinerary Planner -----");
            System.out.println("1. Add a destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    planner.addDestination(scanner);
                    break;
                case 2:
                    planner.displayItinerary();
                    break;
                case 3:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
