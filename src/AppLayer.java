import java.sql.SQLException;

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
}
