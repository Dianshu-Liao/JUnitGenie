package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_CPUTF8_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CPUTF8 instance = new CPUTF8("test");
        Object obj = null;

        try {
            boolean result = instance.equals(obj);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        CPUTF8 instance = new CPUTF8("test");
        Object obj = new Object(); // Different class

        try {
            boolean result = instance.equals(obj);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}