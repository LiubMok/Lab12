import atm.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestATM {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @Test
    public void testATM(){
        Handler handler1 = new Handler1();
        Handler handler5 = new Handler5();
        Handler handler20 = new Handler20();
        Handler handler50 = new Handler50();
        handler50.setNext(handler20);
        handler20.setNext(handler5);
        handler5.setNext(handler1);
        handler50.process(126);
        Assertions.assertEquals("2 * 50\r\n" +
                "1 * 20\r\n" +
                "1 * 5\r\n" +
                "1 * 1\r\n", outContent.toString() );
    }
}