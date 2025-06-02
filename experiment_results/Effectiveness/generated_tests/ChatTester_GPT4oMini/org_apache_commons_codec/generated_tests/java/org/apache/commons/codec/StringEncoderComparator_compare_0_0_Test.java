package org.apache.commons.codec;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Comparator;

class StringEncoderComparator_compare_0_0_Test {

    private StringEncoder stringEncoder;

    private StringEncoderComparator stringEncoderComparator;

    @BeforeEach
    void setUp() {
        stringEncoder = mock(StringEncoder.class);
        stringEncoderComparator = new StringEncoderComparator(stringEncoder);
    }

    @Test
    void testCompare_WithComparableObjects() throws EncoderException {
        Object obj1 = "test1";
        Object obj2 = "test2";
        when(stringEncoder.encode(obj1)).thenReturn("test1");
        when(stringEncoder.encode(obj2)).thenReturn("test2");
        int result = stringEncoderComparator.compare(obj1, obj2);
        // "test1" is less than "test2"
        assertEquals(-1, result);
    }

    @Test
    void testCompare_WithEqualComparableObjects() throws EncoderException {
        Object obj1 = "test";
        Object obj2 = "test";
        when(stringEncoder.encode(obj1)).thenReturn("test");
        when(stringEncoder.encode(obj2)).thenReturn("test");
        int result = stringEncoderComparator.compare(obj1, obj2);
        // Both are equal
        assertEquals(0, result);
    }

    @Test
    void testCompare_WithNullValues() throws EncoderException {
        Object obj1 = null;
        Object obj2 = "test";
        when(stringEncoder.encode(obj1)).thenReturn(null);
        when(stringEncoder.encode(obj2)).thenReturn("test");
        int result = stringEncoderComparator.compare(obj1, obj2);
        // Handling nulls as equal
        assertEquals(0, result);
    }

    @Test
    void testCompare_WithEncoderException() throws EncoderException {
        Object obj1 = "test1";
        Object obj2 = "test2";
        when(stringEncoder.encode(obj1)).thenThrow(new EncoderException("Encoding error"));
        when(stringEncoder.encode(obj2)).thenReturn("test2");
        int result = stringEncoderComparator.compare(obj1, obj2);
        // Exception handling returns 0
        assertEquals(0, result);
    }

    @Test
    void testCompare_WithNonComparableObjects() throws EncoderException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        when(stringEncoder.encode(obj1)).thenReturn(new Object());
        when(stringEncoder.encode(obj2)).thenReturn(new Object());
        int result = stringEncoderComparator.compare(obj1, obj2);
        // Non-comparable objects, should return 0
        assertEquals(0, result);
    }
}
