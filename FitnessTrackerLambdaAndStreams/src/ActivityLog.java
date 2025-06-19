import java.time.LocalDate;

public class ActivityLog {
    private int userId;
    private LocalDate date;
    private String activityType; // Walk, Run, Cycle
    private int steps;
    private double distance; // in km
    private int calories;

    public ActivityLog(int userId, LocalDate date, String activityType, int steps, double distance, int calories) {
        this.userId = userId;
        this.date = date;
        this.activityType = activityType;
        this.steps = steps;
        this.distance = distance;
        this.calories = calories;
    }

    public int getUserId() { return userId; }
    public LocalDate getDate() { return date; }
    public String getActivityType() { return activityType; }
    public int getSteps() { return steps; }
    public double getDistance() { return distance; }
    public int getCalories() { return calories; }

    @Override
    public String toString() {
        return date + " | " + activityType + " | Steps: " + steps + " | Distance: " + distance + " km | Calories: " + calories;
    }
}
