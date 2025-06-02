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

    private MutableBoolean mutableTrue;

    private MutableBoolean mutableFalse;

    private MutableBoolean anotherMutableTrue;

    @BeforeEach
    void setUp() {
        mutableTrue = new MutableBoolean(true);
        mutableFalse = new MutableBoolean(false);
        anotherMutableTrue = new MutableBoolean(true);
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(mutableTrue.equals(mutableTrue));
        assertTrue(mutableFalse.equals(mutableFalse));
    }

    @Test
    void testEquals_SameValueDifferentObjects() {
        assertTrue(mutableTrue.equals(anotherMutableTrue));
    }

    @Test
    void testEquals_DifferentValues() {
        assertFalse(mutableTrue.equals(mutableFalse));
    }

    @Test
    void testEquals_NonMutableBoolean() {
        assertFalse(mutableTrue.equals(new Object()));
    }

    @Test
    void testEquals_Null() {
        assertFalse(mutableTrue.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(mutableTrue.equals("string"));
    }
}
