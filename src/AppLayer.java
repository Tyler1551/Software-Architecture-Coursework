import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppLayer implements AppLayerInterface {

    private DataLayerInterface dataLayer;

    public AppLayer(DataLayerInterface dataLayer){
        this.dataLayer = dataLayer;
    }

    @Override
    public Patient getPatient(String NHSNum) throws SQLException, ClassNotFoundException {
        Patient patient = dataLayer.getPatient(NHSNum);

        System.out.println("Patient Name: " + patient.name + "\n" + "Patient NHS Number: " + patient.NHSNum + "\n" + "Patient Address: " + patient.address +
                "\n" + "Patient's Medical Condition: " + patient.medicalCondition);

        return patient;

    }

    @Override
    public void insertPatient(String name, String NHSNum, String address, String medicalCondition) throws SQLException, ClassNotFoundException {
        dataLayer.insertPatient(name, NHSNum, address, medicalCondition);
    }

    @Override
    public Patient getRecentPatient() throws SQLException, ClassNotFoundException {
        return dataLayer.getMostRecentPatient();
    }


    @Override
    public void insertIncident(String incident, LocalDateTime date, String address, String actionTaken, String name, String NHSNum) throws SQLException, ClassNotFoundException {
        dataLayer.insertIncident(incident, date, address, actionTaken, name, NHSNum);
    }

    @Override
    public Incident getIncident(String NHSNum) throws SQLException, ClassNotFoundException {
        return dataLayer.getIncident(NHSNum);
    }


}
