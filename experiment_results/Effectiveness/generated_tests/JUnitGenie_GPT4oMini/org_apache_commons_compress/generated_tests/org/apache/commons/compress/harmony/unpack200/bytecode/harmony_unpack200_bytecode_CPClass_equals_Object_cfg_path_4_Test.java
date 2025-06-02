package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class harmony_unpack200_bytecode_CPClass_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CPClass cpClass = new CPClass(new CPUTF8("test"), 1);
        assertTrue(cpClass.equals(cpClass));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CPClass cpClass = new CPClass(new CPUTF8("test"), 1);
        assertTrue(!cpClass.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CPClass cpClass = new CPClass(new CPUTF8("test"), 1);
        String differentClassObject = "Not a CPClass";
        assertTrue(!cpClass.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentContent() {
        CPClass cpClass1 = new CPClass(new CPUTF8("test1"), 1);
        CPClass cpClass2 = new CPClass(new CPUTF8("test2"), 1);
        assertTrue(!cpClass1.equals(cpClass2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameContent() {
        CPClass cpClass1 = new CPClass(new CPUTF8("test"), 1);
        CPClass cpClass2 = new CPClass(new CPUTF8("test"), 1);
        assertTrue(cpClass1.equals(cpClass2));
    }

}