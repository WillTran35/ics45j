package labs.lab3;
import java.time.LocalDate;
/**
 * Represents a credit card
 *
 */
public class CreditCard {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructs a credit card object with the given number and expiration
     * date
     *
     * Assume the number passed in will always have 16 digits and will not
     * start with 0.
     *
     * Assume the date passed in will always be a valid date.
     *
     * @param number the credit card number
     * @param expDate the credit card expiration date
     */
    private long number;
    private LocalDate expDate;

    public CreditCard(long number, LocalDate expDate) {
        this.number = number;
        this.expDate = expDate;

// FILL IN
    }
    /**
     * Returns the credit card number
     *
     * @return the credit card number
     */
    public long getNumber() {
        return this.number; // FIX ME
    }
    /**
     * Returns the credit card expiration date
     *
     * @return the credit card expiration date
     */
    public LocalDate getExpirationDate() {
        return this.expDate; // FIX ME
    }
    /**
     * Returns a string containing the card number, with a space inserted
     * between every 4 digits
     *
     * @return the card number, with a space inserted between every 4 digits
     */
    public String getNumberWithSpaces() {
        String result = "";
        String numberString = Long.toString(number);
        int pos = 0 ;
        for (char ch : numberString.toCharArray()){
            if (pos % 4 == 0 && pos != 0 ){
                result += " ";
            }
            result += ch;
            pos ++;
        }
        return result; // FIX ME
    }
    /**
     * Returns true if both the card number and expiration date are valid,
     * false otherwise
     *
     * @return whether card is valid
     */
    public boolean isValid() {
        int sum  = 0 ;
        String numberString = Long.toString(number);
//        System.out.println(numberString) ;
        for (char ch : numberString.toCharArray()){
//            System.out.println(ch);
            sum += ch - '0';
//            System.out.println(sum);

        }
        for (int i = 1 ; i < numberString.length() ; i += 2){
            sum += numberString.charAt(i) - '0';
            if (numberString.charAt(i) - '0' > 5){
                sum ++;
            }
        }
//        System.out.println(sum);
        return sum % 3 == 0 && LocalDate.now().isBefore(expDate);
    }
    public static void main (String [] args){
        // Create first credit card object
        CreditCard cc1 = new CreditCard(4022888888881881L, LocalDate.of(2027, 2, 28));
        System.out.println("Credit Card 1 Number: " + cc1.getNumber());
        System.out.println("Credit Card 1 Expiration Date: " + cc1.getExpirationDate());
        System.out.println("Credit Card 1 Number with Spaces: " + cc1.getNumberWithSpaces());
        System.out.println("Credit Card 1 Validity: " + cc1.isValid());

// Create second credit card object
        CreditCard cc2 = new CreditCard(4022888888881881L, LocalDate.of(2021, 2, 28));
        System.out.println("Credit Card 2 Number: " + cc2.getNumber());
        System.out.println("Credit Card 2 Expiration Date: " + cc2.getExpirationDate());
        System.out.println("Credit Card 2 Number with Spaces: " + cc2.getNumberWithSpaces());
        System.out.println("Credit Card 2 Validity: " + cc2.isValid());

    }
}