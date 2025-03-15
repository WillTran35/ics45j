package labs.lab4;

import java.util.Objects;

/**
 * Simulates a login form you would find on many web pages
 */
public class LoginForm {
// ADD YOUR INSTANCE VARIABLES HERE
    /**
     * Constructor
     *
     * @param expectedUsername the expected username
     * @param expectedPassword the expected password
     */
    private String expectedUsername;
    private String expectedPassword;
    private String username ;
    private String password;
    public LoginForm(String expectedUsername, String expectedPassword) {
// FILL IN
        this.expectedPassword = expectedPassword;
        this.expectedUsername = expectedUsername;
        this.username = "";
        this.password = "";
    }
    /**
     * Adds input to the form according to the following rules: Uses the input
     text
     * to fill in username if username hasn't been filled in yet Uses the input
     text
     * to fill in password if password hasn't been filled in yet Ignores the
     input
     * text if both username and password have been filled in
     *
     * @param text the input text
     */
    public void input(String text) {
// FILL IN
        if (username.isEmpty()){
            username = text;
        }
        else if (password.isEmpty()){
            password = text;
        }

    }
    /**
     * "Clicks" the button in the form with the given name.
     *
     * If button == "Submit", this submits the form; if button == "Reset", this
     resets the
     * form (the values for username and password); If button == any other value,
     does
     * nothing.
     *
     * @param button name of the button to click
     */
    public void click(String button) {
// FILL IN
        if (button.equals("Submit")){

        }
        else if (button.equals("Reset")){
            username = "";
            password = "";
        }
    }
    /**
     * Returns whether or not the user is logged in
     *
     * @return whether or not the user is logged in
     */
    public boolean isLoggedIn() {
        if (username.equals(expectedUsername) && password.equals(expectedPassword)){
            return true;
        }
        else{
            click("Reset");
        }
        return false;
    }

    public static void main (String [] args){
        LoginForm login = new LoginForm("admin", "admin123");
        login.input("test");
        login.input("test123");
        login.click("Submit");
        System.out.println(login.isLoggedIn()); // returns false
        login.input("admin");
        login.input("admin123");
        login.click("Reset");
        System.out.println(login.isLoggedIn());// returns false
        login.click("Submit");
        System.out.println(login.isLoggedIn());// returns false
        login.input("admin");
        login.input("admin123");
        login.input("test");
        login.input("test123");
        login.click("Submit");
        System.out.println(login.isLoggedIn());// returns true
        login.input("test");
        login.input("test123");
        login.click("Submit");
        System.out.println(login.isLoggedIn());// returns true
    }
}
