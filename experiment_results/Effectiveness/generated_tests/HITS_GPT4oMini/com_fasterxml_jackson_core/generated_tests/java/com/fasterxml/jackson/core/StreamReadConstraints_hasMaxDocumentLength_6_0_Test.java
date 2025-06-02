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
        // Initialize with a positive max document length
        constraintsWithMaxDocLen = new StreamReadConstraints(1000, 1L, 1000, 20000000, 50000, -1L);
        // Initialize with a non-positive max document length
        constraintsWithoutMaxDocLen = new StreamReadConstraints(1000, 0L, 1000, 20000000, 50000, -1L);
    }

    @Test
    public void testHasMaxDocumentLength_WithPositiveLength() {
        // Test that hasMaxDocumentLength returns true when maxDocLen is positive
        assertTrue(constraintsWithMaxDocLen.hasMaxDocumentLength(), "Expected hasMaxDocumentLength to return true for positive maxDocLen");
    }

    @Test
    public void testHasMaxDocumentLength_WithZeroLength() {
        // Test that hasMaxDocumentLength returns false when maxDocLen is zero
        assertFalse(constraintsWithoutMaxDocLen.hasMaxDocumentLength(), "Expected hasMaxDocumentLength to return false for zero maxDocLen");
    }

    @Test
    public void testHasMaxDocumentLength_WithNegativeLength() {
        // Initialize with a negative max document length
        StreamReadConstraints constraintsWithNegativeDocLen = new StreamReadConstraints(1000, -1L, 1000, 20000000, 50000, -1L);
        // Test that hasMaxDocumentLength returns false when maxDocLen is negative
        assertFalse(constraintsWithNegativeDocLen.hasMaxDocumentLength(), "Expected hasMaxDocumentLength to return false for negative maxDocLen");
    }
}
