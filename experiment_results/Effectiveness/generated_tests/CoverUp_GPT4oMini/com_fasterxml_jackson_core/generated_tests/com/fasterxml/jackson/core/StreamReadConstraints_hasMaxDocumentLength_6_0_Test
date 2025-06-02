package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;

public class StreamReadConstraints_hasMaxDocumentLength_6_0_Test {

    private StreamReadConstraints constraintsWithMaxDocLen;

    private StreamReadConstraints constraintsWithoutMaxDocLen;

    @BeforeEach
    public void setUp() {
        constraintsWithMaxDocLen = new StreamReadConstraints(1000, 100L, 1000, 20000000, 50000, 100);
        constraintsWithoutMaxDocLen = new StreamReadConstraints(1000, -1L, 1000, 20000000, 50000, 100);
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsPositive_ReturnsTrue() {
        assertTrue(constraintsWithMaxDocLen.hasMaxDocumentLength());
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsNegative_ReturnsFalse() {
        assertFalse(constraintsWithoutMaxDocLen.hasMaxDocumentLength());
    }

    @Test
    public void testHasMaxDocumentLength_WhenMaxDocLenIsZero_ReturnsFalse() {
        StreamReadConstraints constraintsWithZeroDocLen = new StreamReadConstraints(1000, 0L, 1000, 20000000, 50000, 100);
        assertFalse(constraintsWithZeroDocLen.hasMaxDocumentLength());
    }
}
