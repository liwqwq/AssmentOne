import java.util.ArrayList;

// Part 1 – Base Class
class HealthProfessional {
    // Instance variables
    private int id;
    private String name;
    private String specialty; // A common attribute describing the health professional (e.g., type of work)

    // Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.specialty = "General";
    }

    // Constructor to initialize all instance variables
    public HealthProfessional(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Method to print details of the health professional
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
    }
}

// Part 2 – Child Class: GeneralPractitioner
class GeneralPractitioner extends HealthProfessional {
    // Additional attribute for GeneralPractitioner
    private String clinicHours;

    // Default constructor
    public GeneralPractitioner() {
        super(); // Call the base class constructor
        this.clinicHours = "9 AM - 5 PM";
    }

    // Constructor to initialize all variables
    public GeneralPractitioner(int id, String name, String specialty, String clinicHours) {
        super(id, name, specialty); // Initialize base class variables
        this.clinicHours = clinicHours;
    }

    // Method to print details, including health professional type
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails(); // Print base class details
        System.out.println("Type: General Practitioner");
        System.out.println("Clinic Hours: " + clinicHours);
    }
}

// Part 2 – Child Class: Dietitian
class Dietitian extends HealthProfessional {
    // Additional attribute for Dietitian
    private String certification;

    // Default constructor
    public Dietitian() {
        super(); // Call the base class constructor
        this.certification = "Certified Nutritionist";
    }

    // Constructor to initialize all variables
    public Dietitian(int id, String name, String specialty, String certification) {
        super(id, name, specialty); // Initialize base class variables
        this.certification = certification;
    }

    // Method to print details, including health professional type
    @Override
    public void printDetails() {
        System.out.println("The health professional details are:");
        super.printDetails(); // Print base class details
        System.out.println("Type: Dietitian");
        System.out.println("Certification: " + certification);
    }
}

// Part 4 – Appointment Class
class Appointment {
    private String patientName;
    private String patientPhone;
    private String timeSlot;
    private HealthProfessional healthProfessional;

    // Default constructor
    public Appointment() {
        this.patientName = "Unknown";
        this.patientPhone = "Unknown";
        this.timeSlot = "Unknown";
        this.healthProfessional = null;
    }

    // Constructor to initialize all variables
    public Appointment(String patientName, String patientPhone, String timeSlot, HealthProfessional healthProfessional) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.timeSlot = timeSlot;
        this.healthProfessional = healthProfessional;
    }

    // Method to print appointment details
    public void printAppointmentDetails() {
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Phone: " + patientPhone);
        System.out.println("Appointment Time: " + timeSlot);
        System.out.print("Health Professional: ");
        healthProfessional.printDetails(); // Print health professional details
    }

    // Getter for patientPhone (for cancelAppointment method)
    public String getPatientPhone() {
        return patientPhone;
    }
}

// Part 5 – Collection of Appointments
class AppointmentManager {
    private ArrayList<Appointment> appointments;

    // Constructor to initialize the appointments list
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    // Method to create an appointment and add it to the list
    public void createAppointment(String patientName, String patientPhone, String timeSlot, HealthProfessional healthProfessional) {
        if (patientName != null && !patientName.isEmpty() && patientPhone != null && !patientPhone.isEmpty()) {
            Appointment appointment = new Appointment(patientName, patientPhone, timeSlot, healthProfessional);
            appointments.add(appointment);
            System.out.println("Appointment created successfully.");
        } else {
            System.out.println("Invalid patient details, cannot create appointment.");
        }
    }

    // Method to print all existing appointments
    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
                System.out.println("------------------------------");
            }
        }
    }

    // Method to cancel an appointment by patient phone number
    public void cancelAppointment(String patientPhone) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getPatientPhone().equals(patientPhone)) {
                appointments.remove(i);
                System.out.println("Appointment cancelled.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Appointment not found for the provided phone number.");
        }
    }
}

// Main class to run the program
public class HealthSystem {
    public static void main(String[] args) {
        // Create instances of GeneralPractitioner and Dietitian
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. John Smith", "General Medicine", "9 AM - 5 PM");
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Emma Lee", "General Medicine", "8 AM - 4 PM");
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Robert Brown", "General Medicine", "10 AM - 6 PM");

        Dietitian dietitian1 = new Dietitian(201, "Sarah Green", "Nutrition", "Certified Nutritionist");
        Dietitian dietitian2 = new Dietitian(202, "Tom White", "Nutrition", "Registered Dietitian");

        // Print details of all health professionals
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        dietitian1.printDetails();
        dietitian2.printDetails();

        System.out.println("------------------------------");

        // Create an AppointmentManager and make appointments
        AppointmentManager appointmentManager = new AppointmentManager();

        // Create appointments
        appointmentManager.createAppointment("Alice Johnson", "123-456-7890", "9:00 AM", gp1);
        appointmentManager.createAppointment("Bob Martin", "987-654-3210", "10:00 AM", dietitian1);

        // Print all appointments
        appointmentManager.printExistingAppointments();

        // Cancel an appointment
        appointmentManager.cancelAppointment("123-456-7890");

        // Print all appointments after cancellation
        appointmentManager.printExistingAppointments();
    }
}
