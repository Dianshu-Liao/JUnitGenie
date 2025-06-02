package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ClassUtils_getCanonicalName_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetCanonicalNameWithEmptyString() {
        try {
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true); // Accessing the private method

            // Test with an empty string
            String result = (String) method.invoke(null, "");
            assertEquals("", result); // Expecting empty string as output
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCanonicalNameWithSingleDimensionClass() {
        try {
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true); // Accessing the private method

            String result = (String) method.invoke(null, "LMyClass;");
            assertEquals("MyClass", result); // Expecting "MyClass" as output
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testGetCanonicalNameWithArray() {
        try {
            Method method = ClassUtils.class.getDeclaredMethod("getCanonicalName", String.class);
            method.setAccessible(true); // Accessing the private method

            String result = (String) method.invoke(null, "[LMyClass;");
            assertEquals("MyClass[]", result); // Expecting "MyClass[]" as output
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}