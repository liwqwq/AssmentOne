// AssignmentOne.java
import java.util.ArrayList;

public class AssignmentOne {

    public static void main(String[] args) {
        // Part 3 – Using classes and objects

        // Create health professionals
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. John Smith", "General Practitioner", "Family Medicine");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Jane Doe", "General Practitioner", "General Medicine");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Sam Green", "General Practitioner", "Family Medicine");

        Specialist spec1 = new Specialist(4, "Dr. Mike Brown", "Specialist in Cardiology", "Cardiology");
        Specialist spec2 = new Specialist(5, "Dr. Susan White", "Specialist in Orthopedics", "Orthopedics");

        // Print health professional details
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        spec1.printDetails();
        spec2.printDetails();
        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        ArrayList<Appointment> appointments = new ArrayList<>();

        // Create appointments
        createAppointment(appointments, "Alice Brown", "1234567890", "08:00", gp1);
        createAppointment(appointments, "Bob Black", "0987654321", "10:00", spec1);
        createAppointment(appointments, "Charlie Clark", "1122334455", "14:30", gp2);
        createAppointment(appointments, "David Drake", "5566778899", "16:00", spec2);

        // Print existing appointments
        printExistingAppointments(appointments);

        System.out.println("------------------------------");

        // Cancel an appointment
        cancelBooking(appointments, "1122334455");

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
            System.out.println("No existing appointments.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.printAppointmentDetails();
                System.out.println("------------------------------");
            }
        }
    }

    // Method to cancel an appointment using patient mobile
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