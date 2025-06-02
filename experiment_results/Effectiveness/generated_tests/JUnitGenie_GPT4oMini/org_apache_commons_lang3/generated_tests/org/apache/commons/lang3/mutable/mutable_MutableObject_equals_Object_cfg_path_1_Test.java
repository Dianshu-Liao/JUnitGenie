package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class mutable_MutableObject_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        MutableObject<Object> obj1 = new MutableObject<>();
        assertFalse(obj1.equals(null)); // Testing the case where obj is null
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        MutableObject<Object> obj1 = new MutableObject<>();
        assertTrue(obj1.equals(obj1)); // Testing the case where this == obj
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        MutableObject<Object> obj1 = new MutableObject<>();
        String obj2 = "Not a MutableObject";
        assertFalse(obj1.equals(obj2)); // Testing the case where obj is of a different class
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameClassDifferentValue() {
        MutableObject<Object> obj1 = new MutableObject<>("value1");
        MutableObject<Object> obj2 = new MutableObject<>("value2");
        assertFalse(obj1.equals(obj2)); // Testing the case where both are MutableObject but values are different
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameClassSameValue() {
        MutableObject<Object> obj1 = new MutableObject<>("value");
        MutableObject<Object> obj2 = new MutableObject<>("value");
        assertTrue(obj1.equals(obj2)); // Testing the case where both are MutableObject and values are the same
    }

}