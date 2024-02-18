package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ArrayList;

public class diagnosis {
    private ArrayList<diagnosis> data = new ArrayList<>();
    /***************************/
    private int Diagnosis_no;
    private String Diagnosis_Date;
    private String Details;
    private String Severity;
    private int Doctor_id;
    /***************************/
    public diagnosis (int Diagnosis_no, String Diagnosis_Date, String details, String severity,int Doctor_id) {
        this.Diagnosis_no = Diagnosis_no;
        this.Diagnosis_Date = Diagnosis_Date;
        this.Details = details;
        this.Severity = severity;
        this.Doctor_id= Doctor_id;
    }
    public int getDiagnosis_no() {
        return Diagnosis_no;
    }
    public String getDetails() {
        return Details;
    }
    public String getDiagnosis_Date() {
        return Diagnosis_Date;
    }
    public String getSeverity() {
        return Severity;
    }
    public int getDoctor_id() {
        return Doctor_id;
    }

    public void setDiagnosis_no(int diagnosis_no) {
        this.Diagnosis_no = diagnosis_no;
    }
    public void setDetails(String details) {
        this.Details = details;
    }

    public void setDiagnosis_Date(String Diagnosis_Date) {
        this.Diagnosis_Date = Diagnosis_Date;
    }
    public void setSeverity(String severity) {
        this.Severity = severity;
    }

    public void setDoctor_id(int Doctor_id) {
        this.Doctor_id = Doctor_id;
    }

}
