import java.util.Scanner;

public class MovieTheater {
    private static final int ROWS = 5; // Number of rows in the theater
    private static final int SEATS_PER_ROW = 10; // Number of seats per row
    private boolean[][] seats = new boolean[ROWS][SEATS_PER_ROW]; // Seating chart

    // Method to display the seating chart
    public void displaySeatingChart() {
        System.out.println("Seating Chart: (X = Taken, O = Available)");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    // Method to reserve a seat
    public void reserveSeat(int row, int seat) {
        if (row < 1 || row > ROWS || seat < 1 || seat > SEATS_PER_ROW) {
            System.out.println("Invalid seat selection. Please try again.");
            return;
        }
        if (seats[row - 1][seat - 1]) {
            System.out.println("Seat is already taken. Suggesting an available seat...");
            suggestAvailableSeat();
        } else {
            seats[row - 1][seat - 1] = true;
            System.out.println("Seat reserved successfully.");
        }
    }

    // Method to cancel a seat reservation
    public void cancelSeat(int row, int seat) {
        if (row < 1 || row > ROWS || seat < 1 || seat > SEATS_PER_ROW) {
            System.out.println("Invalid seat selection. Please try again.");
            return;
        }
        if (!seats[row - 1][seat - 1]) {
            System.out.println("Seat is not reserved.");
        } else {
            seats[row - 1][seat - 1] = false;
            System.out.println("Seat reservation canceled successfully.");
        }
    }

    // Suggest the next available seat
    private void suggestAvailableSeat() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                if (!seats[i][j]) {
                    System.out.println("Suggested available seat: Row " + (i + 1) + ", Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

    // Main method
    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovie Theater Seat Reservation System");
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theater.displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row (1-5): ");
                    int row = scanner.nextInt();
                    System.out.print("Enter seat (1-10): ");
                    int seat = scanner.nextInt();
                    theater.reserveSeat(row, seat);
                    break;
                case 3:
                    System.out.print("Enter row (1-5): ");
                    row = scanner.nextInt();
                    System.out.print("Enter seat (1-10): ");
                    seat = scanner.nextInt();
                    theater.cancelSeat(row, seat);
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}