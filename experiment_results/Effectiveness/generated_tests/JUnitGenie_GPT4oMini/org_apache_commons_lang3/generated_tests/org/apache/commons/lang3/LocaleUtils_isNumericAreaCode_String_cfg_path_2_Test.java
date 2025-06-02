package org.apache.commons.lang3;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocaleUtils_isNumericAreaCode_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_ValidInput() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, "123");
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_InvalidLength() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, "12");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_NonNumericInput() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, "abc");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_EmptyString() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, "");
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNumericAreaCode_NullInput() {
        try {
            Method method = LocaleUtils.class.getDeclaredMethod("isNumericAreaCode", String.class);
            method.setAccessible(true);
            boolean result = (boolean) method.invoke(null, null);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}