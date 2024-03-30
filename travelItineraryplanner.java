import java.util.*;

public class TravelItineraryPlanner {
    List<Destination> destinations;
    Preferences preferences;

    public TravelItineraryPlanner() {
        destinations = new ArrayList<>();
    }

    public void addDestination(String name, String dates) {
        destinations.add(new Destination(name, dates));
    }

    public void setPreferences(String transportation, String accommodation) {
        preferences = new Preferences(transportation, accommodation);
    }

    public Map<Destination, Map<String, String>> generateItinerary() {
        Map<Destination, Map<String, String>> itinerary = new LinkedHashMap<>();
        for (Destination destination : destinations) {
            Map<String, String> destinationDetails = new HashMap<>();
            destinationDetails.put("dates", destination.dates);
            destinationDetails.put("weather", getWeather(destination.name));
            destinationDetails.put("budget", calculateBudget(destination.name));
            // Add more details as needed
            itinerary.put(destination, destinationDetails);
        }
        return itinerary;
    }

    private String getWeather(String destination) {
        // Dummy weather data, replace with actual weather API integration
        return "Sunny";
    }

    private String calculateBudget(String destination) {
        // Dummy budget calculation, replace with actual budget calculation logic
        return "$1000";
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        Scanner scanner = new Scanner(System.in);

        // Taking user input for preferences
        System.out.println("Enter preferred transportation (e.g., Flight, Train):");
        String transportation = scanner.nextLine();
        System.out.println("Enter preferred accommodation (e.g., Hotel, Airbnb):");
        String accommodation = scanner.nextLine();
        planner.setPreferences(transportation, accommodation);

        // Taking user input for destinations and dates
        System.out.println("Enter number of destinations:");
        int numDestinations = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < numDestinations; i++) {
            System.out.println("Enter destination " + (i + 1) + " name:");
            String name = scanner.nextLine();
            System.out.println("Enter dates for destination " + (i + 1) + " (e.g., YYYY-MM-DD to YYYY-MM-DD):");
            String dates = scanner.nextLine();
            planner.addDestination(name, dates);
        }

        scanner.close(); // Close the scanner after use

        // Generate and display itinerary
        Map<Destination, Map<String, String>> itinerary = planner.generateItinerary();
        for (Map.Entry<Destination, Map<String, String>> entry : itinerary.entrySet()) {
            Destination destination = entry.getKey();
            Map<String, String> details = entry.getValue();
            System.out.println("Destination: " + destination.name);
            System.out.println("Dates: " + details.get("dates"));
            System.out.println("Weather: " + details.get("weather"));
            System.out.println("Budget: " + details.get("budget"));
            // Print other details
            System.out.println();
        }
    }
}