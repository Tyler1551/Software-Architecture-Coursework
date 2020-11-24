import java.sql.*;
import java.time.*;
public class DataLayer implements DataLayerInterface {

    @Override
    public Patient insertPatient(String name, String NHSNum, String address, String medicalCondition) throws ClassNotFoundException, SQLException {
        LocalDateTime date = LocalDateTime.now();

        System.out.println(date);

//        To return to app layer once patient is created
        Patient patient = new Patient(name, NHSNum, address, medicalCondition);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "INSERT INTO patientrecord (Name, NHSNumber, Address, MedicalCondition, Date) " + "VALUES ('" + name + "', '" +NHSNum + "', '" + address + "', '" + medicalCondition + "', '" + date +"')";

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
    public Patient getMostRecentPatient() throws ClassNotFoundException, SQLException {
        //        To return to app layer once patient is created
        Patient patient = new Patient(null, null, null, null);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "SELECT * FROM patientrecord ORDER BY Date ASC";

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
    public void insertIncident(String incident, LocalDateTime date, String address, String actionTaken, String name, String NHSNum) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "INSERT into incidents (Incident, Date, Address, ActionTaken, Name, NHSID)" +
                " VALUES ('" + incident + "', '" + date + "', '" + address + "', '" + actionTaken + "', '" + name + "', '" + NHSNum + "')";

        statement.execute(stmt);
        statement.close();
        conn.close();
    }


    public Incident getIncident(String NHSNum) throws ClassNotFoundException, SQLException{
        Incident incident = new Incident(null, null, null, null, null, null);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "SELECT * FROM incidents WHERE NHSID = '" + NHSNum + "'";

        ResultSet results = statement.executeQuery(stmt);

        while(results.next()){
            incident.setIncident(results.getString("Incident"));
            incident.setDateAdded(results.getString("Date"));
            incident.setAddress(results.getString("Address"));
            incident.setActionTaken(results.getString("ActionTaken"));
            incident.setName(results.getString("Name"));
            incident.setNHSNum(results.getString("NHSID"));
        }

        statement.executeQuery(stmt);
        statement.close();
        conn.close();

        return incident;
    }

}
