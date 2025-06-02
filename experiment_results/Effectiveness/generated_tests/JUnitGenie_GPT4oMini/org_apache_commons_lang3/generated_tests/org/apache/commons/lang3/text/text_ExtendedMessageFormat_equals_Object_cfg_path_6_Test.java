package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        Object obj = null;

        try {
            boolean result = format.equals(obj);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        ExtendedMessageFormat format = new ExtendedMessageFormat("pattern");
        Object obj = new Object(); // Different class

        try {
            boolean result = format.equals(obj);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}