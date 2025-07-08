import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Inventory {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public List<Book> removeBook(int maxAge) {
        int currentYear = 2025;
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (currentYear - book.getPublicationYear() > maxAge) {
                System.out.println("Removed book: " + book.getTitle() + " published in " + book.getPublicationYear());
                removedBooks.add(book);
                it.remove();
            }
        }
        return removedBooks;
    }

    public double buyBook(String ISBN, int quantity, String email, String address, UserAccount account) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book.BuyBook(quantity, email, address, account);
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + ISBN + " not found.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", ISBN: " + book.getISBN() + ", Price: " + book.getPrice());
        }
    }
}