package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

class CPClass_equals_0_0_Test {

    @Test
    void testEquals_SameInstance() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        assertTrue(cpClass.equals(cpClass), "Same instance should be equal");
    }

    @Test
    void testEquals_NullObject() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        assertFalse(cpClass.equals(null), "Null should not be equal");
    }

    @Test
    void testEquals_DifferentClass() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        String differentClassObject = "Not a CPClass";
        assertFalse(cpClass.equals(differentClassObject), "Different class should not be equal");
    }

    @Test
    void testEquals_DifferentUTF8() {
        CPUTF8 utf81 = new CPUTF8("Test1");
        CPUTF8 utf82 = new CPUTF8("Test2");
        CPClass cpClass1 = new CPClass(utf81, 1);
        CPClass cpClass2 = new CPClass(utf82, 2);
        assertFalse(cpClass1.equals(cpClass2), "Different CPUTF8 should not be equal");
    }

    @Test
    void testEquals_SameUTF8() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass1 = new CPClass(utf8, 1);
        CPClass cpClass2 = new CPClass(utf8, 2);
        assertTrue(cpClass1.equals(cpClass2), "Same CPUTF8 should be equal");
    }
}
