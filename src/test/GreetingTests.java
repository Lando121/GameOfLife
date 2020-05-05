
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import app.*;
public class GreetingTests {
    @Test
    public void testGreeting() {
        assertEquals(true, new Greeting().isEven(4));
        assertEquals(false, new Greeting().isEven(3));
    }
}
