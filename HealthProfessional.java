/* HealthProfessional.java*/
public class HealthProfessional {
    private int id;
    private String name;
    private String description; // A general description
    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "";
        this.description = "";
    }
    // Constructor with parameters
    public HealthProfessional(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    // Method to print health professional details
    public void printDetails() {
        System.out.println("Health Professional Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }
    // Getter and Setter methods
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
