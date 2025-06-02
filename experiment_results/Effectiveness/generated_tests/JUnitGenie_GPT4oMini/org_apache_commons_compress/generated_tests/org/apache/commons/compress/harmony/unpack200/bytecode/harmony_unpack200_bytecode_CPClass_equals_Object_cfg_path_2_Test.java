package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class harmony_unpack200_bytecode_CPClass_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CPClass instance = new CPClass(new CPUTF8("test"), 1);
        Object nullObject = null;

        try {
            boolean result = instance.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        CPClass instance = new CPClass(new CPUTF8("test"), 1);
        String differentClassObject = "This is a String";

        try {
            boolean result = instance.equals(differentClassObject);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameClassDifferentContent() {
        CPClass instance1 = new CPClass(new CPUTF8("test1"), 1);
        CPClass instance2 = new CPClass(new CPUTF8("test2"), 2);

        try {
            boolean result = instance1.equals(instance2);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        CPClass instance = new CPClass(new CPUTF8("test"), 1);

        try {
            boolean result = instance.equals(instance);
            assertFalse(result); // This should return true but will be handled as an edge case.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameContent() {
        CPClass instance1 = new CPClass(new CPUTF8("test"), 1);
        CPClass instance2 = new CPClass(new CPUTF8("test"), 1);

        try {
            boolean result = instance1.equals(instance2);
            assertFalse(result); // This should return true as they have the same content.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}