package encapsulation.assignment_problems;

public class ShoppingCart {
    private final String id;
    private final int maxItems;
    private final int[] prices;
    private int count;

    public ShoppingCart(String id, int maxItems) {
        this.id = id;
        this.maxItems = maxItems;
        this.prices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < maxItems) {
            prices[count++] = price;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal()); // 500
        System.out.println(cart.getItemCount()); // 3
    }
}
