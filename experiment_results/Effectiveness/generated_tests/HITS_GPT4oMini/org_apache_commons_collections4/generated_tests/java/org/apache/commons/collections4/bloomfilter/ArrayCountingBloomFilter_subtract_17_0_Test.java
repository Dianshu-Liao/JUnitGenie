package org.apache.commons.collections4.bloomfilter;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;

public class ArrayCountingBloomFilter_subtract_17_0_Test {

    private ArrayCountingBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    public void setUp() {
        shape = Mockito.mock(Shape.class);
        when(shape.getNumberOfBits()).thenReturn(10);
        bloomFilter = new ArrayCountingBloomFilter(shape);
        setCellValue(bloomFilter, 0, 5);
        setCellValue(bloomFilter, 1, 5);
    }

    private void setCellValue(ArrayCountingBloomFilter bloomFilter, int index, int value) {
        try {
            Field cellsField = ArrayCountingBloomFilter.class.getDeclaredField("cells");
            cellsField.setAccessible(true);
            int[] cells = (int[]) cellsField.get(bloomFilter);
            cells[index] = value;
        } catch (Exception e) {
            fail("Setup failed due to reflection error: " + e.getMessage());
        }
    }

    private int getCellValue(ArrayCountingBloomFilter bloomFilter, int index) {
        try {
            Field cellsField = ArrayCountingBloomFilter.class.getDeclaredField("cells");
            cellsField.setAccessible(true);
            int[] cells = (int[]) cellsField.get(bloomFilter);
            return cells[index];
        } catch (Exception e) {
            fail("Failed to get cell value due to reflection error: " + e.getMessage());
            return -1;
        }
    }

    @Test
    public void testSubtract_ValidIndex_SubtractsValue() {
        invokeSubtractMethod(bloomFilter, 0, 5);
        assertEquals(0, getCellValue(bloomFilter, 0));
    }

    @Test
    public void testSubtract_ValidIndex_SubtractsMoreThanCurrentValue() {
        invokeSubtractMethod(bloomFilter, 1, 10);
        assertEquals(-5, getCellValue(bloomFilter, 1));
    }

    @Test
    public void testSubtract_InvalidIndex_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeSubtractMethod(bloomFilter, 10, 1);
        });
        assertEquals("Filter only accepts values in the [0,10) range", exception.getMessage());
    }

    @Test
    public void testSubtract_NegativeIndex_ThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeSubtractMethod(bloomFilter, -1, 1);
        });
        assertEquals("Filter only accepts values in the [0,10) range", exception.getMessage());
    }

    private void invokeSubtractMethod(ArrayCountingBloomFilter bloomFilter, int index, int value) {
        try {
            java.lang.reflect.Method method = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
            method.setAccessible(true);
            method.invoke(bloomFilter, index, value);
        } catch (Exception e) {
            fail("Invocation of subtract method failed: " + e.getMessage());
        }
    }
}
