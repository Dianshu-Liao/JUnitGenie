package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

public class CPClass_equals_0_0_Test {

    @Test
    public void testEquals_SameObject() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        assertTrue(cpClass.equals(cpClass), "An object should equal itself");
    }

    @Test
    public void testEquals_Null() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        assertFalse(cpClass.equals(null), "An object should not equal null");
    }

    @Test
    public void testEquals_DifferentClass() {
        CPUTF8 utf8 = new CPUTF8("Test");
        CPClass cpClass = new CPClass(utf8, 1);
        String differentObject = "Not a CPClass";
        assertFalse(cpClass.equals(differentObject), "An object should not equal an instance of a different class");
    }

    @Test
    public void testEquals_SameValues() {
        CPUTF8 utf81 = new CPUTF8("Test");
        CPUTF8 utf82 = new CPUTF8("Test");
        CPClass cpClass1 = new CPClass(utf81, 1);
        CPClass cpClass2 = new CPClass(utf82, 2);
        assertTrue(cpClass1.equals(cpClass2), "Objects with the same utf8 value should be equal");
    }

    @Test
    public void testEquals_DifferentValues() {
        CPUTF8 utf81 = new CPUTF8("Test1");
        CPUTF8 utf82 = new CPUTF8("Test2");
        CPClass cpClass1 = new CPClass(utf81, 1);
        CPClass cpClass2 = new CPClass(utf82, 2);
        assertFalse(cpClass1.equals(cpClass2), "Objects with different utf8 values should not be equal");
    }
}
