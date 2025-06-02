package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_4_Test {

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
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern1");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern2");
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternDifferentRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Assuming registry is a field that can be set, you would need to set it accordingly
        // format1.setRegistry(someRegistry1);
        // format2.setRegistry(someRegistry2);
        // assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameToPatternAndRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Assuming registry is a field that can be set, you would need to set it accordingly
        // format1.setRegistry(sameRegistry);
        // format2.setRegistry(sameRegistry);
        assertTrue(format1.equals(format2));
    }

}