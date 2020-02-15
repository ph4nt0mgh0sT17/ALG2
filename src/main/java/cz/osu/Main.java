package cz.osu;

public class Main {

    /**
     * Main entry of the console application.
     * @param args Possible arguments passed by executing the java application by terminal or command line.
     */
    public static void main(String[] args) {

        // Prints the welcome text
        System.out.println(getWelcomeText());

        // Creates a bookshop
        Bookshop bookshop = new Bookshop(25);

        // Adds some books to the bookshop
        bookshop.addBook("David jede", 754, new Author("David", "Miko"));
        bookshop.addBook("David jede", 150, new Author("David", "Miko"));
        bookshop.addBook("David jede", 268, new Author("David", "Miko"));

        // Tests methods of the bookshop
        System.out.println(bookshop.getReportAllBooks());
        System.out.println(bookshop.getAveragePrice());
        System.out.println(bookshop.getBookCountByName("David jede"));

        for (Book book : bookshop.getArrayListBooksUnderPrice(620)) {
            System.out.println(book);
        }
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                10. 02. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }

}
