import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
            new User(1, "Alice", 28, "Female"),
            new User(2, "Bob", 32, "Male"),
            new User(3, "Charlie", 25, "Male")
        );

        List<ActivityLog> logs = List.of(
            new ActivityLog(1, LocalDate.now().minusDays(1), "Run", 12000, 5.0, 350),
            new ActivityLog(1, LocalDate.now(), "Walk", 8000, 3.5, 200),
            new ActivityLog(2, LocalDate.now(), "Cycle", 3000, 7.0, 300),
            new ActivityLog(2, LocalDate.now().minusDays(2), "Walk", 15000, 6.0, 400),
            new ActivityLog(3, LocalDate.now().minusDays(1), "Run", 11000, 4.5, 280)
        );

        FitnessService service = new FitnessService(users, logs);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Fitness Tracker Menu ---");
            System.out.println("1. Show All Logs");
            System.out.println("2. Show Logs by User ID");
            System.out.println("3. Group Logs by Activity Type");
            System.out.println("4. Average Steps Per User");
            System.out.println("5. Active vs Inactive Days");
            System.out.println("6. Top Calorie Burner");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.showAllLogs();
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    service.showLogsByUser(sc.nextInt());
                }
                case 3 -> service.groupByActivityType();
                case 4 -> service.averageStepsPerUser();
                case 5 -> service.activeVsInactive();
                case 6 -> service.topBurnerByCalories();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
