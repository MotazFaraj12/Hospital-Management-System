package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class treat {
    private ArrayList<treat> data = new ArrayList<>();
    /***************************/
    private int Patient_id;
    private int Doctor_id;
    /***************************/
    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "0000";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "FinalDB";
    private Connection con;
    /***************************/


    public treat (int Patient_id, int Doctor_id) {
        this.Patient_id = Patient_id;
        this.Doctor_id = Doctor_id;
    }

    public int getPatinet_ID() {
        return Patient_id;
    }

    public int getDoctor_Id() {
        return Patient_id;
    }

    public void setPatinet_ID(int Patient_id) {
        this.Patient_id = Patient_id;
    }

    public void setDoctor_Id(int Doctor_id) {
        this.Doctor_id = Doctor_id;
    }

    private void connectDB() throws ClassNotFoundException, SQLException {

        dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
        Properties p = new Properties();
        p.setProperty("user", dbUsername);
        p.setProperty("password", dbPassword);
        p.setProperty("useSSL", "false");
        p.setProperty("autoReconnect", "true");
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection (dbURL, p);
    }

    public void ExecuteStatement(String SQL) throws SQLException {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(SQL);
            stmt.close();


        }
        catch(SQLException s) {
            s.printStackTrace();
            System.out.println("SQL statement is not executed!");

        }


    }

    private void getData() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub

        String SQL;

        connectDB();
        System.out.println("Connection established");

        SQL = "select * from treat order by patinetPatinetID";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            data.add(new treat(
                    Integer.parseInt(rs.getString(1)),
                    Integer.parseInt(rs.getString(2))
            ));

        rs.close();
        stmt.close();

        con.close();
        System.out.println("Connection closed" + data.size());
    }

    private void insertData(treat rc) {

        try {
            System.out.println("Insert into treat (Patient_id, Doctor_id) values("+
                     rc.getPatinet_ID() +","
                    + rc.getDoctor_Id() +")"
            );

            connectDB();
            ExecuteStatement("Insert into treat (Patient_id, Doctor_id) values("+
                    rc.getPatinet_ID() +","
                    + rc.getDoctor_Id() +")"
            );

            con.close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
