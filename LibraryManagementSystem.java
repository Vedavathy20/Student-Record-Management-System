import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayBook() {
        System.out.println(id + " | " + title + " | " + author + " | Issued: " + isIssued);
    }
}

class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book b : books) {
            b.displayBook();
        }
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully");
                    return;
                } else {
                    System.out.println("Book already issued");
                    return;
                }
            }
        }
        System.out.println("Book not found");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully");
                    return;
                } else {
                    System.out.println("Book was not issued");
                    return;
                }
            }
        }
        System.out.println("Book not found");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        lib.addBook(new Book(1, "Java Basics", "James Gosling"));
        lib.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}