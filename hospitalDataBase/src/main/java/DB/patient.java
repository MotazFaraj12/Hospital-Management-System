package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class patient {
    /***************************/
    private int Patient_id;
    private int Nurse_id;
    private int Phone_number;
    private String Patient_name;
    private int Room_no;
    private String address;
    /***************************/
    public patient (int Patient_id, String Patient_name, String address, int Phone_number, int Nurse_id, int Room_no) {
        this.Patient_id = Patient_id;
        this.Patient_name = Patient_name;
        this.address = address;
        this.Phone_number = Phone_number;
        this.Nurse_id = Nurse_id;
        this.Room_no = Room_no;
    }
    public int getPatient_id() {
        return Patient_id;
    }
    public String getPatient_name() {
        return Patient_name;
    }
    public int getNurse_id() {
        return Nurse_id;
    }
    public int getPhone_number() {
        return Phone_number;
    }
    public String getAddress() {
        return address;
    }
    public int getRoom_no() {
        return Room_no;
    }

    public void setPatient_id(int patient_id) {
        this.Patient_id = patient_id;
    }
    public void setPatient_name(String patient_name) {
        this.Patient_name = patient_name;
    }

    public void setNurse_id(int nurse_id) {
        this.Nurse_id = nurse_id;
    }
    public void setPhone_number(int phone_number) {
        this.Phone_number = phone_number;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setRoom_no(int room_no) {
        this.Room_no = room_no;
    }

}
