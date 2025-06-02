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

class CPUTF8_equals_0_0_Test {

    @Test
    void testEquals_SameInstance() {
        CPUTF8 instance = new CPUTF8("test");
        assertTrue(instance.equals(instance), "Should be equal to itself");
    }

    @Test
    void testEquals_NullObject() {
        CPUTF8 instance = new CPUTF8("test");
        assertFalse(instance.equals(null), "Should not be equal to null");
    }

    @Test
    void testEquals_DifferentClass() {
        CPUTF8 instance = new CPUTF8("test");
        assertFalse(instance.equals("test"), "Should not be equal to an object of a different class");
    }

    @Test
    void testEquals_DifferentString() {
        CPUTF8 instance1 = new CPUTF8("test1");
        CPUTF8 instance2 = new CPUTF8("test2");
        assertFalse(instance1.equals(instance2), "Should not be equal to another CPUTF8 with different strings");
    }

    @Test
    void testEquals_SameString() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2), "Should be equal to another CPUTF8 with the same string");
    }

    @Test
    void testEquals_HashCodeNotComputed() {
        CPUTF8 instance1 = new CPUTF8("test");
        CPUTF8 instance2 = new CPUTF8("test");
        assertTrue(instance1.equals(instance2), "Should be equal even if hash code is not computed");
    }
}
