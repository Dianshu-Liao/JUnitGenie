package org.apache.commons.lang3;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class LocaleUtils_isNumericAreaCode_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ShouldReturnFalse_WhenInputIsNotNumeric() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, "abc");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ShouldReturnFalse_WhenInputLengthIsNotThree() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, "12");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ShouldReturnFalse_WhenInputIsEmpty() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, "");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ShouldReturnFalse_WhenInputIsNull() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, null);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ShouldReturnFalse_WhenInputIsNumericButNotThreeDigits() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(null, "1234");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

}