import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class userIDTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void redirectOut() {
    System.setOut(new PrintStream(out));
}

    @Test
    public void testAdmin() throws ClassNotFoundException, SQLException {
        String[] username = {"Admin"};
        userID.main(username);
        
        assertEquals("1", out.toString().trim());
    }

    @After
    public void cleanUpOut() {
        System.setOut(null);
    }
}
