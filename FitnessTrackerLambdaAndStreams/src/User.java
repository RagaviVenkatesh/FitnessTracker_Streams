
public class User {
    private int id;
    private String name;
    private int age;
    private String gender;

    public User(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return id + ": " + name + " (" + age + ", " + gender + ")";
    }
}
