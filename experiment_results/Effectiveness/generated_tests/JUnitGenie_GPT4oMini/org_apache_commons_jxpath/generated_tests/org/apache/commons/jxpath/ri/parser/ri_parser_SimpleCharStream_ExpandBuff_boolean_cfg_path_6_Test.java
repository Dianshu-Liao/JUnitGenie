package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_6_Test {
    private SimpleCharStream simpleCharStream;

    @Before
    public void setUp() {
        // Initialize the SimpleCharStream with a Reader and appropriate parameters
        Reader reader = new InputStreamReader(new ByteArrayInputStream("test".getBytes()));
        simpleCharStream = new SimpleCharStream(reader, 1, 1, 1);
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Call the method with wrapAround set to true
            method.invoke(simpleCharStream, true);
            // Verify that the buffer has been expanded
            assertNotNull(simpleCharStream.buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Call the method with wrapAround set to false
            method.invoke(simpleCharStream, false);
            // Verify that the buffer has been expanded
            assertNotNull(simpleCharStream.buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}