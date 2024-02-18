package DB;

public class Report2 {
    private int Patient_id2;
    private String Patient_name2;
    private String Doctor_name2;
    private int Doctor_id2;

    public Report2(int Patient_id2,String Patient_name2,String Doctor_name2,int Doctor_id2) {
        this.Patient_id2=Patient_id2;
        this.Patient_name2=Patient_name2;
        this.Doctor_name2=Doctor_name2;
        this.Doctor_id2=Doctor_id2;
    }

    public int getPatient_id2() {
        return Patient_id2;
    }

    public String getPatient_name2() {
        return Patient_name2;
    }

    public String getDoctor_name2() {
        return Doctor_name2;
    }

    public int getDoctor_id2() {
        return Doctor_id2;
    }

    public void setPatient_id2(int patient_id2) {
        this.Patient_id2 = patient_id2;
    }

    public void setPatient_name2(String patient_name2) {
        this.Patient_name2 = patient_name2;
    }

    public void setDoctor_name2(String doctor_name2) {
        this.Doctor_name2 = doctor_name2;
    }

    public void setDoctor_id2(int doctor_id2) {
        this.Doctor_id2 = doctor_id2;
    }
}
