package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_39_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        try {
            // Setup
            InputStream inputStream = System.in; // or any valid InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 10, 10, 10);
            charStream.bufsize = 10; // Set initial buffer size
            charStream.tokenBegin = 0; // Set tokenBegin
            charStream.bufpos = 5; // Set bufpos
            charStream.buffer = new char[10]; // Initialize buffer
            charStream.bufline = new int[10]; // Initialize bufline
            charStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, true); // Call with wrapAround = true

            // Verify the results
            assertEquals(2048 + 10, charStream.bufsize); // bufsize should increase
            assertEquals(0, charStream.tokenBegin); // tokenBegin should reset
            assertEquals(2048 + 5, charStream.bufpos); // bufpos should be updated

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffNoWrapAround() {
        try {
            // Setup
            InputStream inputStream = System.in; // or any valid InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 10, 10, 10);
            charStream.bufsize = 10; // Set initial buffer size
            charStream.tokenBegin = 5; // Set tokenBegin
            charStream.bufpos = 10; // Set bufpos
            charStream.buffer = new char[10]; // Initialize buffer
            charStream.bufline = new int[10]; // Initialize bufline
            charStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the protected method using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(charStream, false); // Call with wrapAround = false

            // Verify the results
            assertEquals(2048 + 10, charStream.bufsize); // bufsize should increase
            assertEquals(0, charStream.tokenBegin); // tokenBegin should reset
            assertEquals(5, charStream.bufpos); // bufpos should be updated

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}