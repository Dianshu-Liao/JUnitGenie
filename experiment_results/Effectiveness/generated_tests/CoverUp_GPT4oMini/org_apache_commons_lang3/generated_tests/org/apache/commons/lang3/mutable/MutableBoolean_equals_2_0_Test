package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.mutable.MutableBoolean;
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
    public void testEqualsWithSameValue() {
        MutableBoolean mb1 = new MutableBoolean(true);
        MutableBoolean mb2 = new MutableBoolean(true);
        assertTrue(mb1.equals(mb2), "MutableBoolean with same value should be equal");
    }

    @Test
    public void testEqualsWithDifferentValue() {
        MutableBoolean mb1 = new MutableBoolean(true);
        MutableBoolean mb2 = new MutableBoolean(false);
        assertFalse(mb1.equals(mb2), "MutableBoolean with different values should not be equal");
    }

    @Test
    public void testEqualsWithNull() {
        MutableBoolean mb = new MutableBoolean(true);
        assertFalse(mb.equals(null), "MutableBoolean should not be equal to null");
    }

    @Test
    public void testEqualsWithDifferentType() {
        MutableBoolean mb = new MutableBoolean(true);
        assertFalse(mb.equals("string"), "MutableBoolean should not be equal to an object of different type");
    }

    @Test
    public void testEqualsWithItself() {
        MutableBoolean mb = new MutableBoolean(true);
        assertTrue(mb.equals(mb), "MutableBoolean should be equal to itself");
    }

    @Test
    public void testEqualsWithMutableBooleanFalse() {
        MutableBoolean mb1 = new MutableBoolean(false);
        MutableBoolean mb2 = new MutableBoolean(false);
        assertTrue(mb1.equals(mb2), "MutableBoolean with same false value should be equal");
    }

    @Test
    public void testEqualsWithMutableBooleanTrueAndFalse() {
        MutableBoolean mb1 = new MutableBoolean(true);
        MutableBoolean mb2 = new MutableBoolean(false);
        assertFalse(mb1.equals(mb2), "MutableBoolean true should not be equal to MutableBoolean false");
    }
}
