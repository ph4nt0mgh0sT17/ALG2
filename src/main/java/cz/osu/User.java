package cz.osu;

public class User {

    private final String firstName;
    private final String secondName;
    private final byte age;

    public User(String firstName, String secondName, byte age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
