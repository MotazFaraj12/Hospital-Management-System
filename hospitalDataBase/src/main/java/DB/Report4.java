package DB;

public class Report4 {
    private int Patient_id;
    private String Patient_name;
    private int Bill_amount;

    public Report4(int patient_id, String patient_name, int bill_amount) {
        this.Patient_id = patient_id;
        this.Patient_name = patient_name;
        this.Bill_amount = bill_amount;
    }

    public int getPatient_id() {
        return Patient_id;
    }

    public void setPatient_id(int patient_id) {
        Patient_id = patient_id;
    }

    public String getPatient_name() {
        return Patient_name;
    }

    public void setPatient_name(String patient_name) {
        Patient_name = patient_name;
    }

    public int getBill_amount() {
        return Bill_amount;
    }

    public void setBill_amount(int bill_amount) {
        Bill_amount = bill_amount;
    }
}
