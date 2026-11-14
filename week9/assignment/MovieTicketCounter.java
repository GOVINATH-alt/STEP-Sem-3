public class MovieTicketCounter {

    public abstract static class Ticket {
        static final double CONVENIENCE_FEE = 20.0; // In one place only
        int seatNumber;

        public Ticket(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        public abstract double getBasePrice();
        public abstract String getSeatType();

        public double calculateTotalAmount() {
            return getBasePrice() + CONVENIENCE_FEE;
        }
    }

    public static class RegularTicket extends Ticket {
        public RegularTicket(int seat) { super(seat); }
        @Override public double getBasePrice() { return 150.0; }
        @Override public String getSeatType() { return "Regular"; }
    }

    public static class PremiumTicket extends Ticket {
        public PremiumTicket(int seat) { super(seat); }
        @Override public double getBasePrice() { return 250.0; }
        @Override public String getSeatType() { return "Premium"; }
    }

    public static class ReclinerTicket extends Ticket {
        public ReclinerTicket(int seat) { super(seat); }
        @Override public double getBasePrice() { return 400.0; }
        @Override public String getSeatType() { return "Recliner"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 1: Movie Ticket Counter ===");
        Ticket[] bookings = {
            new RegularTicket(12),
            new PremiumTicket(24),
            new ReclinerTicket(5)
        };

        double grandTotal = 0;
        for (Ticket t : bookings) {
            double total = t.calculateTotalAmount();
            grandTotal += total;
            System.out.printf("Seat %2d (%-8s): Base=%.2f, Fee=%.2f -> Total=Rs %.2f%n",
                    t.seatNumber, t.getSeatType(), t.getBasePrice(), Ticket.CONVENIENCE_FEE, total);
        }
        System.out.printf("Total Collection: Rs %.2f%n", grandTotal);
    }
}
