public class Incident {
    String incident;
    String dateAdded;
    String address;
    String actionTaken;
    String name;
    String NHSNum;

    Incident(String incident, String dateAdded, String address, String actionTaken, String name, String NHSNum){

    }

    //    Getters for Incident


    public String getNHSNum() {
        return NHSNum;
    }

    public String getIncident() {
        return incident;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getActionTaken() {
        return actionTaken;
    }
    //  Setters for Incident


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public void setNHSNum(String NHSNum) {
        this.NHSNum = NHSNum;
    }
}
