package cz.osu;

public class Main {

    public static void main(String[] args) {

        System.out.println("==================== 7ALG2 ====================\n\t\t\t10. 02. 2020\n\t\t\tDavid Miko\n===============================================");

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

}
