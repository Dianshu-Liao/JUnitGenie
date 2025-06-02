package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_int_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSetValueWithNullCollection() {
        Object collection = new Object(); // Any object that is not an instance of org.apache.commons.jxpath.Container
        int index = 0;
        Object value = new Object();

        try {
            ValueUtils.setValue(collection, index, value);
            // Since getValue should return null, we expect the method to return without throwing an exception
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }

}