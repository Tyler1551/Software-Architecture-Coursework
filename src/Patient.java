import java.time.LocalDateTime;

public class Patient {
    String name;
    String NHSNum;
    String address;
    String medicalCondition;

    Patient(String name, String NHSNum, String address, String medicalCondition){

    }

//    Getters for patient
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public String getNHSNum() {
        return NHSNum;
    }


//  Setters for patient

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNHSNum(String NHSNum) {
        this.NHSNum = NHSNum;
    }
}
