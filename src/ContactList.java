import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {
    // Instance Variables
    private ArrayList<Person> contacts;
    // Constructor
    public ContactList(){
        contacts = new ArrayList<Person>();
    }
    // Get method
    public ArrayList<Person> getContacts(){
        return contacts;
    }
    // Add contact method
    public void addContact(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student");
        System.out.println("2. Athlete");
        String choice = scan.nextLine();
        // Error message

        while(!choice.equals("1") && !choice.equals("2")){
            System.out.println("Error: Incorrect input please try again");
            choice = scan.nextLine();
        }
        System.out.println("Please fill in the following information");
        System.out.println("First Name:");
        String firstName = scan.nextLine();
        System.out.println("Last Name:");
        String lastName = scan.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scan.nextLine();
        // Information for Student object
        if(choice.equals("1")){
            System.out.println("Grade:");
            int grade = scan.nextInt();
            // Remove buffer?
            scan.nextLine();
            Student student = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(student);
        }
        // Information for Athlete object
        else if(choice.equals("2")){
            System.out.println("Sport: ");
            String sport = scan.nextLine();
            Athlete athlete = new Athlete(firstName, lastName, phoneNumber, sport);
            contacts.add(athlete);
        }
    }
    // Print all contacts method
    public void printContacts(){
        for(Person person : contacts){
            System.out.println(person);
        }
    }
    // Sort method
    public void sort(int sortBy){
        for(int i = 1; i < contacts.size(); i++){
            for(int j = 0; j < contacts.size() - i; j++){
                // Sort by first name
                if(sortBy == 0){
                    if(contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0){
                        contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                    }
                }
                // Sort by last name
                else if(sortBy == 1){
                    if(contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0){
                        contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                    }
                }
                // Sort by phone number
                else if(sortBy == 2){
                    if(contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0){
                        contacts.set(j + 1, contacts.set(j, contacts.get(j + 1)));
                    }
                }
            }
        }
    }
    // Search people in contacts by first name method
    public Person searchByFirstName(String firstName){
        for(Person person : contacts){
            if(person.getFirstName().equals(firstName)){
                return person;
            }
        }
        return null;
    }
    // Search people in contacts by last name method
    public Person searchByLastName(String lastName){
        for(Person person : contacts){
            if(person.getLastName().equals(lastName)){
                return person;
            }
        }
        return null;
    }
    // Search people in contacts by phone number
    public Person searchByPhoneNumber(String phoneNumber){
        for(Person person : contacts){
            if(person.getPhoneNumber().equals(phoneNumber)){
                return person;
            }
        }
        return null;
    }
    // Method that prints all the students in the contacts
    public void listStudents(){
        for(Person person : contacts){
            if(person instanceof Student){
                System.out.println(person);
            }
        }
    }
    // Main Method
    public void run(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        String choice = scanner.nextLine();
        while(!choice.equals("0")){
            if(choice.equals("1")){
                addContact();
            }
            else if(choice.equals("2")){
                sort(0);
                printContacts();
            }
            else if(choice.equals("3")){
                sort(1);
                printContacts();
            }
            else if(choice.equals("4")){
                sort(2);
                printContacts();
            }
            else if(choice.equals("5")){
                listStudents();
            }
            else if(choice.equals("6")){
                System.out.println("Enter a First Name: ");
                String firstName = scanner.nextLine();
                if(searchByFirstName(firstName) == null){
                    System.out.println(firstName + " is not in the list.");
                }
                else{
                    System.out.println(searchByFirstName(firstName));
                }
            }
            else if(choice.equals("7")){
                System.out.println("Enter a Last Name: ");
                String lastName = scanner.nextLine();
                if(searchByLastName(lastName) == null){
                    System.out.println(lastName + " is not in the list.");
                }
                else{
                    System.out.println(searchByLastName(lastName));
                }
            }
            else if(choice.equals("8")){
                System.out.println("Enter a Phone Number: ");
                String phoneNumber = scanner.nextLine();
                if(searchByPhoneNumber(phoneNumber) == null){
                    System.out.println(phoneNumber + " is not in the list.");
                }
                else{
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
            }
            else{
                System.out.println("Error: Incorrect usage please try again");
            }
            printMenu();
            choice = scanner.nextLine();
        }
        return;
    }
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List ALl Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }
}
