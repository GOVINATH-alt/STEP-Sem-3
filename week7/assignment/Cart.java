public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length && price >= 0) {
            prices[itemCount++] = price;
        }
    }

    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 5: The Shopping Cart ===");
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.printf("Total: %.0f | Item Count: %d%n", cart.getTotal(), cart.getItemCount());
    }
}
