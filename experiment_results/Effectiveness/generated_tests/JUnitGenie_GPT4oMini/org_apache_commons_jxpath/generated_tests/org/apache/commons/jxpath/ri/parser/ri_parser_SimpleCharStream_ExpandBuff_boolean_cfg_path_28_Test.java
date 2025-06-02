package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_ExpandBuff_boolean_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testExpandBuffWithWrapAround() {
        try {
            // Setup
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test input"), 0, 0, 0);
            // Set initial values for the protected fields using reflection
            setFieldValue(stream, "bufsize", 10);
            setFieldValue(stream, "tokenBegin", 0);
            setFieldValue(stream, "buffer", new char[10]);
            setFieldValue(stream, "buffer", "abcdefghij".toCharArray());

            // Invoke the method under test
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, true);

            // Verify the expected state after method execution
            int newSize = (int) getFieldValue(stream, "bufsize");
            assertEquals(10 + 2048, newSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testExpandBuffWithoutWrapAround() {
        try {
            // Setup
            SimpleCharStream stream = new SimpleCharStream(new StringReader("test input"), 0, 0, 0);
            // Set initial values for the protected fields using reflection
            setFieldValue(stream, "bufsize", 10);
            setFieldValue(stream, "tokenBegin", 0);
            setFieldValue(stream, "buffer", new char[10]);
            setFieldValue(stream, "buffer", "abcdefghij".toCharArray());

            // Invoke the method under test
            Method method = SimpleCharStream.class.getDeclaredMethod("ExpandBuff", boolean.class);
            method.setAccessible(true);
            method.invoke(stream, false);

            // Verify the expected state after method execution
            int newSize = (int) getFieldValue(stream, "bufsize");
            assertEquals(10 + 2048, newSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFieldValue(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

}