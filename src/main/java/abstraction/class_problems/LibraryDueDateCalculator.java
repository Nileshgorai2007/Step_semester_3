package abstraction.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    protected String title;
    protected LocalDate checkoutDate;
    public LibraryItem(String title, LocalDate checkoutDate) {
        this.title = title;
        this.checkoutDate = checkoutDate;
    }
    public abstract LocalDate calculateDueDate();
    public String getTitle() { return title; }
}

class BookItem extends LibraryItem {
    public BookItem(String title, LocalDate checkoutDate) { super(title, checkoutDate); }
    @Override public LocalDate calculateDueDate() { return checkoutDate.plusDays(14); }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, LocalDate checkoutDate) { super(title, checkoutDate); }
    @Override public LocalDate calculateDueDate() { return checkoutDate.plusDays(7); }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, LocalDate checkoutDate) { super(title, checkoutDate); }
    @Override public LocalDate calculateDueDate() { return checkoutDate.plusDays(3); }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        LocalDate current = LocalDate.of(2023, 10, 26);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LibraryItem[] items = {
            new BookItem("1984", current),
            new DVDItem("The Matrix", current),
            new MagazineItem("Forbes Issue 500", current)
        };
        
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate().format(fmt));
        }
    }
}
