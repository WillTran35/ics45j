package labs.lab4;
/**
 * A class for a customer in Robert's pet store. For every $100 spent, the
 * customer gets a 10% discount that will be automatically applied to
 * a future purchase. Note that some results will have more than two places
 * after the decimal points, and that's ok.
 */
public class Customer {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Creates a new customer
     */
    private int discounts;
    private double purchase;
    private double purchase2;

    public Customer() {
        this.discounts = 0;
        this.purchase = 0 ;
//        this.purchase2 = 0 ;
// FILL IN
    }
    /**
     * adds a purchase for the amount to the customer's account; assume
     * the amount will always be a valid monetary amount > 0
     *
     * @param amount amount of purchase
     */
    public void makePurchase(double amount) {
// FILL IN
        if (discounts > 0){
            amount *= 0.9;
            discounts -- ;
        }

        int before = (int) (purchase / 100);
        purchase += amount;
        int after = (int) (purchase / 100);


//            purchase2 += amount;

        discounts += after - before ;


    }

    /**
     * Returns the number of discounts this customer has on their account
     * to be used on future purchases
     *
     * @return number of discounts to use
     */
    public int getNumDiscountsToUse() {
        return discounts;

    }
    /**
     * Returns the total amount this customer has spent on all their purchases
     *
     * @return total amount spent
     */
    public double getTotalAmountSpent() {
        return purchase;
    }

    public static void main (String [] args){
        Customer c = new Customer();
        c.makePurchase(75);
        System.out.println(c.getNumDiscountsToUse()); // returns 0
        System.out.println(c.getTotalAmountSpent()); // returns 75.0
        c.makePurchase(50.25);
        System.out.println(c.getNumDiscountsToUse()); // returns 1
        System.out.println(c.getTotalAmountSpent()); // returns 125.25
        c.makePurchase(9.99);
        System.out.println(c.getNumDiscountsToUse()); // returns 0
        System.out.println(c.getTotalAmountSpent()); // returns 134.24099999999999
        c.makePurchase(234.30);
        System.out.println(c.getNumDiscountsToUse()); // returns 2
        System.out.println(c.getTotalAmountSpent()); // returns 368.541
        c.makePurchase(10);
        System.out.println(c.getNumDiscountsToUse()); // returns 1
        System.out.println(c.getTotalAmountSpent()); // returns 377.541

        Customer x = new Customer();
        x.makePurchase(300);
        System.out.println("NEW CUSTOMER");
        System.out.println(x.getNumDiscountsToUse());
        System.out.println(x.getTotalAmountSpent());

        x.makePurchase(100);
        System.out.println(x.getNumDiscountsToUse());
        System.out.println(x.getTotalAmountSpent());
    }
}
