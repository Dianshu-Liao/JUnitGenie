package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_41_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        // Initialize SimpleCharStream with a StringReader and buffer sizes
        simpleCharStream = new SimpleCharStream(new StringReader("test"), 1, 1);
    }

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        // Set up the fields directly (simulating a state before the test)
        try {
            // Set bufsize and bufpos for the test
            simpleCharStream.getClass().getDeclaredField("bufsize").setInt(simpleCharStream, 1024);
            simpleCharStream.getClass().getDeclaredField("bufpos").setInt(simpleCharStream, 512);
            simpleCharStream.getClass().getDeclaredField("tokenBegin").setInt(simpleCharStream, 0);
            simpleCharStream.getClass().getDeclaredField("buffer").set(simpleCharStream, new char[1024]);
            simpleCharStream.getClass().getDeclaredField("bufline").set(simpleCharStream, new int[1024]);
            simpleCharStream.getClass().getDeclaredField("bufcolumn").set(simpleCharStream, new int[1024]);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(simpleCharStream, true);

            // Check the state of bufsize after expansion
            int newBufsize = (int) simpleCharStream.getClass().getDeclaredField("bufsize").get(simpleCharStream);
            assertEquals(1024 + 2048, newBufsize);
        } catch (Exception e) {
            throw new Error("Test failed: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffNoWrap() {
        try {
            // Set up same state as earlier
            simpleCharStream.getClass().getDeclaredField("bufsize").setInt(simpleCharStream, 1024);
            simpleCharStream.getClass().getDeclaredField("bufpos").setInt(simpleCharStream, 512);
            simpleCharStream.getClass().getDeclaredField("tokenBegin").setInt(simpleCharStream, 0);
            simpleCharStream.getClass().getDeclaredField("buffer").set(simpleCharStream, new char[1024]);
            simpleCharStream.getClass().getDeclaredField("bufline").set(simpleCharStream, new int[1024]);
            simpleCharStream.getClass().getDeclaredField("bufcolumn").set(simpleCharStream, new int[1024]);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(simpleCharStream, false);

            // Check the state of bufsize after expansion
            int newBufsize = (int) simpleCharStream.getClass().getDeclaredField("bufsize").get(simpleCharStream);
            assertEquals(1024 + 2048, newBufsize);
        } catch (Exception e) {
            throw new Error("Test failed: " + e.getMessage());
        }
    }

}