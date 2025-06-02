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

public class ArrayUtils_isSameLength_145_0_Test {

    @Test
    public void testIsSameLength_BothArraysNull() {
        assertTrue(ArrayUtils.isSameLength((Object[]) null, (Object[]) null));
    }

    @Test
    public void testIsSameLength_FirstArrayNull() {
        assertFalse(ArrayUtils.isSameLength(null, new Object[5]));
    }

    @Test
    public void testIsSameLength_SecondArrayNull() {
        assertFalse(ArrayUtils.isSameLength(new Object[5], null));
    }

    @Test
    public void testIsSameLength_ArraysOfSameLength() {
        assertTrue(ArrayUtils.isSameLength(new Object[3], new Object[3]));
    }

    @Test
    public void testIsSameLength_ArraysOfDifferentLength() {
        assertFalse(ArrayUtils.isSameLength(new Object[2], new Object[3]));
    }

    @Test
    public void testIsSameLength_EmptyArrays() {
        assertTrue(ArrayUtils.isSameLength(new Object[0], new Object[0]));
    }

    @Test
    public void testIsSameLength_OneEmptyArray() {
        assertFalse(ArrayUtils.isSameLength(new Object[0], new Object[1]));
        assertFalse(ArrayUtils.isSameLength(new Object[1], new Object[0]));
    }
}
