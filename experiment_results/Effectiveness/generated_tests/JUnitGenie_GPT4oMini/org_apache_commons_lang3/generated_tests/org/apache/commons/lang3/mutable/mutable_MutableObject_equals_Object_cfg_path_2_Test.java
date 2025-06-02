package org.apache.commons.lang3.mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class mutable_MutableObject_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        MutableObject<Object> object1 = new MutableObject<>(new Object());
        assertFalse(object1.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        MutableObject<Object> object1 = new MutableObject<>(new Object());
        assertTrue(object1.equals(object1));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        MutableObject<Object> object1 = new MutableObject<>(new Object());
        String differentClassObject = "Not a MutableObject";
        assertFalse(object1.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentValue() {
        MutableObject<Object> object1 = new MutableObject<>(new Object());
        MutableObject<Object> object2 = new MutableObject<>(new Object());
        assertFalse(object1.equals(object2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameValue() {
        Object sameValue = new Object();
        MutableObject<Object> object1 = new MutableObject<>(sameValue);
        MutableObject<Object> object2 = new MutableObject<>(sameValue);
        assertTrue(object1.equals(object2));
    }

}