import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class Server{

    public static void insertPatient(String name, String NHSNum, String address, String medicalCondition) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/patients?user=user&password=user");

        Statement statement = conn.createStatement();

        String stmt = "INSERT INTO patientrecord (Name, NHSNumber, Address, MedicalCondition) " + "VALUES ('" + name + "', '" +NHSNum + "', '" + address + "', '" + medicalCondition + "')";

        statement.executeUpdate(stmt);
        statement.close();
        conn.close();

        System.out.println("Patient updated");

    }



    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("KwikMedical System");
        System.out.print("Enter port to run on: ");

        String port = input.readLine();
        int port_num = Integer.parseInt(port);

        ServerSocket serv = new ServerSocket(port_num);
        Socket socket = serv.accept();

        DataInputStream net_in = new DataInputStream(socket.getInputStream());
        DataOutputStream  net_out = new DataOutputStream(socket.getOutputStream());

        String name = net_in.readUTF();
        String NHSNum = net_in.readUTF();
        String address = net_in.readUTF();
        String medicalCondition = net_in.readUTF();

        insertPatient(name, NHSNum, address, medicalCondition);

        socket.close();
        serv.close();

    }

}
