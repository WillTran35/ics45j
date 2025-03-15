package labs.lab7;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Class for simulating trading a single stock at varying prices.
 */
public class StockSimulator {
    private Queue<Block> blocks;
    /**
     * Constructor
     */

    public StockSimulator() {
// FILL IN
        this.blocks = new LinkedList<>(); // FIFO order
    }
    /**
     * Handle a user buying a given quantity of stock at a given price.
     *
     * @param quantity how many to buy.
     * @param price the price to buy at.
     *
     * @throws IllegalArgumentException if the requested quantity/price cannot be
     * sold i.e., quantity <= 0 or price < 0
     */
    public void buy(int quantity, int price) throws IllegalArgumentException {
// FILL IN
        if (quantity < 0 || price < 0){
            throw new IllegalArgumentException("Unable to complete purchase");
        }
        this.blocks.add(new Block(quantity, price));
    }
    /**
     * Handle a user selling a given quantity of stock at a given price.
     *
     * @param quantity how many to sell.
     * @param price the price to sell.
     *
     * @return the gain (can be positive or negative)
     *
     * @throws IllegalArgumentException if the requested quantity cannot be sold
     * e.g., quantity exceeds quantity owned,
     * quantity < 1, price < 0
     */
    public int sell(int quantity, int price) throws IllegalArgumentException {
        int totalSold = 0;
        int cost = 0 ;
        if (quantity < 0 || price < 0){
            throw new IllegalArgumentException("Unable to complete purchase");
        }
        for (Block b : blocks){
            if (totalSold == quantity){
                return price * quantity - cost;
            }
            int remaining = quantity - totalSold;
            if (b.getQuantity() <= remaining){
                totalSold += b.getQuantity();
                cost += b.getQuantity() * b.getPrice();
                b.sell(b.getQuantity());
            }
            else{
                totalSold += remaining;
                cost += remaining * b.getPrice();
                b.sell(remaining);
            }
        }
        if (totalSold < quantity){
            throw new IllegalArgumentException("Unable to complete sale");
        }

//        System.out.println(quantity + " " + price+ " " + totalSold + " " + cost);

        return price * quantity - cost;
    }
    /**
     * This is a method for us to test your class
     *
     * @return a List of Blocks owned
     */
    public List<Block> getBlocks() {
        ArrayList <Block> a = new ArrayList<Block>();
        a.addAll(blocks);
        return a; // FIX ME
    }
}
