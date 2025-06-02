package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class mutable_MutableBoolean_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object differentObject = new Object(); // Not an instance of MutableBoolean

        try {
            // This should return false since the object is not of type MutableBoolean
            assertFalse(mutableBoolean.equals(differentObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object nullObject = null;

        try {
            // This should return false since the object is null
            assertFalse(mutableBoolean.equals(nullObject));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentMutableBoolean() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(false);

        try {
            // This should return false since the values are different
            assertFalse(mutableBoolean1.equals(mutableBoolean2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(true);

        try {
            // This should return true since both MutableBoolean instances have the same value
            assertFalse(mutableBoolean1.equals(mutableBoolean2));
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }

}