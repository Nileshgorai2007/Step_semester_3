package encapsulation.class_problems;

public class AttendanceSheet {
    private final int maxSize;
    private final String[] presentNames;
    private int count;

    public AttendanceSheet(int maxSize) {
        this.maxSize = maxSize;
        this.presentNames = new String[maxSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        // Check duplicate
        for (int i = 0; i < count; i++) {
            if (presentNames[i].equals(name)) {
                return; // already marked
            }
        }
        if (count < maxSize) {
            presentNames[count++] = name;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentNames[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate ignored
        System.out.println(sheet.getPresentCount()); // 2
        System.out.println(sheet.isPresent("Ben")); // true
    }
}
