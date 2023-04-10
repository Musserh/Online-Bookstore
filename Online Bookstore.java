import java.util.ArrayList;
class Book {
  private String title;
  private String author;
  private String ISBN;
  private double price;

  public Book(String title, String author, String ISBN, double price) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.price = price;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getISBN() {
    return this.ISBN;
  }

  public double getPrice() {
    return this.price;
  }
}

class ShoppingCart {
  private ArrayList<Book> books;

  public ShoppingCart() {
    this.books = new ArrayList<Book>();
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void removeBook(Book book) {
    this.books.remove(book);
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (Book book : this.books) {
      totalPrice += book.getPrice();
    }
    return totalPrice;
  }
}

class Bookstore {
  private ArrayList<Book> books;

  public Bookstore() {
    this.books = new ArrayList<Book>();
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void removeBook(Book book) {
    this.books.remove(book);
  }

  public Book findBookByISBN(String ISBN) {
    for (Book book : this.books) {
      if (book.getISBN().equals(ISBN)) {
        return book;
      }
    }
    return null;
  }
}

class Customer {
  private String name;
  private String email;
  private String address;
  private ShoppingCart cart;

  public Customer(String name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
    this.cart = new ShoppingCart();
  }

  public void addToCart(Book book) {
    this.cart.addBook(book);
  }

  public void removeFromCart(Book book) {
    this.cart.removeBook(book);
  }

  public void checkout() {
    double totalPrice = this.cart.getTotalPrice();
    // Code to process payment and finalize the order
    System.out.println("Thank you for your purchase of $" + totalPrice);
  }
}

public class Main {
  public static void main(String[] args) {
    Bookstore bookstore = new Bookstore();
    bookstore.addBook(new Book("Java Programming", "John Doe", "1234567890", 19.99));
    bookstore.addBook(new Book("Python Programming", "Jane Smith", "0987654321", 14.99));

    Customer customer = new Customer("Alice", "alice@example.com", "123 Main St");
    Book book1 = bookstore.findBookByISBN("1234567890");
    Book book2 = bookstore.findBookByISBN("0987654321");
    customer.addToCart(book1);
    customer.addToCart(book2);
    customer.checkout();
  }
}