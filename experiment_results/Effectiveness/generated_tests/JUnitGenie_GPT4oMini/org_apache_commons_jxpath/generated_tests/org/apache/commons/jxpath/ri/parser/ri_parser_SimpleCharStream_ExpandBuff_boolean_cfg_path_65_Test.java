package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_65_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Arrange
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test"), 1, 1, 1);
            // Initialize the buffer and other fields to simulate the state before calling ExpandBuff
            stream.bufsize = 10; // Set initial buffer size
            stream.buffer = new char[10]; // Initialize buffer
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 5; // Set bufpos
            stream.bufline = new int[10]; // Initialize bufline
            stream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Act
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true); // Call ExpandBuff with wrapAround = true

            // Assert
            assertNotNull(stream.buffer); // Check that buffer is not null after expansion
            assertNotNull(stream.bufline); // Check that bufline is not null after expansion
            assertNotNull(stream.bufcolumn); // Check that bufcolumn is not null after expansion
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Arrange
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test"), 1, 1, 1);
            // Initialize the buffer and other fields to simulate the state before calling ExpandBuff
            stream.bufsize = 10; // Set initial buffer size
            stream.buffer = new char[10]; // Initialize buffer
            stream.tokenBegin = 0; // Set tokenBegin
            stream.bufpos = 5; // Set bufpos
            stream.bufline = new int[10]; // Initialize bufline
            stream.bufcolumn = new int[10]; // Initialize bufcolumn

            // Act
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false); // Call ExpandBuff with wrapAround = false

            // Assert
            assertNotNull(stream.buffer); // Check that buffer is not null after expansion
            assertNotNull(stream.bufline); // Check that bufline is not null after expansion
            assertNotNull(stream.bufcolumn); // Check that bufcolumn is not null after expansion
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }
    }

}