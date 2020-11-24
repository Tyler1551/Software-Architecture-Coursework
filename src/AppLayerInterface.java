import java.sql.SQLException;

public interface AppLayerInterface {

    public Patient getPatient(String NHSNum) throws SQLException, ClassNotFoundException;

    public void insertPatient(String name, String NHSNum, String address, String medicalCondition) throws SQLException, ClassNotFoundException;



}
