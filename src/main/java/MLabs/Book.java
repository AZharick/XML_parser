package MLabs;

public class Book {
   public String name;
   public String author;

   public Book(String name, String author, int pages) {
      this.name = name;
      this.author = author;
   }

   public Book() {
   }

   @Override
   public String toString() {
      return "Book{" +
              "name='" + name + '\'' +
              ", author='" + author + '\'' +
              '}';
   }
}
