package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;

public class util_ValueUtils_setValue_Object_int_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetValueUnsupportedOperation() {
        Object collection = new HashSet<>(); // Creating an instance of a Collection that is not supported
        int index = 0; // Index (this value won't be used since it will throw)
        Object value = new Object();

        try {
            ValueUtils.setValue(collection, index, value);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Cannot set value of an element of a java.util.HashSet", e.getMessage());
        }
    }

    // Additional tests can be added here to cover other paths if necessary


}