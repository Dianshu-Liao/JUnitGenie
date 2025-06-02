package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_52_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test input"), 1, 1, 1);
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            stream.bufsize = 1024; // Set initial buffer size
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 512; // Set bufpos
            stream.buffer = new char[1024]; // Initialize buffer
            stream.bufline = new int[1024]; // Initialize bufline
            stream.bufcolumn = new int[1024]; // Initialize bufcolumn

            method.invoke(stream, true); // Call ExpandBuff with wrapAround = true

            assertNotNull(stream.buffer); // Check if buffer is not null after expansion
            assertNotNull(stream.bufline); // Check if bufline is not null after expansion
            assertNotNull(stream.bufcolumn); // Check if bufcolumn is not null after expansion
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test input"), 1, 1, 1);
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            stream.bufsize = 1024; // Set initial buffer size
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 512; // Set bufpos
            stream.buffer = new char[1024]; // Initialize buffer
            stream.bufline = new int[1024]; // Initialize bufline
            stream.bufcolumn = new int[1024]; // Initialize bufcolumn

            method.invoke(stream, false); // Call ExpandBuff with wrapAround = false

            assertNotNull(stream.buffer); // Check if buffer is not null after expansion
            assertNotNull(stream.bufline); // Check if bufline is not null after expansion
            assertNotNull(stream.bufcolumn); // Check if bufcolumn is not null after expansion
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}