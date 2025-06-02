package org.apache.commons.lang3.text;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_1_Test {

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
        Object other = new Object();
        assertFalse(format.equals(other));
    }

    @Test(timeout = 4000)
    public void testEquals_SuperEqualsFalse() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat other = new ExtendedMessageFormat("differentPattern");
        assertFalse(format.equals(other));
    }

    @Test(timeout = 4000)
    public void testEquals_ClassDifferent() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat differentClassFormat = new ExtendedMessageFormat("pattern");
        ObjectUtils.notEqual(differentClassFormat.getClass(), format.getClass());
        assertFalse(format.equals(differentClassFormat));
    }

    @Test(timeout = 4000)
    public void testEquals_PatternDifferent() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern1");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern2");
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_SamePatternAndRegistry() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat format2 = new ExtendedMessageFormat("pattern");
        // Assuming that registry will be same for these instances for equality check
        assertTrue(format1.equals(format2));
    }

}