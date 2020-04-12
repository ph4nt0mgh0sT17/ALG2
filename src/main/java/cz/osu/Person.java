package cz.osu;

public class Person {

    /**
     * The first name of the person.
     */
    private String name;

    /**
     * The last name of the person.
     */
    private String surname;

    /**
     * The sex of the person.
     */
    private Sex sex;

    /**
     * The default constructor that initalizes the person.
     * @param name The name of the person.
     * @param surname The surname of the person.
     * @param sex The sex of the person.
     */
    public Person(String name, String surname, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    /**
     * Gets the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the surname of the person.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets the sex enum of the person.
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Sets the surname of the person.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                '}';
    }
}
