package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class text_StrBuilder_validateIndex_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testValidateIndex_ValidIndex() {
        StrBuilder strBuilder = new StrBuilder();
        // Assuming the size is initialized to a valid value, e.g., 0
        setSize(strBuilder, 0); // Set size to 0 for this test

        try {
            Method method = StrBuilder.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, 0); // Test with a valid index
        } catch (Exception e) {
            fail("Exception should not have been thrown for a valid index");
        }
    }

    @Test(timeout = 4000)
    public void testValidateIndex_NegativeIndex() {
        StrBuilder strBuilder = new StrBuilder();
        setSize(strBuilder, 0); // Set size to 0 for this test

        try {
            Method method = StrBuilder.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, -1); // Test with a negative index
            fail("Expected StringIndexOutOfBoundsException for negative index");
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof StringIndexOutOfBoundsException);
            assertEquals("-1", e.getCause().getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidateIndex_ExceedingIndex() {
        StrBuilder strBuilder = new StrBuilder();
        setSize(strBuilder, 0); // Set size to 0 for this test

        try {
            Method method = StrBuilder.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, 1); // Test with an index greater than size
            fail("Expected StringIndexOutOfBoundsException for exceeding index");
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof StringIndexOutOfBoundsException);
            assertEquals("1", e.getCause().getMessage());
        }
    }

    private void setSize(StrBuilder strBuilder, int size) {
        try {
            java.lang.reflect.Field field = StrBuilder.class.getDeclaredField("size");
            field.setAccessible(true);
            field.setInt(strBuilder, size);
        } catch (Exception e) {
            fail("Failed to set size field: " + e.getMessage());
        }
    }

}