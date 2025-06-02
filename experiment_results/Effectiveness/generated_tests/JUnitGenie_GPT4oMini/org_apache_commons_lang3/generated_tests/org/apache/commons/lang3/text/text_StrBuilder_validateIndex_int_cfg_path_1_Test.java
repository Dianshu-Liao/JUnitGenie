package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class text_StrBuilder_validateIndex_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateIndexThrowsExceptionForNegativeIndex() {
        StrBuilder strBuilder = new StrBuilder();
        int negativeIndex = -1;

        try {
            // Accessing the protected method using reflection
            Method method = StrBuilder.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, negativeIndex);
            fail("Expected StringIndexOutOfBoundsException for negative index");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidateIndexThrowsExceptionForIndexGreaterThanSize() {
        StrBuilder strBuilder = new StrBuilder();
        int indexGreaterThanSize = 1; // Assuming size is 0 for a new StrBuilder

        try {
            // Accessing the protected method using reflection
            Method method = StrBuilder.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(strBuilder, indexGreaterThanSize);
            fail("Expected StringIndexOutOfBoundsException for index greater than size");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}