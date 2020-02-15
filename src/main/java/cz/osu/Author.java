package cz.osu;

public class Author {

    /**
     * The name of the author.
     */
    private String name;

    /**
     * The surname of the author.
     */
    private String surname;

    /**
     * Creates an author.
     * @param name The name of an author.
     * @param surname The surname of an author.
     */
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Gets the name of the author.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the surname of the author.
     * @return The surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets the report of information about Author.
     * @return The report.
     */
    @Override
    public String toString() {
        return String.format("%s %s", name,surname);
    }
}