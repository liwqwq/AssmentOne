import java.util.ArrayList;

/* HealthProfessional*/
class HealthProfessional {
    private int id;
    private String name;
    private String description; 

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
    public void printHealthProfessionalDetails() {
        System.out.println("Information on Health Professionals:");
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

/* GeneralPractitioner*/
class GeneralPractitioner extends HealthProfessional {
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
    // PrintDetails method
    public void printGeneralPractitionerDetails() {
        System.out.println("The health professional details are:");
        super.printHealthProfessionalDetails();
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

/* Specialist*/
class Specialist extends HealthProfessional {
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
    // PrintDetails method
    public void printSpecialistDetails() {
        System.out.println("The detailed information of health professionals is as follows:");
        super.printHealthProfessionalDetails();
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

/* Appointment*/
class Appointment {
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional doctor;

    // Default constructor
    public Appointment() {
        this.patientName = "";
        this.patientMobile = "";
        this.timeSlot = "";
        this.doctor = null;
    }
    // Constructor with parameters
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }
    // Method to print appointment details
    public void printAppointmentDetails() {
        System.out.println("Appointment Information:");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Preferred Time Slot: " + timeSlot);
        doctor.printHealthProfessionalDetails();
    }
    // Getter and Setter methods
    public String getPatientMobile() {
        return patientMobile;
    }
    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }
}

/* Main Program – AssignmentOne*/
public class AssignmentOne {

    public static void main(String[] args) {
        // Part 3 – Using classes and objects

        // Create health professionals
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Lihong Xiao", "General Practitioner", "Director");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Haiou Lu", "General Practitioner", "Deputy director");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Qihua Li", "General Practitioner", "Deputy director");
        GeneralPractitioner gp4 = new GeneralPractitioner(4, "Dr. Meidan Nong", "General Practitioner", "Deputy director");

        Specialist spec1 = new Specialist(5, "Dr. Xiaojuan Peng", "Specialist in Endocrine", "Director");
        Specialist spec2 = new Specialist(6, "Dr. Jianfei Zhang", "Specialist in Acupuncture and moxibustion", "Deputy director");
        Specialist spec3 = new Specialist(7, "Dr. Da Zhu", "Specialist in neurosurgery", "Deputy director");

        // Print health professional details
        gp1.printGeneralPractitionerDetails();
        gp2.printGeneralPractitionerDetails();
        gp3.printGeneralPractitionerDetails();
        gp4.printGeneralPractitionerDetails();
        spec1.printSpecialistDetails();
        spec2.printSpecialistDetails();
        spec3.printSpecialistDetails();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        ArrayList<Appointment> appointments = new ArrayList<>();

        // Create appointments
        createAppointment(appointments, "Junhua Xin", "13722491423", "08:00", gp4);
        createAppointment(appointments, "Juncheng Lv", "11451423221", "10:00", spec1);
        createAppointment(appointments, "Nikola Kovac", "94451232416", "14:30", gp3);
        createAppointment(appointments, "Xiaowen Mai", "17633235559", "16:00", spec3);

        // Print existing appointments
        printExistingAppointments(appointments);

        System.out.println("------------------------------");

        // Cancel an appointment
        cancelBooking(appointments, "17633235559");

        // Print existing appointments after cancellation
        printExistingAppointments(appointments);
    }

    // Method to create a new appointment
    public static void createAppointment(ArrayList<Appointment> appointments, String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        Appointment appointment = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointments.add(appointment);
        System.out.println("Appointment created for: " + patientName);
    }

    // Method to print existing appointments
    public static void printExistingAppointments(ArrayList<Appointment> appointments) {
        if (appointments.isEmpty()) {
            System.out.println("There are no existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
                System.out.println("------------------------------");
            }
        }
    }

    /* Method to cancel an appointment using patient mobile*/
    public static void cancelBooking(ArrayList<Appointment> appointments, String patientMobile) {
        Appointment toRemove = null;
        for (Appointment appointment : appointments) {
            if (appointment.getPatientMobile().equals(patientMobile)) {
                toRemove = appointment;
                break;
            }
        }
        if (toRemove != null) {
            appointments.remove(toRemove);
            System.out.println("Appointment canceled for patient with mobile: " + patientMobile);
        } else {
            System.out.println("Appointment not found for patient with mobile: " + patientMobile);
        }
    }
}