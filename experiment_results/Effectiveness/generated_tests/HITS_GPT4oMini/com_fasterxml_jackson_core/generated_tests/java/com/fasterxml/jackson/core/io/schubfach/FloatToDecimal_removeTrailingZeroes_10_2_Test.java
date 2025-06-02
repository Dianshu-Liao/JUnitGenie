package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Float.floatToRawIntBits;
import static java.lang.Integer.numberOfLeadingZeros;

class FloatToDecimal_removeTrailingZeroes_10_2_Test {

    private FloatToDecimal floatToDecimal;

    @BeforeEach
    void setUp() throws Exception {
        floatToDecimal = (FloatToDecimal) FloatToDecimal.class.getDeclaredConstructor().newInstance();
    }

    @Test
    void testRemoveTrailingZeroes_NoTrailingZeroes() throws Exception {
        setBytesAndIndex(new byte[] { '1', '2', '3', '.', '4', '5' }, 5);
        invokeRemoveTrailingZeroes();
        assertEquals(5, getIndex());
    }

    @Test
    void testRemoveTrailingZeroes_WithTrailingZeroes() throws Exception {
        setBytesAndIndex(new byte[] { '1', '2', '3', '.', '4', '5', '0', '0', '0', '0' }, 9);
        invokeRemoveTrailingZeroes();
        assertEquals(5, getIndex());
    }

    @Test
    void testRemoveTrailingZeroes_OnlyZeroes() throws Exception {
        setBytesAndIndex(new byte[] { '0', '.', '0', '0', '0', '0' }, 5);
        invokeRemoveTrailingZeroes();
        assertEquals(1, getIndex());
    }

    @Test
    void testRemoveTrailingZeroes_TrailingZeroesAfterDecimal() throws Exception {
        setBytesAndIndex(new byte[] { '1', '2', '3', '.', '0', '0', '0', '0' }, 7);
        invokeRemoveTrailingZeroes();
        assertEquals(3, getIndex());
    }

    @Test
    void testRemoveTrailingZeroes_OneZeroAfterDecimal() throws Exception {
        setBytesAndIndex(new byte[] { '1', '2', '3', '.', '0' }, 4);
        invokeRemoveTrailingZeroes();
        assertEquals(3, getIndex());
    }

    @Test
    void testRemoveTrailingZeroes_NoZeroesAfterDecimal() throws Exception {
        setBytesAndIndex(new byte[] { '1', '2', '3', '.' }, 3);
        invokeRemoveTrailingZeroes();
        assertEquals(3, getIndex());
    }

    private void setBytesAndIndex(byte[] bytes, int index) throws Exception {
        Field bytesField = FloatToDecimal.class.getDeclaredField("bytes");
        bytesField.setAccessible(true);
        bytesField.set(floatToDecimal, bytes);
        Field indexField = FloatToDecimal.class.getDeclaredField("index");
        indexField.setAccessible(true);
        indexField.set(floatToDecimal, index);
    }

    private void invokeRemoveTrailingZeroes() throws Exception {
        Method method = FloatToDecimal.class.getDeclaredMethod("removeTrailingZeroes");
        method.setAccessible(true);
        method.invoke(floatToDecimal);
    }

    private int getIndex() throws Exception {
        Field indexField = FloatToDecimal.class.getDeclaredField("index");
        indexField.setAccessible(true);
        return indexField.getInt(floatToDecimal);
    }
}
