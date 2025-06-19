# FitnessTracker_Streams

| Stream Feature             | Usage Example                  |
| -------------------------- | ------------------------------ |
| `filter()`                 | Logs by user ID or step range  |
| `map()` / `mapToInt()`     | Steps, calories mapping        |
| `groupingBy()`             | Group by activity or user      |
| `partitioningBy()`         | Active vs inactive day logs    |
| `averagingInt()`           | Average steps                  |
| `summingInt()`             | Total calories                 |
| `collect()`                | Collecting into maps and lists |
| `max()` with `Comparator`  | Top calorie burner             |
| `forEach()`                | Printing results               |
| `findFirst()` + `Optional` | Get user name safely           |
