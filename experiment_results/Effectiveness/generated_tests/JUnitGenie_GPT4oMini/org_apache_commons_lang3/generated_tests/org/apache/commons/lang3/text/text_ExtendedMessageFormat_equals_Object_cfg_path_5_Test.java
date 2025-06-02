package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(format));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        String differentClassObject = "Not an ExtendedMessageFormat";
        assertFalse(format.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_SuperEqualsFalse() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("differentPattern");
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentToPattern() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Use reflection to set the private field for testing
        try {
            java.lang.reflect.Field field = ExtendedMessageFormat.class.getDeclaredField("pattern");
            field.setAccessible(true);
            field.set(format2, "differentPattern");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternDifferentRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Use reflection to set the private field for testing
        try {
            java.lang.reflect.Field field = ExtendedMessageFormat.class.getDeclaredField("registry");
            field.setAccessible(true);
            field.set(format1, new java.util.HashMap<String, Object>());
            field.set(format2, new java.util.HashMap<String, Object>()); // Different registry
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternSameRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Use reflection to set the private field for testing
        try {
            java.lang.reflect.Field field = ExtendedMessageFormat.class.getDeclaredField("registry");
            field.setAccessible(true);
            java.util.HashMap<String, Object> sharedRegistry = new java.util.HashMap<>();
            field.set(format1, sharedRegistry); // Same registry
            field.set(format2, sharedRegistry); // Same registry
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(format1.equals(format2));
    }


}