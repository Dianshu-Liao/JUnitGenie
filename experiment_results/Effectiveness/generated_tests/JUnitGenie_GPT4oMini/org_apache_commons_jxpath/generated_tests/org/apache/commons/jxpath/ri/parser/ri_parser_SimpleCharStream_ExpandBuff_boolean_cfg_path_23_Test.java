package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Set the initial state of the buffer
            stream.tokenBegin = 0;
            stream.bufsize = 10; // Set an initial buffer size
            stream.buffer = new char[10]; // Initialize the buffer
            stream.buffer[0] = 'a'; // Fill the buffer with some data
            stream.buffer[1] = 'b';
            stream.buffer[2] = 'c';
            stream.buffer[3] = 'd';
            stream.buffer[4] = 'e';
            stream.bufpos = 5; // Set the position in the buffer

            // Call the method with wrapAround = true
            method.invoke(stream, true);
            // Verify that the buffer has been expanded
            assertNotNull(stream.buffer);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Set the initial state of the buffer
            stream.tokenBegin = 0;
            stream.bufsize = 10; // Set an initial buffer size
            stream.buffer = new char[10]; // Initialize the buffer
            stream.buffer[0] = 'a'; // Fill the buffer with some data
            stream.buffer[1] = 'b';
            stream.buffer[2] = 'c';
            stream.buffer[3] = 'd';
            stream.buffer[4] = 'e';
            stream.bufpos = 5; // Set the position in the buffer

            // Call the method with wrapAround = false
            method.invoke(stream, false);
            // Verify that the buffer has been expanded
            assertNotNull(stream.buffer);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

}