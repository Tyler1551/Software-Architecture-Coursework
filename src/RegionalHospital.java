import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegionalHospital {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static AppLayer appLayer;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        DataLayer dataLayer = new DataLayer();
        appLayer = new AppLayer(dataLayer);

        while(true){
            display_menu();
        }




    }

    public static void display_menu() throws SQLException, ClassNotFoundException, IOException {

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String formatted_date = date.format(format);

//        Display patient details in hospital
        Patient patient = appLayer.getRecentPatient();
        System.out.println("\nPatient Name: " + patient.name);
        System.out.println("Patient NHS Number: " + patient.NHSNum);
        System.out.println("Patient Address: " + patient.address);
        System.out.println("Patient Medical Condition: " + patient.medicalCondition);

        System.out.println("\nKwikMedical System");
        System.out.println("1) Report incident");
        System.out.println("2) Refresh list");

        System.out.print("Enter choice: ");
        String str_choice = input.readLine();
        int choice = Integer.parseInt(str_choice);

        switch(choice){
            case 1:
                System.out.print("Enter incident: ");
                String incident = input.readLine();
                System.out.println("Date of incident: " + formatted_date);
                System.out.println("Address of patient: " + patient.address);
                System.out.print("Enter Action Taken: ");
                String action = input.readLine();
                System.out.println("Name of patient: " + patient.name);

                appLayer.insertIncident(incident, date, patient.address, action, patient.name, patient.NHSNum);
                System.out.println("Incident updated");
            case 2:
                appLayer.getRecentPatient();
        }

    }
}
