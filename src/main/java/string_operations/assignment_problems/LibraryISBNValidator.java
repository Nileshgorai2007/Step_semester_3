package string_operations.assignment_problems;

public class LibraryISBNValidator {
    public static void main(String[] args) {
        String code1 = " pen2026004251 ";
        String code2 = "12N2026004251";
        
        System.out.println(validateAndFormat(normalizeCode(code1)));
        System.out.println(validateAndFormat(normalizeCode(code2)));
    }

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        return firstThree + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code.substring(0, 3)).append("] ")
                 .append("YEAR: ").append(code.substring(3, 7)).append(" | ")
                 .append("CATALOG: ").append(code.substring(7, 13));
                 
        return formatted.toString();
    }
}
