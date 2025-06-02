package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_CPUTF8_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertTrue(instance.equals(instance));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertFalse(instance.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CPUTF8 instance = new CPUTF8("test");
        String differentClassObject = "test";
        assertFalse(instance.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentContent() {
        CPUTF8 instance1 = new CPUTF8("test1");
        CPUTF8 instance2 = new CPUTF8("test2");
        assertFalse(instance1.equals(instance2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameContent() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2));
    }

}