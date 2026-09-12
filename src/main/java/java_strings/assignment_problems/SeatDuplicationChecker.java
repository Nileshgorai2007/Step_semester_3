package java_strings.assignment_problems;

public class SeatDuplicationChecker {
    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.println("Input 1:");
        checkDuplicateSeats(seats1);
        
        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.println("Input 2:");
        checkDuplicateSeats(seats2);
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        System.out.print("Duplicate Seat Number Found: ");
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.print(seatNumbers[i] + " ");
                    found = true;
                }
            }
        }
        if (!found) {
            // clear the "Duplicate Seat Number Found: " print
            System.out.print("\rNo Duplicate Seats Found                               ");
        }
        System.out.println();
    }
}
