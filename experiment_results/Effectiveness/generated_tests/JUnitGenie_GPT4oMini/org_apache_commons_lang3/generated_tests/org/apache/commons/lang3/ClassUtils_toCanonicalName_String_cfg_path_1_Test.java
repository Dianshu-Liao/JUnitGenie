package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ClassUtils_toCanonicalName_String_cfg_path_1_Test {

    // Mocking the private static final Map abbreviationMap for testing
    static {
        try {
            // Accessing the private static field abbreviationMap using reflection
            Map<String, String> abbreviationMap = new HashMap<>();
            abbreviationMap.put("java.lang.String", "S");
            // Set the abbreviationMap field
            java.lang.reflect.Field field = ClassUtils.class.getDeclaredField("abbreviationMap");
            field.setAccessible(true);
            field.set(null, abbreviationMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToCanonicalNameWithArray() {
        try {
            // Prepare the input
            String className = "java.lang.String[]";
            // Accessing the private static method toCanonicalName using reflection
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);
            // Invoke the method
            String result = (String) method.invoke(null, className);
            // Expected result
            String expected = "S[]";
            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToCanonicalNameWithoutArray() {
        try {
            // Prepare the input
            String className = "java.lang.String";
            // Accessing the private static method toCanonicalName using reflection
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);
            // Invoke the method
            String result = (String) method.invoke(null, className);
            // Expected result
            String expected = "Ljava.lang.String;";
            // Assert the result
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void testToCanonicalNameWithNull() {
        try {
            // Accessing the private static method toCanonicalName using reflection
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);
            // Invoke the method with null
            method.invoke(null, (String) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}