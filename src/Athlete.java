public class Athlete extends Person{
    // Instance variables
    private String sport;
    // Constructor
    public Athlete(String firstName, String lastName, String phoneNumber, String sport){
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }
    // Getter and setter methods
    public String getSport(){
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
    // To string method
    public String toString(){
        return super.toString() + " Sport: " + sport;
    }
}
