package org.apache.commons.codec;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Comparator;

class StringEncoderComparator_compare_0_0_Test {

    private StringEncoder stringEncoderMock;

    private StringEncoderComparator comparator;

    @BeforeEach
    void setUp() {
        stringEncoderMock = Mockito.mock(StringEncoder.class);
        comparator = new StringEncoderComparator(stringEncoderMock);
    }

    @Test
    void testCompare_ValidComparableObjects() throws EncoderException {
        Object obj1 = "hello";
        Object obj2 = "world";
        when(stringEncoderMock.encode(obj1)).thenReturn("hello");
        when(stringEncoderMock.encode(obj2)).thenReturn("world");
        int result = comparator.compare(obj1, obj2);
        // "hello" is less than "world"
        assertEquals(-1, result);
    }

    @Test
    void testCompare_EqualComparableObjects() throws EncoderException {
        Object obj1 = "test";
        Object obj2 = "test";
        when(stringEncoderMock.encode(obj1)).thenReturn("test");
        when(stringEncoderMock.encode(obj2)).thenReturn("test");
        int result = comparator.compare(obj1, obj2);
        // "test" is equal to "test"
        assertEquals(0, result);
    }

    @Test
    void testCompare_EncoderException() throws EncoderException {
        Object obj1 = "foo";
        Object obj2 = "bar";
        when(stringEncoderMock.encode(obj1)).thenThrow(new EncoderException("Encoding failed"));
        when(stringEncoderMock.encode(obj2)).thenReturn("bar");
        int result = comparator.compare(obj1, obj2);
        // On exception, should return 0
        assertEquals(0, result);
    }

    @Test
    void testCompare_EncodeReturnsNonComparable() throws EncoderException {
        Object obj1 = "foo";
        Object obj2 = "bar";
        // Non-comparable object
        when(stringEncoderMock.encode(obj1)).thenReturn(new Object());
        when(stringEncoderMock.encode(obj2)).thenReturn("bar");
        int result = comparator.compare(obj1, obj2);
        // Should return 0 due to ClassCastException
        assertEquals(0, result);
    }
}
