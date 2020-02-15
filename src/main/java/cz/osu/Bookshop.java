package cz.osu;

import java.util.ArrayList;

/**
 * Bookshop structure that serves for storing and retrieving books.
 */
public class Bookshop {

    /**
     * Books stored in the bookshop.
     */
    private Book[] books;

    /**
     * Current index of the last time stored book.
     */
    int currentIndex;

    /**
     * Creates a bookshop with given capacity of maximum possible books.
     * @param capacity The maximum amount of books to be stored.
     */
    public Bookshop(int capacity) {
        this.books = new Book[capacity];
        currentIndex = 0;
    }

    /**
     * Validates if a book can be stored into bookshop or not.
     * @return The true or false.
     */
    private boolean validateBookCapacity() {

        // Checks if there is still some place for some books
        if (currentIndex == books.length) {
            System.out.println("You cannot add a book anymore!");
            return false;
        }

        // Returns true if there can be still stored some books
        return true;
    }

    /**
     * Adds a book to the bookshop.
     * @param book The given book.
     */
    public void addBook(Book book) {

        // Adds a book to the books array if there is capacity
        if (validateBookCapacity()) {
            this.books[currentIndex] = book;
            currentIndex++;
        }
    }

    /**
     * Adds a book to the bookshop.
     * @param name The name of a book.
     * @param price The price of a book.
     * @param author The author of a book
     */
    public void addBook(String name, double price, Author author) {
        addBook(new Book(name, price, author));
    }

    /**
     * Gets a report of all books stored in the bookshop.
     * @return The string report.
     */
    public String getReportAllBooks() {
        String report = "";

        for(Book book : books) {

            // Gets report of all books that are not null => that were stored (initialized)
            if (book != null)
                report += book.toString();
        }

        return report;
    }

    /**
     * Gets amount of books by given name.
     * @param bookName The given name.
     * @return The amount of books.
     */
    public int getBookCountByName(String bookName) {
        int bookCount = 0;

        for (Book book : books) {

            // Includes (by incrementing) all books that are initialized
            if (book != null) {
                if (book.getName().equals(bookName)) {
                    bookCount++;
                }
            }
        }

        return bookCount;
    }

    /**
     * Gets the average price of all books in the bookprice.
     * @return The average price.
     */
    public double getAveragePrice() {
        double price = 0;

        for (Book book : books) {

            // Includes all books that are initialized
            if (book != null) {
                price += book.getPrice();
            }
        }

        return price / currentIndex;
    }

    /**
     * Gets all books that are under the given priceLimit.
     * @param priceLimit The given price limit.
     * @return The list of books.
     */
    public ArrayList<Book> getArrayListBooksUnderPrice(double priceLimit) {
        ArrayList<Book> bookList = new ArrayList<>();

        for (Book book : books) {

            // Includes (by incrementing) all books that are initialized
            if (book != null) {

                // Adds the book that is within priceLimit to the result ArrayList
                if (book.getPrice() <= priceLimit) {
                    bookList.add(book);
                }
            }
        }

        return bookList;
    }
}
