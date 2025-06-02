package org.apache.commons.lang3.mutable;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class MutableBoolean_equals_2_0_Test {

    @Test
    public void testEquals_SameObject() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertTrue(mutableBoolean.equals(mutableBoolean), "MutableBoolean should be equal to itself");
    }

    @Test
    public void testEquals_Null() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        assertFalse(mutableBoolean.equals(null), "MutableBoolean should not be equal to null");
    }

    @Test
    public void testEquals_DifferentType() {
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        String notAMutableBoolean = "Not a MutableBoolean";
        assertFalse(mutableBoolean.equals(notAMutableBoolean), "MutableBoolean should not be equal to a different type");
    }

    @Test
    public void testEquals_EqualMutableBoolean() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(true);
        assertTrue(mutableBoolean1.equals(mutableBoolean2), "Two MutableBooleans with the same value should be equal");
    }

    @Test
    public void testEquals_NotEqualMutableBoolean() {
        MutableBoolean mutableBoolean1 = new MutableBoolean(true);
        MutableBoolean mutableBoolean2 = new MutableBoolean(false);
        assertFalse(mutableBoolean1.equals(mutableBoolean2), "Two MutableBooleans with different values should not be equal");
    }
}
