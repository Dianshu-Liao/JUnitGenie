package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Create an instance of SimpleCharStream
            SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("test"), 0, 0, 0);
            // Set the necessary fields to simulate the state before calling ExpandBuff
            setField(stream, "bufsize", 1024);
            setField(stream, "tokenBegin", 0);
            setField(stream, "buffer", new char[1024]);
            setField(stream, "bufcolumn", new int[1024]);
            setField(stream, "bufline", new int[1024]);

            // Call the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true);

            // Assertions to verify the expected state after calling ExpandBuff
            assertNotNull(getField(stream, "buffer"));
            assertEquals(1024 + 2048, getField(stream, "bufsize"));
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
            // Set the necessary fields to simulate the state before calling ExpandBuff
            setField(stream, "bufsize", 1024);
            setField(stream, "tokenBegin", 0);
            setField(stream, "buffer", new char[1024]);
            setField(stream, "bufcolumn", new int[1024]);
            setField(stream, "bufline", new int[1024]);

            // Call the protected method ExpandBuff using reflection
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false);

            // Assertions to verify the expected state after calling ExpandBuff
            assertNotNull(getField(stream, "buffer"));
            assertEquals(1024 + 2048, getField(stream, "bufsize"));
            assertEquals(0, getField(stream, "tokenBegin"));

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    private Object getField(SimpleCharStream stream, String fieldName) throws Exception {
        java.lang.reflect.Field field = SimpleCharStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(stream);
    }

    private void setField(SimpleCharStream stream, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = SimpleCharStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(stream, value);
    }

}