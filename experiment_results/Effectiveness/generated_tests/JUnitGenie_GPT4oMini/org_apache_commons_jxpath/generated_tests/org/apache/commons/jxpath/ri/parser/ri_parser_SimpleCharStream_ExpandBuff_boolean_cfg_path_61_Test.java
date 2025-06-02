package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_61_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream((InputStream) null, 0, 0, 0);
            // Initialize the buffer and related fields
            stream.bufsize = 10; // Set initial buffer size
            stream.buffer = new char[10]; // Initialize buffer
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 5; // Set bufpos to a value less than bufsize

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true); // Call with wrapAround = true

            // Validate the state after method execution
            assertEquals(2048 + 10, stream.bufsize); // bufsize should increase
            assertEquals(5, stream.bufpos); // bufpos should remain unchanged
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream((InputStream) null, 0, 0, 0);
            // Initialize the buffer and related fields
            stream.bufsize = 10; // Set initial buffer size
            stream.buffer = new char[10]; // Initialize buffer
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 5; // Set bufpos to a value less than bufsize

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false); // Call with wrapAround = false

            // Validate the state after method execution
            assertEquals(2048 + 10, stream.bufsize); // bufsize should increase
            assertEquals(0, stream.bufpos); // bufpos should be reset to 0
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}