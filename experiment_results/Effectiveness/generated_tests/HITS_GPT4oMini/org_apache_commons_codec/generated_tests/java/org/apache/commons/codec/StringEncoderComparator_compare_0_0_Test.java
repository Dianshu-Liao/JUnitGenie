package org.apache.commons.codec;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;

public class StringEncoderComparator_compare_0_0_Test {

    private StringEncoder stringEncoder;

    private StringEncoderComparator comparator;

    @BeforeEach
    public void setUp() {
        stringEncoder = mock(StringEncoder.class);
        comparator = new StringEncoderComparator(stringEncoder);
    }

    @Test
    public void testCompare_EncodedStringsAreComparable() throws EncoderException {
        Object obj1 = "testString1";
        Object obj2 = "testString2";
        String encoded1 = "encodedString1";
        String encoded2 = "encodedString2";
        when(stringEncoder.encode(obj1)).thenReturn(encoded1);
        when(stringEncoder.encode(obj2)).thenReturn(encoded2);
        int result = comparator.compare(obj1, obj2);
        assertEquals(-1, result);
    }

    @Test
    public void testCompare_EncodedStringsAreEqual() throws EncoderException {
        Object obj1 = "testString";
        Object obj2 = "testString";
        String encoded = "encodedString";
        when(stringEncoder.encode(obj1)).thenReturn(encoded);
        when(stringEncoder.encode(obj2)).thenReturn(encoded);
        int result = comparator.compare(obj1, obj2);
        assertEquals(0, result);
    }

    @Test
    public void testCompare_EncodedString1IsGreater() throws EncoderException {
        Object obj1 = "testStringGreater";
        Object obj2 = "testStringLesser";
        String encoded1 = "encodedStringGreater";
        String encoded2 = "encodedStringLesser";
        when(stringEncoder.encode(obj1)).thenReturn(encoded1);
        when(stringEncoder.encode(obj2)).thenReturn(encoded2);
        int result = comparator.compare(obj1, obj2);
        assertEquals(1, result);
    }

    @Test
    public void testCompare_EncoderExceptionHandled() throws EncoderException {
        Object obj1 = "testString";
        Object obj2 = "testString";
        when(stringEncoder.encode(obj1)).thenThrow(new EncoderException("Encoding error"));
        int result = comparator.compare(obj1, obj2);
        assertEquals(0, result);
    }
}
