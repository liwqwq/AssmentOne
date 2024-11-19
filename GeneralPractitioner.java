// GeneralPractitioner.java
public class GeneralPractitioner extends HealthProfessional {
    private String specialty;

    // Default constructor
    public GeneralPractitioner() {
        super();
        this.specialty = "General Practice";
    }

    // Constructor with parameters
    public GeneralPractitioner(int id, String name, String description, String specialty) {
        super(id, name, description);
        this.specialty = specialty;
    }

    // Override the printDetails method
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails();
        System.out.println("Specialty: " + specialty);
    }

    // Getter and Setter methods
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}

