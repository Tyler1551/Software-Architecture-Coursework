import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RegionalHospital {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static AppLayer appLayer;

    public static void main(String[] args) {

        DataLayer dataLayer = new DataLayer();
        appLayer = new AppLayer(dataLayer);






    }
}
