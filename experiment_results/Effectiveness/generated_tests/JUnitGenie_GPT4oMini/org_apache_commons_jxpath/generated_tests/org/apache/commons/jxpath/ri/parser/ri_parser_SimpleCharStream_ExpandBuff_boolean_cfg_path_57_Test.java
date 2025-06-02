package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_57_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0, 0);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set up the initial state
            charStream.bufsize = 1024; // Set initial buffer size
            charStream.tokenBegin = 0; // Set token begin
            charStream.bufpos = 0; // Set buffer position
            charStream.buffer = new char[charStream.bufsize]; // Initialize buffer
            charStream.bufline = new int[charStream.bufsize]; // Initialize bufline
            charStream.bufcolumn = new int[charStream.bufsize]; // Initialize bufcolumn

            // Call the method with wrapAround = true
            method.invoke(charStream, true);

            // Verify the state after method execution
            assertNotNull(charStream.buffer);
            assertNotNull(charStream.bufline);
            assertNotNull(charStream.bufcolumn);
        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 0, 0);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set up the initial state
            charStream.bufsize = 1024; // Set initial buffer size
            charStream.tokenBegin = 0; // Set token begin
            charStream.bufpos = 0; // Set buffer position
            charStream.buffer = new char[charStream.bufsize]; // Initialize buffer
            charStream.bufline = new int[charStream.bufsize]; // Initialize bufline
            charStream.bufcolumn = new int[charStream.bufsize]; // Initialize bufcolumn

            // Call the method with wrapAround = false
            method.invoke(charStream, false);

            // Verify the state after method execution
            assertNotNull(charStream.buffer);
            assertNotNull(charStream.bufline);
            assertNotNull(charStream.bufcolumn);
        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

}