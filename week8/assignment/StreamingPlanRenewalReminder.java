import java.time.LocalDate;

public class StreamingPlanRenewalReminder {

    public abstract static class Subscription {
        String name;
        LocalDate startDate;

        public Subscription(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public abstract int getValidityDays();

        public LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    public static class BasicPlan extends Subscription {
        public BasicPlan(String name, LocalDate start) { super(name, start); }
        @Override public int getValidityDays() { return 30; }
    }

    public static class StandardPlan extends Subscription {
        public StandardPlan(String name, LocalDate start) { super(name, start); }
        @Override public int getValidityDays() { return 90; }
    }

    public static class PremiumPlan extends Subscription {
        public PremiumPlan(String name, LocalDate start) { super(name, start); }
        @Override public int getValidityDays() { return 365; }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 5: The Streaming Plan Renewal Reminder ===");
        Subscription[] subs = {
            new BasicPlan("Asha", LocalDate.of(2024, 1, 15)),
            new StandardPlan("Ravi", LocalDate.of(2024, 2, 1)),
            new PremiumPlan("Neha", LocalDate.of(2024, 3, 10)),
            new BasicPlan("Kiran", LocalDate.of(2024, 12, 20))
        };

        for (Subscription s : subs) {
            System.out.printf("%s: %s%n", s.name, s.getRenewalDate());
        }
    }
}
