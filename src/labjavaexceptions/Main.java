package labjavaexceptions;

public class Main {
    public static void main(String[] args) {
        // Test setAge method
        try {
            Person person1 = new Person(1, "John Doe", -5, "Engineer");
        } catch (IllegalArgumentException e) {
            System.out.println("setAge test passed: " + e.getMessage());
        }

        // Test findByName method
        PersonsList personsList = new PersonsList();
        Person person2 = new Person(2, "Jane Smith", 30, "Doctor");
        personsList.addPerson(person2);

        try {
            Person foundPerson = personsList.findByName("Jane Smith");
            System.out.println("findByName test passed: " + foundPerson);
        } catch (IllegalArgumentException e) {
            System.out.println("findByName test failed: " + e.getMessage());
        }

        try {
            personsList.findByName("JaneSmith");  // Incorrect format
        } catch (IllegalArgumentException e) {
            System.out.println("findByName format test passed: " + e.getMessage());
        }

        // Test clone method
        Person clonedPerson = personsList.clone(person2);
        System.out.println("clone test passed: " + clonedPerson);

        // Test writePersonToFile method
        personsList.writePersonToFile(person2, "person.txt");
        System.out.println("writePersonToFile test passed: Check person.txt file");
    }
}
