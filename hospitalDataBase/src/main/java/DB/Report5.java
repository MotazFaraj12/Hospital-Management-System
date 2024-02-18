package DB;

public class Report5 {
    private int Diagnosis_no;
    private String Details;
    private String Severity;

    public Report5(int diagnosis_no, String details, String severity) {
        this.Diagnosis_no = diagnosis_no;
        this.Details = details;
        this.Severity = severity;
    }
    public int getDiagnosis_no() {
        return Diagnosis_no;
    }

    public void setDiagnosis_no(int diagnosis_no) {
        this.Diagnosis_no = diagnosis_no;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        this.Severity = severity;
    }
}
