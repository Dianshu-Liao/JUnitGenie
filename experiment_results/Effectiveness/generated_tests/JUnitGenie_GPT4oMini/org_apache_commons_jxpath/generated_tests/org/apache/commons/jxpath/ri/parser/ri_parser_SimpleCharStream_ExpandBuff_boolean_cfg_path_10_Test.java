package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // Using System.in for demonstration
            SimpleCharStream stream = new SimpleCharStream(inputStream, 2048, 0, 0);

            // Set up the internal state for testing
            stream.bufsize = 2048; // Initial buffer size
            stream.buffer = new char[2048];
            stream.tokenBegin = 0;
            stream.bufpos = 0;

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true); // Test with wrapAround = true

            // Validate the state after method execution
            assertEquals(4096, stream.bufsize); // bufsize should increase by 2048
            assertEquals(0, stream.tokenBegin); // tokenBegin should reset to 0
            assertEquals(2048, stream.bufpos); // bufpos should be updated accordingly

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // Using System.in for demonstration
            SimpleCharStream stream = new SimpleCharStream(inputStream, 2048, 0, 0);

            // Set up the internal state for testing
            stream.bufsize = 2048; // Initial buffer size
            stream.buffer = new char[2048];
            stream.tokenBegin = 0;
            stream.bufpos = 2048; // Set bufpos to the end of the buffer

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false); // Test with wrapAround = false

            // Validate the state after method execution
            assertEquals(4096, stream.bufsize); // bufsize should increase by 2048
            assertEquals(0, stream.tokenBegin); // tokenBegin should reset to 0
            assertEquals(0, stream.bufpos); // bufpos should be updated accordingly

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}