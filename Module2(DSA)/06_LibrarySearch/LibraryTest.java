public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Clean Code", "Robert C. Martin"),
                new Book(2, "The Pragmatic Programmer", "Andy Hunt"),
                new Book(3, "Introduction to Algorithms", "Thomas Cormen"),
                new Book(4, "Design Patterns", "Erich Gamma"),
                new Book(5, "Effective Java", "Joshua Bloch")
        };

        String targetTitle = "Design Patterns";

        System.out.println("Linear search result: " + LibrarySearch.linearSearchByTitle(books, targetTitle));

        LibrarySearch.sortByTitle(books);
        System.out.println("\nBooks sorted by title:");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nBinary search result: " + LibrarySearch.binarySearchByTitle(books, targetTitle));
    }
}
