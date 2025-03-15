package labs.lab2;
/*
 * A tax bill defined by one's marital status and taxable income
 */
public class TaxBill {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructor
     *
     * @param married whether married or not
     * @param income taxable yearly income
     */
    private boolean married ;
    private double income;

    public TaxBill(boolean married, double income) {
// FILL IN
        this.married = married;
        this.income = income;
    }
    /**
     * Calculates amount of tax due
     *
     * @return amount of tax due
     */
    public double getAmountDue() {
        if (married && income > 0 && income <= 16000){
            return income * 0.1;
            //tax is 10%
        }
        else if (married && income > 16000 && income <= 64000){
            //tax is 1600 + 15%
            return 1600 + ((income - 16000) * 0.15);
        }
        else if (married && income > 64000){
            //tax is 8800 + 25%
            return 8800 + ((income - 64000) * 0.25);
        }
        else if (!married && income > 0 && income <= 8000){
            //tax is 10%
            return income * 0.1;
        }
        else if (!married && income > 8000 && income <= 32000){
            //tax is 800 + 15%
            return 800 + (income-8000) * 0.15;
        }
        else if (!married && income > 32000){
            //tax is 4400 + 25%
            return 4400 + (income - 32000) * 0.25;
        }
        return 0;
    }
    public static void main (String [] args){
        TaxBill bill1 = new TaxBill(false, 65536);
        System.out.println("Tax amount for bill1: " + bill1.getAmountDue()); // Output: 12784.0

        TaxBill bill2 = new TaxBill(true, 13553);
        System.out.println("Tax amount for bill2: " + bill2.getAmountDue()); // Output: 1355.3000000000002

        TaxBill bill3 = new TaxBill(false, 28001.22);
        System.out.println("Tax amount for bill3: " + bill3.getAmountDue()); // Output: 3800.183

    }
}
