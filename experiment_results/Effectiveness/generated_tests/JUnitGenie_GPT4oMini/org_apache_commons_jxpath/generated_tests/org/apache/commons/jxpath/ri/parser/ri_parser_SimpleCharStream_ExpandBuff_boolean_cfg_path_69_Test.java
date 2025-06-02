package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_69_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Set the necessary fields for the test
            setField(stream, "bufsize", 1024);
            setField(stream, "tokenBegin", 0);
            setField(stream, "buffer", new char[1024]);

            // Invoke the protected method ExpandBuff with wrapAround = true
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true);

            // Add assertions to verify the expected state after the method call
            assertNotNull(getField(stream, "buffer"));
            assertEquals(1224, getField(stream, "bufsize"));
            assertEquals(0, getField(stream, "tokenBegin"));

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Set the necessary fields for the test
            setField(stream, "bufsize", 1024);
            setField(stream, "tokenBegin", 0);
            setField(stream, "buffer", new char[1024]);

            // Invoke the protected method ExpandBuff with wrapAround = false
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false);

            // Add assertions to verify the expected state after the method call
            assertNotNull(getField(stream, "buffer"));
            assertEquals(1224, getField(stream, "bufsize"));
            assertEquals(0, getField(stream, "tokenBegin"));

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    private Object getField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

}