package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_66_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        simpleCharStream = new SimpleCharStream(new StringReader("initial buffer content"), 1, 1);
        simpleCharStream.bufpos = 0; // Initializing bufpos to allow modifications.
        simpleCharStream.tokenBegin = 0; // Initializing tokenBegin.
        simpleCharStream.bufsize = 4096; // Setting an initial buffer size.
        simpleCharStream.buffer = new char[simpleCharStream.bufsize]; // Allocating buffer
    }

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        try {
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            simpleCharStream.bufpos = 2048; // Set bufpos for testing
            simpleCharStream.tokenBegin = 1024; // Set tokenBegin
            simpleCharStream.ExpandBuff(true); // Call method with wrapAround = true

            // Test to see if bufsize increased correctly
            assertEquals(simpleCharStream.bufsize, 6144); // 4096 + 2048
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            simpleCharStream.bufpos = 2048; // Set bufpos for testing
            simpleCharStream.tokenBegin = 512; // Set tokenBegin
            simpleCharStream.ExpandBuff(false); // Call method with wrapAround = false

            // Test to see if bufsize increased correctly
            assertEquals(simpleCharStream.bufsize, 6144); // 4096 + 2048
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}