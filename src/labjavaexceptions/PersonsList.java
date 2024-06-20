package labjavaexceptions;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    // Add a Person to the list
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Find a Person by name
    public Person findByName(String name) {
        if (!name.matches("[A-Za-z]+ [A-Za-z]+")) {
            throw new IllegalArgumentException("Name must be properly formatted as 'firstName lastName'");
        }
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    // Clone a Person
    public Person clone(Person person) {
        return new Person(getNextId(), person.getName(), person.getAge(), person.getOccupation());
    }

    // Get the next ID
    private int getNextId() {
        return persons.size() + 1;  // Simple implementation for example purposes
    }

    // Write Person information to a file
    public void writePersonToFile(Person person, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
