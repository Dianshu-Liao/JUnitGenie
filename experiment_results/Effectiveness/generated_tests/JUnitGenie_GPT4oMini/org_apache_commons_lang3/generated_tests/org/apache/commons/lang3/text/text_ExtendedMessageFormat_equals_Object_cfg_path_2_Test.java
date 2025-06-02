package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_2_Test {

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
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat differentFormat = new ExtendedMessageFormat("differentPattern");
        assertFalse(format.equals(differentFormat));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentToPattern() {
        Map<String, FormatFactory> registry = new HashMap<>();
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern1", Locale.US, registry);
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern2", Locale.US, registry);
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternDifferentRegistry() {
        Map<String, FormatFactory> registry1 = new HashMap<>();
        Map<String, FormatFactory> registry2 = new HashMap<>();
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern", Locale.US, registry1);
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern", Locale.US, registry2);
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternAndRegistry() {
        Map<String, FormatFactory> registry = new HashMap<>();
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern", Locale.US, registry);
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern", Locale.US, registry);
        assertTrue(format1.equals(format2));
    }

}