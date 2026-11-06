import java.util.*;

// Main class
public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Movie> movies = new ArrayList<>();
    static HashMap<String, Booking> bookings = new HashMap<>();

    static int bookingCounter = 1;

    public static void main(String[] args) {

        // Adding movies
        movies.add(new Movie(1, "Avengers", "10:00 AM", 500, 30));
        movies.add(new Movie(2, "Spider Man", "01:00 PM", 600, 30));
        movies.add(new Movie(3, "Batman", "05:00 PM", 400, 30));

        while (true) {

            System.out.println("\n0. Exit");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 0:
                    System.out.println("Exiting Cinema Ticket Booking System...");
                    return;

                case 1:
                    viewMovies();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    // Function to read integer input
    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 1. View movies
    static void viewMovies() {

        System.out.println("\n--- Available Movies ---");

        for (Movie m : movies) {
            m.displayMovie();
        }
    }

    // 2. Book tickets
    static void bookTicket() {

        viewMovies();

        System.out.print("\nEnter Movie ID: ");
        int movieId = readInt();

        Movie selectedMovie = null;

        for (Movie m : movies) {
            if (m.getId() == movieId) {
                selectedMovie = m;
                break;
            }
        }

        if (selectedMovie == null) {
            System.out.println("Invalid Movie ID!");
            return;
        }

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of seats: ");
        int seats = readInt();

        if (seats <= 0) {
            System.out.println("Invalid number of seats!");
            return;
        }

        if (seats > selectedMovie.getAvailableSeats()) {
            System.out.println("Only " + selectedMovie.getAvailableSeats()
                    + " seats available!");
            return;
        }

        selectedMovie.bookSeats(seats);

        String bookingId = "B" + bookingCounter++;

        Booking booking = new CinemaBooking(
                bookingId, name, selectedMovie, seats
        );

        bookings.put(bookingId, booking);

        System.out.println("\nBooking successful!");
        booking.displayBooking();
    }

    // 3. Cancel booking
    static void cancelBooking() {

        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = sc.nextLine();

        Booking booking = bookings.get(bookingId);

        if (booking != null) {

            booking.getMovie().releaseSeats(booking.getSeats());

            bookings.remove(bookingId);

            System.out.println("Booking cancelled successfully!");

        } else {
            System.out.println("Booking not found!");
        }
    }

    // 4. View bookings
    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        System.out.println("\n--- My Bookings ---");

        for (Booking b : bookings.values()) {
            b.displayBooking();
        }
    }
}


// Movie class
class Movie {

    // Encapsulation: Private attributes
    private int id;
    private String name;
    private String showTime;
    private double ticketPrice;
    private int availableSeats;

    // Constructor
    Movie(int id, String name, String showTime,
          double ticketPrice, int availableSeats) {

        this.id = id;
        this.name = name;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShowTime() {
        return showTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to book seats
    public void bookSeats(int seats) {
        availableSeats -= seats;
    }

    // Method to release seats
    public void releaseSeats(int seats) {
        availableSeats += seats;
    }

    // Display movie details
    public void displayMovie() {

        System.out.println(
                "ID: " + id
                + " | Movie: " + name
                + " | Time: " + showTime
                + " | Price: Rs." + ticketPrice
                + " | Seats Left: " + availableSeats
        );
    }
}


// Abstract parent class
abstract class Booking {

    // Private attributes
    private String bookingId;
    private String customerName;
    private Movie movie;
    private int seats;

    // Constructor
    Booking(String bookingId, String customerName,
            Movie movie, int seats) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.movie = movie;
        this.seats = seats;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getSeats() {
        return seats;
    }

    // Abstract method
    abstract double calculateTotalFare();

    abstract void displayBooking();
}


// Child class
class CinemaBooking extends Booking {

    // Constructor
    CinemaBooking(String bookingId, String customerName,
                  Movie movie, int seats) {

        super(bookingId, customerName, movie, seats);
    }

    // Method overriding (Polymorphism)
    @Override
    double calculateTotalFare() {

        return getMovie().getTicketPrice() * getSeats();
    }

    // Method overriding (Polymorphism)
    @Override
    void displayBooking() {

        System.out.println(
                "\nBooking ID: " + getBookingId()
                + " | Name: " + getCustomerName()
                + " | Movie: " + getMovie().getName()
                + " | Time: " + getMovie().getShowTime()
                + " | Seats: " + getSeats()
                + " | Total Fare: Rs." + calculateTotalFare()
        );
    }
}
