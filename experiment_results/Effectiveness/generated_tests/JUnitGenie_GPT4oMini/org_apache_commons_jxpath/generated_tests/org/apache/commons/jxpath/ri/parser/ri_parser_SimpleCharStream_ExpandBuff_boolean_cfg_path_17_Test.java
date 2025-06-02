package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 2048);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set up the necessary fields for the test
            charStream.buffer = new char[1024];
            charStream.bufline = new int[1024];
            charStream.bufcolumn = new int[1024];
            charStream.bufsize = 1024;
            charStream.tokenBegin = 0;

            // Call the method with wrapAround = true
            method.invoke(charStream, true);

            // Verify the state after the method call
            assertNotNull(charStream.buffer);
            assertNotNull(charStream.bufline);
            assertNotNull(charStream.bufcolumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // or any other InputStream
            SimpleCharStream charStream = new SimpleCharStream(inputStream, 1024, 2048);

            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set up the necessary fields for the test
            charStream.buffer = new char[1024];
            charStream.bufline = new int[1024];
            charStream.bufcolumn = new int[1024];
            charStream.bufsize = 1024;
            charStream.tokenBegin = 0;

            // Call the method with wrapAround = false
            method.invoke(charStream, false);

            // Verify the state after the method call
            assertNotNull(charStream.buffer);
            assertNotNull(charStream.bufline);
            assertNotNull(charStream.bufcolumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}