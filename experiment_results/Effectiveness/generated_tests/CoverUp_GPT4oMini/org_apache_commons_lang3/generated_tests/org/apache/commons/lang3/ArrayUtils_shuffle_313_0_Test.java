package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.stream.IntStreams;
import org.apache.commons.lang3.stream.Streams;

class ArrayUtils_shuffle_313_0_Test {

    private ArrayUtils arrayUtils;

    @BeforeEach
    void setUp() {
        arrayUtils = new ArrayUtils();
    }

    @Test
    void testShuffle_withNonEmptyArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] array = { "A", "B", "C", "D", "E" };
        // Fixed seed for reproducibility
        Random random = new Random(0);
        invokeShuffle(array, random);
        assertEquals(5, array.length);
        assertFalse(Arrays.equals(array, new String[] { "A", "B", "C", "D", "E" }));
    }

    @Test
    void testShuffle_withEmptyArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] array = {};
        invokeShuffle(array, new Random());
        assertEquals(0, array.length);
    }

    @Test
    void testShuffle_withSingleElementArray() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String[] array = { "A" };
        invokeShuffle(array, new Random());
        assertEquals(1, array.length);
        assertEquals("A", array[0]);
    }

    private void invokeShuffle(Object[] array, Random random) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method shuffleMethod = ArrayUtils.class.getDeclaredMethod("shuffle", Object[].class, Random.class);
        shuffleMethod.setAccessible(true);
        shuffleMethod.invoke(null, (Object) array, random);
    }
}
