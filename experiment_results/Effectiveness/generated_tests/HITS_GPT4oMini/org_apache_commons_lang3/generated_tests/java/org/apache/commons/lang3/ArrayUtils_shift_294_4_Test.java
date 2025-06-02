package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
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

public class ArrayUtils_shift_294_4_Test {

    @Test
    public void testShiftPositiveOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 2);
        assertArrayEquals(new Object[] { 3, 4, 5, 1, 2 }, array);
    }

    @Test
    public void testShiftNegativeOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, -1);
        assertArrayEquals(new Object[] { 5, 1, 2, 3, 4 }, array);
    }

    @Test
    public void testShiftZeroOffset() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 0);
        assertArrayEquals(new Object[] { 1, 2, 3, 4, 5 }, array);
    }

    @Test
    public void testShiftLargerThanArraySize() {
        Object[] array = { 1, 2, 3, 4, 5 };
        ArrayUtils.shift(array, 7);
        assertArrayEquals(new Object[] { 4, 5, 1, 2, 3 }, array);
    }

    @Test
    public void testShiftEmptyArray() {
        Object[] array = {};
        ArrayUtils.shift(array, 2);
        assertArrayEquals(new Object[] {}, array);
    }

    @Test
    public void testShiftSingleElementArray() {
        Object[] array = { 1 };
        ArrayUtils.shift(array, 1);
        assertArrayEquals(new Object[] { 1 }, array);
    }
}
