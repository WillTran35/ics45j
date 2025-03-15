package labs.lab4;
import java.util.ArrayList;
/**
 * Represents an inventory of toys
 */
public class ToyInventory {
// ADD INSTANCE VARIABLES HERE
    /**
     * Constructor that constructs a new ToyInventory object
     */
    private ArrayList <Toy> toyList;
    public ToyInventory() {
// FILL IN
        this.toyList = new ArrayList<>();
    }
    /**
     * Adds the given toy if a toy with that name doesn't already exist in
     * the inventory
     *
     * @param toy toy to add
     */
    public void addToy(Toy toy) {
// FILL IN
        boolean flag = false;
        for (Toy t : toyList){
            if (t.getName().equals(toy.getName())){
                flag = true;
                break;
            }
        }
        if (!flag) {
            toyList.add(toy);
        }
    }
    /**
     * Removes the toy with the given name if it exists in the inventory
     *
     * @param name name of toy to remove
     */
    public void removeToy(String name) {
// FILL IN
        for (Toy t : toyList){
            if (t.getName().equals(name)){
                toyList.remove(t);
                break;
            }
        }
    }
    /**
     * @return a String that lists the name, description, and DESTROYED or NOT
    DESTROYED for each
     * toy in the format:
     * name
     * description
     * DESTROYED/NOT DESTROYED
     */
    public String getInventoryReport() {
        String result = "";
        for (Toy t : toyList){
            result += t.getName() + "\n";
            result += t.getDescription() + "\n";
            if (t.isDestroyed()){
                result += "DESTROYED" ;
//                System.out.println("DESTROYED");
            }
            else{
                result += "NOT DESTROYED";
//                System.out.println("NOT DESTROYED");
            }
            if (toyList.indexOf(t) != toyList.size() - 1){
                result += "\n";
            }
        }
        return result; // FIX ME
    }
    public static void main (String [] args){
        Toy lamby = new Toy("Lamby", "white fluffy stuffed lamb that I got for Christmas", false);
        Toy sharky = new Toy("Sharky", "blue shark with its mouth chewed off", true);
        Toy socky = new Toy("Socky", "my brother's old sock that I like to carry around in my mouth like a treasure", true);
        Toy tennisBall = new Toy("Tennis Ball", "standard green tennis ball that I play with outside", false);
        ToyInventory inventory = new ToyInventory();
        inventory.addToy(lamby);
        inventory.addToy(sharky);
        inventory.addToy(socky);
        inventory.addToy(tennisBall);
        inventory.removeToy("Sharky");
        System.out.println(inventory.getInventoryReport());
// returns:
//        Lamby
//        white fluffy stuffed lamb that I got for Christmas
//        NOT DESTROYED
//        Socky
//        my brother's old sock that I like to carry around in my mouth like a treasure
//        DESTROYED
//        Tennis Ball
//        standard green tennis ball that I play with outside
//        NOT DESTROYED
    }
}
