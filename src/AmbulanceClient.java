import java.io.*;
import java.net.Socket;

public class AmbulanceClient {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        System.out.print("Enter IP to connect to: ");
        String ip = input.readLine();

        System.out.print("Enter port number: ");
        String port = input.readLine();

        int port_num = Integer.parseInt(port);

        Socket socket = new Socket(ip, port_num);

        DataOutputStream net_out = new DataOutputStream(socket.getOutputStream());
        DataInputStream net_in = new DataInputStream(socket.getInputStream());

        



    }
}
