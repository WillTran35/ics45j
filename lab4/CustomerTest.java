package labs.lab4;
import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void testPurchaseLessThan100() {
        Customer x = new Customer ();
        x.makePurchase(75);
        assertEquals(75.0, x.getTotalAmountSpent(),0.01);
        assertEquals(0, x.getNumDiscountsToUse());
// FILL IN
    }
    @Test
    public void testPurchaseMoreThan100() {
        Customer x = new Customer ();
        x.makePurchase(175);
        assertEquals(175.0, x.getTotalAmountSpent(),0.01);
        assertEquals(1, x.getNumDiscountsToUse());
// FILL IN
    }
    @Test
    public void testDiscountApplied() {
        Customer x = new Customer ();
        x.makePurchase(175);
        assertEquals(175.0, x.getTotalAmountSpent(),0.01);
        assertEquals(1, x.getNumDiscountsToUse());
        x.makePurchase(100);
        assertEquals(265.0, x.getTotalAmountSpent(),0.01); // only added 90% of new purchase
        assertEquals(1, x.getNumDiscountsToUse());
// FILL IN
    }
    @Test
    public void testPurchaseEarningMultipleDiscounts() {
        Customer x = new Customer ();
        x.makePurchase(90);
        assertEquals(90.0, x.getTotalAmountSpent(),0.01);
        assertEquals(0, x.getNumDiscountsToUse());
        x.makePurchase(300);
        assertEquals(390.0, x.getTotalAmountSpent(),0.01);
        assertEquals(3, x.getNumDiscountsToUse());
// FILL IN

    }
    @Test
    public void testOnlyOneDiscountApplied() {
// FILL IN
        Customer x = new Customer ();
        x.makePurchase(300);
        assertEquals(300.0, x.getTotalAmountSpent(), 0.01);
        assertEquals(3, x.getNumDiscountsToUse());
        x.makePurchase(100);
        assertEquals(390.0, x.getTotalAmountSpent(), 0.01); // only 1 discount applied
        assertEquals(2, x.getNumDiscountsToUse());
    }
}
