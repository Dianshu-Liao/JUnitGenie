package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class // Additional tests can be added to cover other scenarios if needed
SkippingIterator_SkippingIterator_3_0_Test {

    private SkippingIterator<String> skippingIterator;

    @BeforeEach
    public void setUp() {
        // Setup can be done here if needed
    }

    @Test
    public void testConstructor_ValidOffset() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        skippingIterator = new SkippingIterator<>(iterator, 1);
        assertNotNull(skippingIterator);
    }

    @Test
    public void testConstructor_NegativeOffset() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            skippingIterator = new SkippingIterator<>(iterator, -1);
        });
        assertEquals("Offset parameter must not be negative.", exception.getMessage());
    }

    @Test
    public void testConstructor_ZeroOffset() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        skippingIterator = new SkippingIterator<>(iterator, 0);
        assertNotNull(skippingIterator);
    }

    @Test
    public void testConstructor_LargeOffset() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        skippingIterator = new SkippingIterator<>(iterator, 5);
        assertNotNull(skippingIterator);
    }
}
