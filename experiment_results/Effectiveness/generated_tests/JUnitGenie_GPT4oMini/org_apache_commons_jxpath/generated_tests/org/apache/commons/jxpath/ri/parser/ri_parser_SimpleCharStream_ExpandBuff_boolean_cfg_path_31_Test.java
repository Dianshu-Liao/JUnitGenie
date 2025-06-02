package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Setup
            InputStream inputStream = System.in; // or any valid InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 10, 10, 10);
            charStream.bufsize = 10; // Set initial bufsize
            charStream.tokenBegin = 0; // Set tokenBegin
            charStream.bufpos = 5; // Set bufpos
            charStream.buffer = new char[10]; // Initialize buffer
            charStream.bufline = new int[10]; // Initialize bufline
            charStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, true); // Call with wrapAround = true

            // Assertions to verify the state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(12, charStream.bufsize); // bufsize should increase by 2048
            assertEquals(10, charStream.available); // available should be updated
            assertEquals(10, charStream.tokenBegin); // tokenBegin should reset to 0
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
            charStream.bufsize = 10; // Set initial bufsize
            charStream.tokenBegin = 5; // Set tokenBegin
            charStream.bufpos = 10; // Set bufpos
            charStream.buffer = new char[10]; // Initialize buffer
            charStream.bufline = new int[10]; // Initialize bufline
            charStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, false); // Call with wrapAround = false

            // Assertions to verify the state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(12, charStream.bufsize); // bufsize should increase by 2048
            assertEquals(5, charStream.tokenBegin); // tokenBegin should remain unchanged
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

}