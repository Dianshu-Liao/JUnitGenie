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
    public void testEquals_SameObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertTrue(instance.equals(instance), "An object should equal itself.");
    }

    @Test
    public void testEquals_NullObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertFalse(instance.equals(null), "An object should not equal null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        CPUTF8 instance = new CPUTF8("test");
        String other = "test";
        assertFalse(instance.equals(other), "An object should not equal an instance of a different class.");
    }

    @Test
    public void testEquals_DifferentUTF8() {
        CPUTF8 instance1 = new CPUTF8("test1");
        CPUTF8 instance2 = new CPUTF8("test2");
        assertFalse(instance1.equals(instance2), "Different CPUTF8 instances should not be equal.");
    }

    @Test
    public void testEquals_SameUTF8() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2), "CPUTF8 instances with the same UTF-8 string should be equal.");
    }

    @Test
    public void testEquals_HashCodeConsistency() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2), "Instances should be equal.");
        assertEquals(instance1.hashCode(), instance2.hashCode(), "Equal objects must have the same hash code.");
    }
}
