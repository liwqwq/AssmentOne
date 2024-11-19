// Specialist.java
public class Specialist extends HealthProfessional {
    private String specializationArea;

    // Default constructor
    public Specialist() {
        super();
        this.specializationArea = "Unknown";
    }

    // Constructor with parameters
    public Specialist(int id, String name, String description, String specializationArea) {
        super(id, name, description);
        this.specializationArea = specializationArea;
    }

    // Override the printDetails method
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails();
        System.out.println("Specialization Area: " + specializationArea);
    }

    // Getter and Setter methods
    public String getSpecializationArea() {
        return specializationArea;
    }

    public void setSpecializationArea(String specializationArea) {
        this.specializationArea = specializationArea;
    }
}