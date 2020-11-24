import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class AmbulanceUILayer {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static AppLayer appLayer;

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        DataLayer dataLayer = new DataLayer();
        appLayer = new AppLayer(dataLayer);


        while(true){
            display_menu();
        }




    }

    public static void display_menu() throws SQLException, ClassNotFoundException, IOException {


        System.out.println("KwikMedical Ambulance System");
        System.out.println("1) Refresh system");
        System.out.print("Enter: ");


        String str_choice = input.readLine();
        int choice = Integer.parseInt(str_choice);


        switch(choice){
            case 1 -> {
                Patient patient = appLayer.getRecentPatient();
                Incident incident = appLayer.getIncident(patient.NHSNum);

                System.out.println("\n");
                System.out.println("Patient Details");
                System.out.println("\n");
                System.out.println("Patient name: " + patient.name);
                System.out.println("Patient NHS Number: " + patient.NHSNum);
                System.out.println("Patient Address: " + patient.address);
                System.out.println("Patient Medical Condition: " + patient.medicalCondition);
                System.out.println("\n");

                System.out.println("Incident Details");
                System.out.println("\n");
                System.out.println("Incident: " + incident.incident);
                System.out.println("Address of Incident: " + incident.address);
                System.out.println("Action Taken: " + incident.actionTaken);
            }
        }


    }
}
