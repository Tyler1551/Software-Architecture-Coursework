import java.sql.SQLException;
import java.time.LocalDateTime;

public interface AppLayerInterface {

    public Patient getPatient(String NHSNum) throws SQLException, ClassNotFoundException;

    public void insertPatient(String name, String NHSNum, String address, String medicalCondition) throws SQLException, ClassNotFoundException;

    public Patient getRecentPatient()throws SQLException, ClassNotFoundException;

    public void insertIncident(String incident, LocalDateTime date, String address, String actionTaken, String name, String NHSNum) throws SQLException, ClassNotFoundException;

    public Incident getIncident(String NHSNum) throws SQLException, ClassNotFoundException;
}
