import com.mysql.cj.result.SqlDateValueFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;

public interface DataLayerInterface {


    public Patient insertPatient(String name, String NHSNum, String address, String medicalCondition) throws ClassNotFoundException, SQLException;

    public Patient getPatient(String NHSNum) throws ClassNotFoundException, SQLException;

    public Patient getMostRecentPatient() throws ClassNotFoundException, SQLException;

    public void insertIncident(String incident, LocalDateTime date, String address, String actionTaken, String name, String NHSnum) throws ClassNotFoundException, SQLException;

    public Incident getIncident(String NHSNum) throws ClassNotFoundException, SQLException;

}
