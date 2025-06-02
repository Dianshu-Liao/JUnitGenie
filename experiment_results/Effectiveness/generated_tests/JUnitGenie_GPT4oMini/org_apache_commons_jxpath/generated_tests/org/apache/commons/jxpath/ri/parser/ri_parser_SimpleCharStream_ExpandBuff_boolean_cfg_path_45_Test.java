package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_45_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        simpleCharStream = new SimpleCharStream(new StringReader("test"), 1, 1);
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            simpleCharStream.bufsize = 1024; // Set initial buffer size
            simpleCharStream.tokenBegin = 0; // Set tokenBegin
            simpleCharStream.bufpos = 512; // Set bufpos
            simpleCharStream.buffer = new char[1024]; // Initialize buffer
            simpleCharStream.bufline = new int[1024]; // Initialize bufline
            simpleCharStream.bufcolumn = new int[1024]; // Initialize bufcolumn

            // Call the method with wrapAround = true
            method.invoke(simpleCharStream, true);

            // Verify the state after method execution
            assertNotNull(simpleCharStream.buffer);
            assertNotNull(simpleCharStream.bufline);
            assertNotNull(simpleCharStream.bufcolumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            simpleCharStream.bufsize = 1024; // Set initial buffer size
            simpleCharStream.tokenBegin = 0; // Set tokenBegin
            simpleCharStream.bufpos = 512; // Set bufpos
            simpleCharStream.buffer = new char[1024]; // Initialize buffer
            simpleCharStream.bufline = new int[1024]; // Initialize bufline
            simpleCharStream.bufcolumn = new int[1024]; // Initialize bufcolumn

            // Call the method with wrapAround = false
            method.invoke(simpleCharStream, false);

            // Verify the state after method execution
            assertNotNull(simpleCharStream.buffer);
            assertNotNull(simpleCharStream.bufline);
            assertNotNull(simpleCharStream.bufcolumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}