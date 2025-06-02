package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_validateRange_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateRangeThrowsExceptionWhenStartIndexIsNegative() {
        StrBuilder strBuilder = new StrBuilder();
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = StrBuilder.class.getDeclaredMethod("validateRange", int.class, int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, -1, 5);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals(-1, e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidateRangeAdjustsEndIndexToSize() {
        StrBuilder strBuilder = new StrBuilder(10);
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = StrBuilder.class.getDeclaredMethod("validateRange", int.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(strBuilder, 0, 15);
            assertEquals(10, result); // size is 10, so endIndex should be adjusted to 10
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidateRangeThrowsExceptionWhenStartIndexGreaterThanEndIndex() {
        StrBuilder strBuilder = new StrBuilder();
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = StrBuilder.class.getDeclaredMethod("validateRange", int.class, int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, 5, 3);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("end < start", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}