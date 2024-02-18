package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class nurse {
    /***************************/
    private int Nurse_id;
    private int Salary;
    private String Gender;
    private int PhoneNumber;
    private String Address;
    private String Nurse_name;
    private String Shift;
    /***************************/
    public nurse (int Nurse_id, String Nurse_name, String shift, int Salary,String Address,int PhoneNumber,String Gender) {
        this.Nurse_id = Nurse_id;
        this.Nurse_name = Nurse_name;
        this.Shift = shift;
        this.Salary = Salary;
        this.Address=Address;
        this.PhoneNumber=PhoneNumber;
        this.Gender=Gender;
    }
    public int getNurse_id() {
        return Nurse_id;
    }
    public String getNurse_name() {
        return Nurse_name;
    }
    public int getSalary() {
        return Salary;
    }
    public String getShift() {
        return Shift;
    }

    public String getAddress() {
        return Address;
    }
    public int getPhoneNumber() {
        return PhoneNumber;
    }
    public String getGender() {
        return Gender;
    }

    public void setNurse_id(int nurse_id) {
        this.Nurse_id = nurse_id;
    }
    public void setNurse_name(String nurse_name) {
        this.Nurse_name = nurse_name;
    }
    public void setSalary(int salary) {
        this.Salary = salary;
    }
    public void setShift(String shift) {
        this.Shift = shift;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

}
