package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class mutable_MutableObject_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        MutableObject<Object> obj1 = new MutableObject<>();
        assertFalse(obj1.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        MutableObject<Object> obj1 = new MutableObject<>();
        assertTrue(obj1.equals(obj1));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        MutableObject<Object> obj1 = new MutableObject<>();
        String differentClassObject = "Not a MutableObject";
        assertFalse(obj1.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        MutableObject<Object> obj1 = new MutableObject<>("value");
        MutableObject<Object> obj2 = new MutableObject<>("value");
        assertTrue(obj1.equals(obj2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentValue() {
        MutableObject<Object> obj1 = new MutableObject<>("value1");
        MutableObject<Object> obj2 = new MutableObject<>("value2");
        assertFalse(obj1.equals(obj2));
    }

}