package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_CPUTF8_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CPUTF8 instance = new CPUTF8("test");
        Object nullObject = null;

        try {
            boolean result = instance.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}