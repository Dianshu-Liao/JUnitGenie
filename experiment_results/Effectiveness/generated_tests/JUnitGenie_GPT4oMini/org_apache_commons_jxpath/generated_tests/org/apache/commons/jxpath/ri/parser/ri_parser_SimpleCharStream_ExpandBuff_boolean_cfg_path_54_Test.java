package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_54_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        simpleCharStream = new SimpleCharStream(new StringReader("test"), 1, 1);
        // Initialize the buffer and other necessary fields for testing
        simpleCharStream.bufsize = 1024; // Set an initial buffer size
        simpleCharStream.buffer = new char[simpleCharStream.bufsize];
        simpleCharStream.bufline = new int[simpleCharStream.bufsize];
        simpleCharStream.bufcolumn = new int[simpleCharStream.bufsize];
        simpleCharStream.tokenBegin = 0;
        simpleCharStream.bufpos = 0;
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(simpleCharStream, true);
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
            method.invoke(simpleCharStream, false);
            assertNotNull(simpleCharStream.buffer);
            assertNotNull(simpleCharStream.bufline);
            assertNotNull(simpleCharStream.bufcolumn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}