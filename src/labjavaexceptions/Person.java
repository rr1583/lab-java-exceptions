package labjavaexceptions;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    // Constructor
    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age);  // Use the setAge method to handle validation
        this.occupation = occupation;
    }

    // Setters and Getters
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        }
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        if (!name.equals(person.name)) return false;
        if (age != person.age) return false;
        return occupation.equals(person.occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
