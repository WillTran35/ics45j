package labs.lab2;
/**
 * Computes the date of Easter Sunday in a given year
 */
public class Easter {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructs the date of Easter Sunday.
     */
//    Divide c by 4 to get quotient j and remainder k.
//Divide a + 11 * h by 319 to get quotient m. Ignore the remainder.
//Divide 2 * e + 2 * j - k - h + m + 32 by 7 to get remainder r. Ignore the quotient.
//Divide h - m + r + 90 by 25 to get quotient n. Ignore the remainder.
//Divide h - m + r + n + 19 by 32 to get remainder p. Ignore the quotient.
//Then Easter falls on day p of month n. For example, if y is 2001:
    private int a, b, c, d, e, g, h, j , k , m, r, n ,p ;
    public Easter(int year) {
        this.a = year % 19;
        this.b = year /100 ;
        this.c = year % 100;
        this.d = this.b / 4;
        this.e = (this.b % 4) ;
        this.g = (8 * this.b + 13) /25;
        this.h = (19 * this.a + this.b - this.d - this.g +15 ) % 30;
        this.j = this.c / 4;
        this.k = this.c % 4;
        this.m = (this.a + 11 * this.h) / 319;
        this.r = (2 * this.e + 2 * this.j - this.k - this.h + this.m + 32) % 7;
        this.n = (this.h - this.m + this.r + 90) / 25;
        this.p = (this.h - this.m + this.r + this.n + 19) % 32;

    }
    /**
     * Gets the month of Easter Sunday
     *
     * @return month of Easter Sunday
     */
    public int getMonth() {
        return this.n; // FIX ME
    }
    /**
     * Gets the date of Easter Sunday
     *
     * @return date of Easter Sunday
     */
    public int getDay() {
        return this.p; // FIX ME
    }

    public static void main (String [] args){
        Easter x = new Easter(2022);
        System.out.println(x.getDay());
        System.out.println(x.getMonth());
    }
}
