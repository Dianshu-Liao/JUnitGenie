package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class text_ExtendedMessageFormat_equals_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        ExtendedMessageFormat format1 = new ExtendedMessageFormat("pattern1");
        Object differentObject = new Object(); // A different type of object

        try {
            // This should return false as the object is of a different type
            assertFalse(format1.equals(differentObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}