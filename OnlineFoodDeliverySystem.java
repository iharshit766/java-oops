import java.util.*;

interface Discountable {
    void applyDiscount();
    double getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 20.0;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity, double discount) {
        super(itemName, price, quantity);
        this.discount = discount;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE - discount;
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount of: " + discount);
    }

    @Override
    public double getDiscountDetails() {
        return discount;
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 350, 1, 30));

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount();
                System.out.println("Final Price after Discount: " + item.calculateTotalPrice());
            }
            System.out.println();
        }
    }
}

