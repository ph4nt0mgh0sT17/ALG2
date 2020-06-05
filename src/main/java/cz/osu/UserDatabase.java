package cz.osu;

import java.sql.Time;
import java.util.*;

public class UserDatabase {

    private final List<User> userDatabase;

    private final List<String> firstNames;
    private final List<String> lastNames;

    public UserDatabase() {
        userDatabase = new ArrayList<>();
        firstNames = lastNames = new ArrayList<>();
    }

    public void loadUserDatabase() {
        loadFirstNames();
        loadLastNames();
    }

    private void fillDatabase() {
        for (int i = 0; i < 1000000; i++) {
            userDatabase.add(generateUser());
        }
    }

    public void measureFillingDatabase() {
        TimeIt.measureTime(this::fillDatabase);
    }

    public void printUsers() {
        userDatabase.forEach(System.out::println);
    }

    public void sortByFirstName() {
        TimeIt.measureTime(() -> userDatabase.sort(Comparator.comparing(User::getFirstName)));

        userDatabase.sort(Comparator.comparing(User::getFirstName));
    }

    public void sortBySecondName() {
        TimeIt.measureTime(() -> userDatabase.sort(Comparator.comparing(User::getSecondName)));
    }

    public void sortByAge() {
        TimeIt.measureTime(() -> userDatabase.sort(Comparator.comparing(User::getAge)));
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
}
