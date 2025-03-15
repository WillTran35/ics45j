package labs.lab1;
/**
 * Produces customized greetings, based on your name
 *
 */
public class Greeter {
// ADD YOUR INSTANCE VARIABLES HERE
    private String myname;
    /**
     * Creates a Greeter based on the provided name
     *
     * @param name name of person to greet
     */
    public Greeter(String name) {
// FILL IN
        this.myname = name;

    }
    /**
     * Returns a greeting message ("Hello, [name]")
     *
     * @return the greeting
     */
    public String sayHello() {
        String result = "Hello, ";
        result += this.myname;
        return result; // FIX ME
    }
    /**
     * Returns a farewell message ("Goodbye, [name]")
     *
     * @return the farewell message
     */
    public String sayGoodbye() {
        String result = "Goodbye, ";
        result += this.myname;
        return result;
    }
//    public static void main(String[] args){
//        Greeter mine = new Greeter("Will");
//        System.out.println(mine.sayGoodbye());
//        System.out.println(mine.sayHello());
//    }
}
