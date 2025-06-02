package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class mutable_MutableBoolean_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_DifferentValue() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(false); // Different value

        // This should return false since the values are different
        boolean result = mutableBoolean1.equals(mutableBoolean2);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testEquals_SameValue() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(true); // Same value

        // This should return true since the values are the same
        boolean result = mutableBoolean1.equals(mutableBoolean2);
        assertFalse(result); // This is to ensure we are testing the false case
    }

    @Test(timeout = 4000)
    public void testEquals_NonMutableBoolean() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object nonMutableBoolean = new Object(); // Not an instance of MutableBoolean

        // This should return false since the object is not an instance of MutableBoolean
        boolean result = mutableBoolean.equals(nonMutableBoolean);
        assertFalse(result);
    }

}