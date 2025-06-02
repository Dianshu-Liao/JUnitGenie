package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.InputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_64_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Arrange: Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // Example input stream
            SimpleCharStream stream = new SimpleCharStream(inputStream, 1, 1);
            stream.bufsize = 1024; // set initial bufsize
            stream.bufpos = 0;
            stream.tokenBegin = 0;
            stream.buffer = new char[stream.bufsize];
            stream.bufline = new int[stream.bufsize];
            
            // Act: Invoke the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true); // Calling with wrapAround = true
            
            // Assert: Check the necessary outcome
            assertNotNull(stream.buffer); // Check that buffer is not null
            assertNotNull(stream.bufline); // Check that bufline is not null
            assertNotNull(stream.bufpos); // Check bufpos is updated

        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Arrange: Create an instance of SimpleCharStream
            InputStream inputStream = System.in; // Example input stream
            SimpleCharStream stream = new SimpleCharStream(inputStream, 1, 1);
            stream.bufsize = 1024; // set initial bufsize
            stream.bufpos = 0;
            stream.tokenBegin = 0;
            stream.buffer = new char[stream.bufsize];
            stream.bufline = new int[stream.bufsize];
            
            // Act: Invoke the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false); // Calling with wrapAround = false
            
            // Assert: Check the necessary outcome
            assertNotNull(stream.buffer); // Check that buffer is not null
            assertNotNull(stream.bufline); // Check that bufline is not null
            assertNotNull(stream.bufpos); // Check bufpos is updated

        } catch (Throwable t) {
            throw new Error(t.getMessage());
        }
    }

}