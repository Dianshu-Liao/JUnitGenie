package org.apache.commons.collections4.bloomfilter;

import org.apache.commons.collections4.bloomfilter.ArrayCountingBloomFilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;

class ArrayCountingBloomFilter_subtract_17_1_Test {

    private ArrayCountingBloomFilter bloomFilter;

    @BeforeEach
    void setUp() {
        // Create a Shape instance using reflection since the constructor is private
        try {
            Class<?> shapeClass = Class.forName("org.apache.commons.collections4.bloomfilter.Shape");
            Constructor<?> shapeConstructor = shapeClass.getDeclaredConstructor(int.class, int.class);
            shapeConstructor.setAccessible(true);
            Shape shape = (Shape) shapeConstructor.newInstance(3, 10);
            bloomFilter = new ArrayCountingBloomFilter(shape);
        } catch (Exception e) {
            fail("Failed to create Shape instance: " + e.getMessage());
        }
    }

    @Test
    void testSubtractValidIndex() throws Exception {
        // Set up the internal state directly for testing
        Method setCellsMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("setCells", int[].class);
        setCellsMethod.setAccessible(true);
        setCellsMethod.invoke(bloomFilter, new int[] { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        // Now test the subtract method
        Method subtractMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
        subtractMethod.setAccessible(true);
        // subtract 3 from index 0
        boolean result = (boolean) subtractMethod.invoke(bloomFilter, 0, 3);
        assertTrue(result);
        // Check the updated value
        Method getCellsMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("getCells");
        getCellsMethod.setAccessible(true);
        assertArrayEquals(new int[] { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, (int[]) getCellsMethod.invoke(bloomFilter));
    }

    @Test
    void testSubtractInvalidIndex() throws Exception {
        Method subtractMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
        subtractMethod.setAccessible(true);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid index
            subtractMethod.invoke(bloomFilter, 10, 1);
        });
        assertEquals("Filter only accepts values in the [0,10) range", exception.getMessage());
    }

    @Test
    void testSubtractNegativeResult() throws Exception {
        Method setCellsMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("setCells", int[].class);
        setCellsMethod.setAccessible(true);
        setCellsMethod.invoke(bloomFilter, new int[] { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
        Method subtractMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
        subtractMethod.setAccessible(true);
        // subtract 5 from index 0
        boolean result = (boolean) subtractMethod.invoke(bloomFilter, 0, 5);
        assertTrue(result);
        // Check the updated value
        Method getCellsMethod = ArrayCountingBloomFilter.class.getDeclaredMethod("getCells");
        getCellsMethod.setAccessible(true);
        assertArrayEquals(new int[] { -3, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, (int[]) getCellsMethod.invoke(bloomFilter));
    }
}
