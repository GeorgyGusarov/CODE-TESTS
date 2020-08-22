package GenericsAndCollections;

import java.util.*;

public class TestTree {

    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново своё тело");
        Book b3 = new Book("В поисках Эмо");

        CompareBooks compareBooks = new CompareBooks();

        TreeSet<Book> tree = new TreeSet<Book>(compareBooks);
        tree.add(new Book("Как устроены кошки"));
        tree.add(new Book("Постройте заново своё тело"));
        tree.add(new Book("В поисках Эмо"));
        System.out.println(tree);
    }
}

class Book implements Comparable {
    String title;

    public Book(String t) {
        title = t;
    }

    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        return (title.compareTo(book.title));
    }
}

class CompareBooks implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return (book1.title.compareTo(book2.title));
    }
}
