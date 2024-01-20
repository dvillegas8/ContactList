public class Student extends Person{
    // Instance Variables
    private int grade;
    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade){
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }
    // Getter and setter methods
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    // To string method
    public String toString(){
        return super.toString() + " Grade: " + grade;
    }
}
