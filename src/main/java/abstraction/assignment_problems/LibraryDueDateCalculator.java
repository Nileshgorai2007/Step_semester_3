package abstraction.assignment_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class LibraryDueDateCalculator {
    private static final DateTimeFormatter INPUT_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final Map<String, Integer> DURATION_DAYS = new HashMap<>();
    static {
        DURATION_DAYS.put("BOOK", 21);
        DURATION_DAYS.put("DVD", 7);
        DURATION_DAYS.put("MAGAZINE", 14);
    }

    private static LocalDate calculateDue(String type, LocalDate checkout) {
        Integer days = DURATION_DAYS.get(type.toUpperCase());
        if (days == null) {
            throw new IllegalArgumentException("Unknown item type: " + type);
        }
        return checkout.plusDays(days);
    }

    public static void main(String[] args) {
        // Demo data
        String[] types = {"BOOK", "DVD", "MAGAZINE"};
        String[] dates = {"2024-01-15", "2024-02-01", "2024-03-10"};
        for (int i = 0; i < types.length; i++) {
            LocalDate checkout = LocalDate.parse(dates[i], INPUT_FMT);
            LocalDate due = calculateDue(types[i], checkout);
            System.out.println(types[i] + ": " + due.format(OUTPUT_FMT));
        }
        // Total processing not required for this demo.
    }
}
