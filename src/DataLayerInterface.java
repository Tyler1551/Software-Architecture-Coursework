import java.sql.SQLException;

public interface DataLayerInterface {


    public Patient insertPatient(String name, String NHSNum, String address, String medicalCondition) throws ClassNotFoundException, SQLException;

    public Patient getPatient(String NHSNum) throws ClassNotFoundException, SQLException;

    public void updatePatient(String NHSNum) throws ClassNotFoundException, SQLException;

    public void removePatient(String NHSNum) throws ClassNotFoundException, SQLException;


}
