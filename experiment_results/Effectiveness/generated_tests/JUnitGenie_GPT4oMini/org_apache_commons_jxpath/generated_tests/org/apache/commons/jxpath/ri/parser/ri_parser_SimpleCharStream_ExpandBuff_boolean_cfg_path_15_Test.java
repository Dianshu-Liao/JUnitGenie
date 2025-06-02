package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0);

            // Set up the necessary fields for the test
            charStream.bufsize = 1024; // Initial buffer size
            charStream.tokenBegin = 0; // Initial token begin
            charStream.buffer = new char[1024]; // Initialize buffer
            charStream.bufline = new int[1024]; // Initialize bufline
            charStream.bufcolumn = new int[1024]; // Initialize bufcolumn

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Invoke the method with wrapAround set to true
            method.invoke(charStream, true);

            // Assertions to verify the expected state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(1024 + 2048, charStream.bufsize);
            assertEquals(0, charStream.tokenBegin);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0);

            // Set up the necessary fields for the test
            charStream.bufsize = 1024; // Initial buffer size
            charStream.tokenBegin = 0; // Initial token begin
            charStream.buffer = new char[1024]; // Initialize buffer
            charStream.bufline = new int[1024]; // Initialize bufline
            charStream.bufcolumn = new int[1024]; // Initialize bufcolumn

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Invoke the method with wrapAround set to false
            method.invoke(charStream, false);

            // Assertions to verify the expected state after method execution
            assertNotNull(charStream.buffer);
            assertEquals(1024 + 2048, charStream.bufsize);
            assertEquals(0, charStream.tokenBegin);
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}