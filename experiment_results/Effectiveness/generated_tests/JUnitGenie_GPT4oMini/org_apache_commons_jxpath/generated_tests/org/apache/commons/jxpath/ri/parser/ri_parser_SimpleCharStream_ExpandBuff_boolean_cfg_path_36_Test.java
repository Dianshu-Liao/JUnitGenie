package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_36_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream((InputStream) null, 0, 0, 0);
            // Initialize the buffer and other fields for testing
            stream.bufsize = 1024; // Set initial buffer size
            stream.buffer = new char[stream.bufsize];
            stream.tokenBegin = 0;
            stream.bufpos = 512; // Set current position in buffer
            stream.bufline = new int[stream.bufsize];
            stream.bufcolumn = new int[stream.bufsize];

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true); // Call with wrapAround = true

            // Validate the state after calling ExpandBuff
            assertEquals(1024 + 2048, stream.bufsize); // Check new buffer size
            assertEquals(0, stream.tokenBegin); // Check tokenBegin reset
            // Additional assertions can be added to check buffer contents if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffNoWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream((InputStream) null, 0, 0, 0);
            // Initialize the buffer and other fields for testing
            stream.bufsize = 1024; // Set initial buffer size
            stream.buffer = new char[stream.bufsize];
            stream.tokenBegin = 0;
            stream.bufpos = 512; // Set current position in buffer
            stream.bufline = new int[stream.bufsize];
            stream.bufcolumn = new int[stream.bufsize];

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false); // Call with wrapAround = false

            // Validate the state after calling ExpandBuff
            assertEquals(1024 + 2048, stream.bufsize); // Check new buffer size
            assertEquals(0, stream.tokenBegin); // Check tokenBegin reset
            // Additional assertions can be added to check buffer contents if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}