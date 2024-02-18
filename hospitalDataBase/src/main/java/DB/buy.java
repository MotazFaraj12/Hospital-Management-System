package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class buy {
    private ArrayList<buy> data = new ArrayList<>();
    /***************************/
    private int Patient_id;
    private int Medicine_id;

    /***************************/
    public buy (int Patient_id, int Medicine_id) {
        this.Patient_id = Patient_id;
        this.Medicine_id = Medicine_id;
    }
    public int getPatient_id() {
        return Patient_id;
    }

    public int getMedicine_id() {
        return Medicine_id;
    }

    public void setPatient_id(int Patient_id) {
        this.Patient_id = Patient_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.Medicine_id = medicine_id;
    }

}
