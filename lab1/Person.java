package labs.lab1;
/**
 * Represents a person and their list of friends
 */
public class Person {
// ADD INSTANCE VARIABLES HERE
    /**
     * Creates a person with a given name and no friends in their list.
     *
     * @param name the first name of the person of interest
     */
    private String p_name;
    private String friends_list ;
    public Person(String name) {
        this.p_name = name;
        this.friends_list = "";

// FILL IN
    }
    /**
     * Retrieves the names of all of a person's friends.
     *
     * @return a string containing all of the names of a person's friends
     */
    public String getFriendNames() {

        return this.friends_list; // FIX ME
    }
    /**
     * Adds a person to the list of friends of this person.
     *
     * @param p the person whose name is to be added to the friend list
     */
    public void befriend(Person p) {
        this.friends_list += p.p_name + " ";
// FILL IN
    }
    /**
     * Removes a person from the list of friends of this person.
     *
     * @param p the person whose name is to be removed from the friend list
     */
    public void unfriend(Person p) {
// FILL IN
        String [] myarr = getFriendNames().split(" ");
        String [] result = new String[myarr.length];
        String x = "";
        int i = 0 ;

        for (String name : myarr){
            if (!name.equals(p.p_name)){
                result[i++] = name;
            }
        }
        for (int j =0  ; j < i; j ++){
            x += result[j] + " ";
        }

        this.friends_list = x;
    }
    /**
     * Returns the number of friends a person currently has.
     *
     * @return a count of the number of friends the person has
     */
    public int getFriendCount() {
        String [] myarr = getFriendNames().split(" ");
        return myarr.length;
    }
    public static void main(String[] args){
        Person individual = new Person("Robert");
        individual.befriend(new Person("Fido"));
        individual.befriend(new Person("Spot"));
        individual.befriend(new Person("Fluffy"));
        System.out.println("Friend List: " + individual.getFriendNames()); // Should print "Fido Spot Fluffy"
        System.out.println("Num friends: " + individual.getFriendCount()); // Should print 3
        individual.befriend(new Person("Sunny"));
        individual.befriend(new Person("Max"));
        individual.unfriend(new Person("Spot"));
        System.out.println("Friend List: " + individual.getFriendNames()); // Should print "Fido Fluffy Sunny Max"
        System.out.println("Num friends: " + individual.getFriendCount()); // Should print 4
    }
}