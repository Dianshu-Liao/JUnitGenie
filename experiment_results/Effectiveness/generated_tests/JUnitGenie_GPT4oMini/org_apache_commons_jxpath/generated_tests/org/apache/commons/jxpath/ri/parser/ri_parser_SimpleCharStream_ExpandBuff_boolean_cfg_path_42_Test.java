package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_42_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Arrange
            Reader input = new InputStreamReader(new ByteArrayInputStream("Sample Input".getBytes()));
            SimpleCharStream stream = new SimpleCharStream(input, 1, 1, 1);
            int initialBufSize = stream.bufsize;
            stream.bufpos = 1;  // Setting bufpos to a value to test the functionality
            stream.tokenBegin = 0;  // Setting tokenBegin for the wrapAround case
            stream.buffer = new char[initialBufSize];
            stream.bufline = new int[initialBufSize];
            stream.bufcolumn = new int[initialBufSize];

            // Act
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true);  // wrapAround = true

            // Assert
            assertNotNull(stream.buffer);
            assertNotNull(stream.bufline);
            assertNotNull(stream.bufcolumn);
            // Additional assertions can be made based on expected outcomes e.g., sizes or contents

        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Arrange
            Reader input = new InputStreamReader(new ByteArrayInputStream("Sample Input".getBytes()));
            SimpleCharStream stream = new SimpleCharStream(input, 1, 1, 1);
            int initialBufSize = stream.bufsize;
            stream.bufpos = 1;  // Setting bufpos to a value to test the functionality
            stream.tokenBegin = 0;  // Setting tokenBegin for the non-wrapAround case
            stream.buffer = new char[initialBufSize];
            stream.bufline = new int[initialBufSize];
            stream.bufcolumn = new int[initialBufSize];

            // Act
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false);  // wrapAround = false

            // Assert
            assertNotNull(stream.buffer);
            assertNotNull(stream.bufline);
            assertNotNull(stream.bufcolumn);
            // Additional assertions can be made based on expected outcomes e.g., sizes or contents

        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

}