package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.ConstantInitializer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class concurrent_ConstantInitializer_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        ConstantInitializer<Object> initializer = new ConstantInitializer<>(new Object());
        assertTrue(initializer.equals(initializer));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        ConstantInitializer<Object> initializer = new ConstantInitializer<>(new Object());
        String differentTypeObject = "Not a ConstantInitializer";
        assertFalse(initializer.equals(differentTypeObject));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        ConstantInitializer<Object> initializer = new ConstantInitializer<>(new Object());
        assertFalse(initializer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentInstance() {
        ConstantInitializer<Object> initializer1 = new ConstantInitializer<>(new Object());
        ConstantInitializer<Object> initializer2 = new ConstantInitializer<>(new Object());
        assertFalse(initializer1.equals(initializer2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValue() {
        Object obj = new Object();
        ConstantInitializer<Object> initializer1 = new ConstantInitializer<>(obj);
        ConstantInitializer<Object> initializer2 = new ConstantInitializer<>(obj);
        assertTrue(initializer1.equals(initializer2));
    }

}