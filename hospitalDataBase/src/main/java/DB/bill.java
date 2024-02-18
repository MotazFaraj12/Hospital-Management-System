
package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
public class bill {
    /***************************/
    private int Bill_no;
    private int Patient_id;
    private int Bill_amount;
    /***************************/
    public bill (int Bill_no, int Patient_id, int Bill_amount) {
        this.Bill_no = Bill_no;
        this.Patient_id = Patient_id;
        this.Bill_amount = Bill_amount;
    }
    public int getBill_no() {
        return Bill_no;
    }
    public int getPatient_id() {
        return Patient_id;
    }
    public int getBill_amount() {
        return Bill_amount;
    }

    public void setBill_no(int bill_no) {
        this.Bill_no = bill_no;
    }

    public void setPatient_id(int patient_id) {
        this.Patient_id = patient_id;
    }
    public void setBill_amount(int bill_amount) {
        this.Bill_amount = bill_amount;
    }
}
