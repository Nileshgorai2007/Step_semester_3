package string_operations.class_problems;

public class BankTransactionValidator {
    public static void main(String[] args) {
        String ref1 = " hdf03022600042 ";
        String ref2 = "12F03022600042";
        
        System.out.println(validateAndFormat(normalizeReference(ref1)));
        System.out.println(validateAndFormat(normalizeReference(ref2)));
    }

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        return firstThree + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference.substring(0, 3)).append("] ")
                 .append("DATE: ").append(reference.substring(3, 5)).append("/")
                 .append(reference.substring(5, 7)).append("/")
                 .append(reference.substring(7, 9)).append(" | ")
                 .append("SEQ: ").append(reference.substring(9, 14));
                 
        return formatted.toString();
    }
}
