package cz.osu;

import java.util.regex.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("==================== 7ALG2 ====================\n\t\t\t10. 02. 2020\n\t\t\tDavid Miko\n===============================================");

        Bookshop bookshop = new Bookshop(5);

        bookshop.addBook("David jede", 754, new Author("David", "Miko"));
        bookshop.addBook("David jede", 150, new Author("David", "Miko"));
        bookshop.addBook("David jede", 268, new Author("David", "Miko"));

        System.out.println(bookshop.reportAllBooks());

        System.out.println(bookshop.getAveragePrice());

        System.out.println(bookshop.getBookCountByName("David jede"));

        for (Book book : bookshop.getBooksUnderPrice(620)) {
            System.out.println(book);
        }
    }

}
