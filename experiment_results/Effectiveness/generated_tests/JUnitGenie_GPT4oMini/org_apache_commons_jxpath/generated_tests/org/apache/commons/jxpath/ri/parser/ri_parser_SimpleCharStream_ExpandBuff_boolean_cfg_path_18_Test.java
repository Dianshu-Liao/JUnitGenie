package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Setup
            InputStream inputStream = System.in; // or any valid InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 10, 10, 10);
            // Set up the internal state to test the method
            charStream.buffer = new char[10];
            charStream.bufline = new int[10];
            charStream.tokenBegin = 0;
            charStream.bufsize = 10;

            // Invoke the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, true); // Test with wrapAround = true

            // Assertions to verify the expected state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(12, charStream.bufsize); // bufsize should increase by 2048
            assertEquals(0, charStream.tokenBegin); // tokenBegin should remain 0

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Setup
            InputStream inputStream = System.in; // or any valid InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 10, 10, 10);
            // Set up the internal state to test the method
            charStream.buffer = new char[10];
            charStream.bufline = new int[10];
            charStream.tokenBegin = 5; // Set tokenBegin to a non-zero value
            charStream.bufsize = 10;

            // Invoke the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, false); // Test with wrapAround = false

            // Assertions to verify the expected state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(12, charStream.bufsize); // bufsize should increase by 2048
            assertEquals(5, charStream.tokenBegin); // tokenBegin should remain 5

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}