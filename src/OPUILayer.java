import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class OPUILayer {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static AppLayer appLayer;


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        DataLayer dataLayer = new DataLayer();

        appLayer = new AppLayer(dataLayer);

        display_menu();
        int int_choice;
        String str_choice = input.readLine();
        int choice = Integer.parseInt(str_choice);


        switch (choice) {
            case 1 -> {
                System.out.print("Enter Patient name: ");
                String name = input.readLine();
                System.out.print("Enter Patient NHS Registration Number: ");
                String NHSNum = input.readLine();
                System.out.print("Enter Patient's Address: ");
                String address = input.readLine();
                System.out.print("Enter Patients Medical Condition: ");
                String medicalCondition = input.readLine();
                appLayer.insertPatient(name, NHSNum, address, medicalCondition);
            }
            case 2 -> {
                System.out.print("Enter Patients NHS Registration Number: ");
                String num = input.readLine();
                appLayer.getPatient(num);
            }
        }
    }


    public static void display_menu(){
        System.out.println("KwikMedical System");
        System.out.println("1) Insert Patient");
        System.out.println("1) Get Patient Details");
    }
}
