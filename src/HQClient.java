import java.io.*;
import java.net.Socket;

public class HQClient {

    public static void main(String[] args) throws IOException {

        BufferedReader input =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("KwikMedical Client");

        System.out.print("Enter IP address to connect to: ");
        String ip = input.readLine();
        System.out.print("Enter port number: ");
        String port_num = input.readLine();

        int port = Integer.parseInt(port_num);

        Socket socket = new Socket(ip, port);

        DataOutputStream network = new DataOutputStream(socket.getOutputStream());

        while(true){

            System.out.print("\n\nEnter New Patient Details\n\n");

            System.out.print("Enter Patient Name: ");
            String name = input.readLine();
            network.writeUTF(name);

            System.out.print("Enter Patients NHS Registration Number: ");
            String NHSNum = input.readLine();
            network.writeUTF(NHSNum);

            System.out.print("Enter Patients address: ");
            String address = input.readLine();
            network.writeUTF(address);

            System.out.print("Enter medical condition: ");
            String medicalCondition = input.readLine();
            network.writeUTF(medicalCondition);

        }
    }
}
