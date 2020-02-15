package cz.osu;

public class Book {

    /**
     * The name of the book.
     */
    private String name;

    /**
     * The price of the book.
     */
    private double price;

    /**
     * The author of the book.
     */
    private Author author;

    /**
     * Creates a book.
     * @param name The name of a book.
     * @param price The price of a book.
     * @param author The author of a book
     */
    public Book(String name, double price, Author author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    /**
     * Gets a full name of the book.
     * @return The full name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets a price of the book.
     * @return The price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the author of the book.
     * @return The author.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Gets the report of the book.
     * @return The report.
     */
    @Override
    public String toString() {
        return String.format("Book: %s; Price: %s;\n\tAuthor: %s\n\n", name,price,author);
    }
}
