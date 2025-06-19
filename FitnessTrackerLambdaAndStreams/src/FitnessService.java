import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FitnessService {
    private List<User> users;
    private List<ActivityLog> logs;

    public FitnessService(List<User> users, List<ActivityLog> logs) {
        this.users = users;
        this.logs = logs;
    }

    public void showAllLogs() {
        logs.forEach(System.out::println);
    }

    public void showLogsByUser(int userId) {
        logs.stream()
            .filter(log -> log.getUserId() == userId)
            .forEach(System.out::println);
    }

    public void groupByActivityType() {
        logs.stream()
            .collect(Collectors.groupingBy(ActivityLog::getActivityType))
            .forEach((activity, list) -> {
                System.out.println("Activity: " + activity);
                list.forEach(System.out::println);
            });
    }

    public void averageStepsPerUser() {
        logs.stream()
            .collect(Collectors.groupingBy(
                ActivityLog::getUserId,
                Collectors.averagingInt(ActivityLog::getSteps)))
            .forEach((id, avg) -> {
                String name = users.stream().filter(u -> u.getId() == id).findFirst().map(User::getName).orElse("Unknown");
                System.out.println(name + " - Avg Steps: " + avg);
            });
    }

    public void activeVsInactive() {
        logs.stream()
            .collect(Collectors.partitioningBy(log -> log.getSteps() >= 10000))
            .forEach((isActive, list) -> {
                System.out.println(isActive ? "Active Days (10k+ steps)" : "Inactive Days (<10k steps)");
                list.forEach(System.out::println);
            });
    }

    public void topBurnerByCalories() {
        logs.stream()
            .collect(Collectors.groupingBy(ActivityLog::getUserId, Collectors.summingInt(ActivityLog::getCalories)))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .ifPresent(entry -> {
                String name = users.stream().filter(u -> u.getId() == entry.getKey()).findFirst().map(User::getName).orElse("Unknown");
                System.out.println("🔥 Top Calorie Burner: " + name + " with " + entry.getValue() + " calories burned.");
            });
    }
}
