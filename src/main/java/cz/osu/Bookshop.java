package cz.osu;

import java.util.ArrayList;

public class Bookshop {
    private Book[] books;
    int currentIndex;

    public Bookshop(int capacity) {
        this.books = new Book[capacity];
        currentIndex = 0;
    }

    public void addBook(Book book) {
        if (currentIndex == books.length) {
            System.out.println("You cannot add a book anymore!");
            return;
        }

        this.books[currentIndex] = book;
        currentIndex++;
    }

    public void addBook(String name, double price, Author author) {
        if (currentIndex == books.length) {
            System.out.println("You cannot add a book anymore!");
            return;
        }

        this.books[currentIndex] = new Book(name,price,author);
        currentIndex++;
    }

    public String reportAllBooks() {
        String report = "";

        for(Book book : books) {
            if (book != null)
                report += book.toString();
        }

        return report;
    }

    public int getBookCountByName(String bookName) {
        int bookCount = 0;

        for (Book book : books) {
            if (book != null) {
                if (book.getName().equals(bookName)) {
                    bookCount++;
                }
            }
        }

        return bookCount;
    }

    public double getAveragePrice() {
        double price = 0;

        for (Book book : books) {
            if (book != null) {
                price += book.getPrice();
            }
        }

        return price / currentIndex;
    }

    public ArrayList<Book> getArrayListBooksUnderPrice(double priceLimit) {
        ArrayList<Book> bookList = new ArrayList<>();

        for (Book book : books) {
            if (book != null && book.getPrice() <= priceLimit) {
                bookList.add(book);
            }
        }

        return bookList;
    }

    public Book[] getBooksUnderPrice(double priceLimit) {
        int countBook = 0;

        for (Book book : books) {
            if (book != null && book.getPrice() <= priceLimit) {
                countBook++;
            }
        }

        Book[] currentBooks = new Book[countBook];
        int index = 0;

        for (int i = 0; i < currentIndex; i++) {
            if (books[i].getPrice() <= priceLimit) {
                currentBooks[index] = books[i];
                index++;
            }
        }

        return currentBooks;
    }


}
