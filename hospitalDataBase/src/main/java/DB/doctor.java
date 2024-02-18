package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class doctor {
    /***************************/
    private int Doctor_id;
    private String Address;
    private String Gender;
    private String Specialty;
    private String Doctor_name;
    private int PhoneNumber;
    private int Salary;
    /***************************/
    public doctor (int Doctor_id, String Doctor_name, String Address, String Gender, String specialty, int PhoneNumber, int Salary) {
        this.Doctor_id = Doctor_id;
        this.Doctor_name = Doctor_name;
        this.Address = Address;
        this.Specialty = specialty;
        this.Gender = Gender;
        this.Salary=Salary;
        this.PhoneNumber=PhoneNumber;
    }
    public int getDoctor_id() {
        return Doctor_id;
    }
    public String getDoctor_name() {
        return Doctor_name;
    }
    public String getAddress() {
        return Address;
    }
    public String getGender() {
        return Gender;
    }
    public String getSpecialty() {
        return Specialty;
    }
    public int getPhoneNumber() {
        return PhoneNumber;
    }
    public int getSalary() {
        return Salary;
    }

    public void setDoctor_id(int doctor_id) {
        this.Doctor_id = doctor_id;
    }
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    public void setDoctor_name(String doctor_name) {
        this.Doctor_name = doctor_name;
    }
    public void setAddress(String address) {
        this.Address = address;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }
    public void setSpecialty(String specialty) {
        this.Specialty = specialty;
    }

}
