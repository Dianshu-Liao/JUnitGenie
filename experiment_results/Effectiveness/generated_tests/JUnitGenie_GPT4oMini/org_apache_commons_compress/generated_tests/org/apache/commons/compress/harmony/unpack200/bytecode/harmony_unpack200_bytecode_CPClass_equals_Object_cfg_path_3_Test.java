package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_CPClass_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CPClass instance = new CPClass(new CPUTF8("test"), 1);
        Object nullObject = null;

        try {
            boolean result = instance.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}