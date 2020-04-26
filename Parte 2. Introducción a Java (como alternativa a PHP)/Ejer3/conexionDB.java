
import java.sql.*;
import java.util.ArrayList;

public class conexionDB {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection dbconn = DriverManager.getConnection("jdbc:mysql://192.168.20.15/java", "raulgp", "A123a.");

            Statement estatuto = dbconn.createStatement();

            ResultSet result = estatuto.executeQuery("select * from Persona");

            ArrayList<String> dbnombre = new ArrayList<String>();
            ArrayList<String> dbapellidos = new ArrayList<String>();
            ArrayList<String> dbdni = new ArrayList<String>();

            while (result.next()) {

                dbnombre.add(result.getString(1));
                dbapellidos.add(result.getString(2));
                dbdni.add(result.getString(3));
            }

            for (int i = 0; i < dbnombre.size(); i++) {
                System.out.println(dbnombre.get(i) + " " + dbapellidos.get(i) + " " + dbdni.get(i));
            }

            estatuto.close();
        }
        catch (Exception e) {
            System.err.println("La consulta no se ha realizado correctamente");
            System.err.println(e.getMessage());
        }
    }
}