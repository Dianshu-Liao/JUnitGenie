package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_44_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        // Initialize the SimpleCharStream with a Reader and buffer sizes
        simpleCharStream = new SimpleCharStream(new InputStream() {
            @Override
            public int read() {
                return -1; // End of stream
            }
        }, 10, 10, 10);
    }

    @Test(timeout = 4000)
    public void testExpandBuffWrapAround() {
        try {
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set initial conditions
            simpleCharStream.bufsize = 10; // Initial buffer size
            simpleCharStream.tokenBegin = 0; // Initial token begin
            simpleCharStream.bufpos = 5; // Current position in buffer
            simpleCharStream.buffer = new char[10]; // Initialize buffer
            simpleCharStream.bufline = new int[10]; // Initialize bufline
            simpleCharStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the method with wrapAround = true
            method.invoke(simpleCharStream, true);

            // Validate the expected state after the method call
            assertEquals(2048 + 10, simpleCharStream.bufsize);
            assertEquals(0, simpleCharStream.tokenBegin);
            assertEquals(10, simpleCharStream.bufpos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffNoWrapAround() {
        try {
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);

            // Set initial conditions
            simpleCharStream.bufsize = 10; // Initial buffer size
            simpleCharStream.tokenBegin = 5; // Initial token begin
            simpleCharStream.bufpos = 5; // Current position in buffer
            simpleCharStream.buffer = new char[10]; // Initialize buffer
            simpleCharStream.bufline = new int[10]; // Initialize bufline
            simpleCharStream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Call the method with wrapAround = false
            method.invoke(simpleCharStream, false);

            // Validate the expected state after the method call
            assertEquals(2048 + 10, simpleCharStream.bufsize);
            assertEquals(0, simpleCharStream.tokenBegin);
            assertEquals(0, simpleCharStream.bufpos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}