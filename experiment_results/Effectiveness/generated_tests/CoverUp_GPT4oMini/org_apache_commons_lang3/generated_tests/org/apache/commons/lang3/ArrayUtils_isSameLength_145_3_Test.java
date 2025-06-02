package org.apache.commons.lang3;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayUtils_isSameLength_145_3_Test {

    @Test
    public void testIsSameLength_BothArraysNull() {
        assertTrue(ArrayUtils.isSameLength((Object[]) null, (Object[]) null), "Both arrays are null, should return true");
    }

    @Test
    public void testIsSameLength_FirstArrayNull() {
        Object[] array2 = new Object[5];
        assertFalse(ArrayUtils.isSameLength((Object[]) null, array2), "First array is null, should return false");
    }

    @Test
    public void testIsSameLength_SecondArrayNull() {
        Object[] array1 = new Object[5];
        assertFalse(ArrayUtils.isSameLength(array1, (Object[]) null), "Second array is null, should return false");
    }

    @Test
    public void testIsSameLength_EqualLengthArrays() {
        Object[] array1 = new Object[5];
        Object[] array2 = new Object[5];
        assertTrue(ArrayUtils.isSameLength(array1, array2), "Both arrays have the same length, should return true");
    }

    @Test
    public void testIsSameLength_DifferentLengthArrays() {
        Object[] array1 = new Object[5];
        Object[] array2 = new Object[3];
        assertFalse(ArrayUtils.isSameLength(array1, array2), "Arrays have different lengths, should return false");
    }

    @Test
    public void testIsSameLength_EmptyArrays() {
        Object[] array1 = new Object[0];
        Object[] array2 = new Object[0];
        assertTrue(ArrayUtils.isSameLength(array1, array2), "Both arrays are empty, should return true");
    }
}
