import java.sql.*;
import java.util.ArrayList;

public class DataLayer implements DataLayerInterface {

    @Override
    public Patient insertPatient(String name, String NHSNum, String address, String medicalCondition) throws ClassNotFoundException, SQLException {

//        To return to app layer once patient is created
        Patient patient = new Patient(name, NHSNum, address, medicalCondition);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "INSERT INTO patientrecord (Name, NHSNumber, Address, MedicalCondition) " + "VALUES ('" + name + "', '" +NHSNum + "', '" + address + "', '" + medicalCondition + "')";

        statement.executeUpdate(stmt);
        statement.close();
        conn.close();

        System.out.println("Patient updated");



        return patient;
    }

    @Override
    public Patient getPatient(String NHSNum) throws ClassNotFoundException, SQLException {

        Patient patient = new Patient(null, null, null, null);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "SELECT * FROM patientrecord WHERE NHSNumber = '" + NHSNum + "'";

        ResultSet results = statement.executeQuery(stmt);

        while(results.next()){
            patient.setName(results.getString("Name"));
            patient.setNHSNum(results.getString("NHSNumber"));
            patient.setAddress(results.getString("Address"));
            patient.setMedicalCondition(results.getString("MedicalCondition"));
        }

        statement.close();
        conn.close();

        return patient;

    }

    @Override
    public void updatePatient(String NHSNum) throws ClassNotFoundException, SQLException {

    }

    @Override
    public void removePatient(String NHSNum) throws ClassNotFoundException, SQLException {

    }


}
