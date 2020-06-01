package cz.osu;

import java.sql.Time;
import java.util.*;

public class UserDatabase {

    private List<User> userDatabase;

    private List<String> firstNames, lastNames;

    public UserDatabase() {
        userDatabase = new ArrayList<>();
        firstNames = lastNames = new ArrayList<>();
    }

    public void loadUserDatabase() {
        loadFirstNames();
        loadLastNames();
    }

    public void fillDatabase() {
        for (int i = 0; i < 100000000; i++) {
            userDatabase.add(generateUser());
        }
    }

    public void printUsers() {
        userDatabase.forEach(System.out::println);
    }

    public void sortByFirstName() {
        TimeIt.measureTime(() -> userDatabase.sort(Comparator.comparing(User::getFirstName)));
    }

    public void sortBySecondName() {
        TimeIt.measureTime(() -> userDatabase.sort(Comparator.comparing(User::getSecondName)));
    }

    public void sortByAge() {
        TimeIt.measureTime(this::run);
    }

    private User generateUser() {
        Random random = new Random();

        String firstName = firstNames.get(random.nextInt(firstNames.size()));
        String lastName = lastNames.get(random.nextInt(lastNames.size()));

        return new User(firstName, lastName, (byte)random.nextInt(40));
    }

    private void loadFirstNames() {
        String line = FileManager.getFileContent("first_names.txt");
        firstNames.addAll(Arrays.asList(line.split(",")));
    }

    private void loadLastNames() {
        String line = FileManager.getFileContent("last_names.txt");
        lastNames.addAll(Arrays.asList(line.split(",")));
    }

    private void run() {
        userDatabase.sort(Comparator.comparing(User::getAge));
    }
}
