package hust.soict.hedspi.test.book;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("1", "1", 120);
        book.addAuthor("Nguyen");
        book.addAuthor("Gia");

        book.addAuthor("Minh");
        String content = "Content marketing is all about using content to attract and retain visitors and eventually turn them into customers. And most people who use it know it’s effective.";
        book.setContent(content);
        book.toString();
    }
}
