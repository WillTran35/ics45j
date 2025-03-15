package labs.lab4;
import static org.junit.Assert.*;
import org.junit.Test;
public class LoginFormTest {
    /**
     * Tests that a correct username + an incorrect password does not allow the
     user
     * to log in
     */
    @Test
    public void testCorrectUsernameIncorrectPassword() {
// FILL IN
        LoginForm x = new LoginForm("Will", "Will");
        x.input("Will");
        x.input("will");
        x.click("Submit");
        assertFalse(x.isLoggedIn());
    }
    /**
     * Tests that an incorrect username + a correct password does not allow the
     user
     * to log in
     */
    @Test
    public void testIncorrectUsernameCorrectPassword() {
// FILL IN
        LoginForm x = new LoginForm("Will", "Will");
        x.input("will");
        x.input("Will");
        x.click("Submit");
        assertFalse(x.isLoggedIn());
    }
    /**
     * Tests that providing correct username and password on first try allows the
     * user to log in
     */
    @Test
    public void testCorrectCredentialsFirstTry() {
// FILL IN
        LoginForm x = new LoginForm("Will", "Will");
        x.input("Will");
        x.input("Will");
        x.click("Submit");
        assertTrue(x.isLoggedIn());
    }
    /**
     * Tests that the following steps allow the user to log in: 1) Provide
     incorrect
     * credentials, 2) Submit 3) Provide correct credentials 4) Submit
     */

    @Test
    public void testIncorrectFirstCorrectSecond() {
// FILL IN
        LoginForm x = new LoginForm("Will", "Will");
        x.input("will");
        x.input("will");
        x.click("Submit");
        assertFalse(x.isLoggedIn());
        x.input("Will");
        x.input("Will");
        x.click("Submit");
        assertTrue(x.isLoggedIn());
    }
    /**
     * Tests that the user stays logged in after correct credentials are
     submitted,
     * even if incorrect credentials are then submitted: 1) Provide correct
     * credentials, 2) Submit 3) Provide incorrect credentials 4) Submit
     */

    @Test
    public void testCorrectFirstIncorrectSecond() {
// FILL IN
        LoginForm x = new LoginForm("Will", "Will");
        x.input("will");
        x.input("will");
        x.click("Submit");
        assertFalse(x.isLoggedIn());
        x.input("Will");
        x.input("Will");
        x.click("Submit");
        assertTrue(x.isLoggedIn());
        x.input("will");
        x.input("will");
        assertTrue(x.isLoggedIn());
    }
}
