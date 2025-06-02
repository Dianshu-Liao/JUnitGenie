package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_72_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Set initial values for the fields to ensure proper execution
            setFieldValue(stream, "tokenBegin", 0);
            setFieldValue(stream, "bufsize", 1024);
            setFieldValue(stream, "buffer", new char[1024]);
            // Invoke the method with wrapAround = true
            method.invoke(stream, true);
            // Assert that the buffer is not null after expansion
            assertNotNull(stream.buffer);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Access the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            // Set initial values for the fields to ensure proper execution
            setFieldValue(stream, "tokenBegin", 0);
            setFieldValue(stream, "bufsize", 1024);
            setFieldValue(stream, "buffer", new char[1024]);
            // Invoke the method with wrapAround = false
            method.invoke(stream, false);
            // Assert that the buffer is not null after expansion
            assertNotNull(stream.buffer);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    private void setFieldValue(SimpleCharStream stream, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = SimpleCharStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(stream, value);
    }

}