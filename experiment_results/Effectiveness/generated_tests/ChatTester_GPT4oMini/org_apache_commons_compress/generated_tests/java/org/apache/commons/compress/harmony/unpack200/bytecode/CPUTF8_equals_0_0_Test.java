package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class CPUTF8_equals_0_0_Test {

    @Test
    public void testEquals_SameInstance() {
        CPUTF8 instance = new CPUTF8("test");
        assertTrue(instance.equals(instance), "An instance should be equal to itself.");
    }

    @Test
    public void testEquals_NullObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertFalse(instance.equals(null), "An instance should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        CPUTF8 instance = new CPUTF8("test");
        String differentClassObject = "test";
        assertFalse(instance.equals(differentClassObject), "An instance should not be equal to an object of a different class.");
    }

    @Test
    public void testEquals_DifferentUTF8() {
        CPUTF8 instance1 = new CPUTF8("test1");
        CPUTF8 instance2 = new CPUTF8("test2");
        assertFalse(instance1.equals(instance2), "Instances with different utf8 values should not be equal.");
    }

    @Test
    public void testEquals_SameUTF8() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2), "Instances with the same utf8 value should be equal.");
    }
}
