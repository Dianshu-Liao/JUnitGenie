package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class mutable_MutableBoolean_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNonMutableBoolean() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object nonMutableBoolean = new Object(); // Non-MutableBoolean object

        // Testing the equals method with a non-MutableBoolean object
        try {
            assertFalse(mutableBoolean.equals(nonMutableBoolean));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object nullObject = null; // Null object

        // Testing the equals method with a null object
        try {
            assertFalse(mutableBoolean.equals(nullObject));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        Object differentType = "String"; // Different type object

        // Testing the equals method with a different type object
        try {
            assertFalse(mutableBoolean.equals(differentType));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(true); // Same value

        // Testing the equals method with another MutableBoolean of the same value
        try {
            assertFalse(mutableBoolean1.equals(mutableBoolean2));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}