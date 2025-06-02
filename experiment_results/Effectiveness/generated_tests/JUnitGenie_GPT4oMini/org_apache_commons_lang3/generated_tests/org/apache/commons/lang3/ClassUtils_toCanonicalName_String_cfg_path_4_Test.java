package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ClassUtils_toCanonicalName_String_cfg_path_4_Test {

    // Setting up the abbreviationMap for testing
    static {
        try {
            // Accessing the private static final field abbreviationMap using reflection
            java.lang.reflect.Field field = ClassUtils.class.getDeclaredField("abbreviationMap");
            field.setAccessible(true);
            // Create a new instance of HashMap to avoid IllegalAccessException
            Map<String, String> abbreviationMap = new HashMap<>();
            abbreviationMap.put("java.lang.String", "S");
            // Use reflection to set the field value
            field.set(null, abbreviationMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testToCanonicalNameWithArray() {
        String className = "java.lang.String[]";
        String expected = "[Ljava.lang.String;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToCanonicalNameWithoutArray() {
        String className = "java.lang.String";
        String expected = "Ljava.lang.String;";
        String actual = invokeToCanonicalName(className);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToCanonicalNameWithWhitespace() {
        String className = "   java.lang.String   ";
        String expected = "Ljava.lang.String;";
        String actual = invokeToCanonicalName(className.trim());
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void testToCanonicalNameWithNull() {
        invokeToCanonicalName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToCanonicalNameWithEmptyString() {
        invokeToCanonicalName("");
    }

    private String invokeToCanonicalName(String className) {
        try {
            Method method = ClassUtils.class.getDeclaredMethod("toCanonicalName", String.class);
            method.setAccessible(true);
            return (String) method.invoke(null, className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}