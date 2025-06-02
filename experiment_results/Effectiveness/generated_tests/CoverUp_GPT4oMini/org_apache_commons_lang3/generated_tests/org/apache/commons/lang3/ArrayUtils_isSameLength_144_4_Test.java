package org.apache.commons.lang3;

import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Method;
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

class ArrayUtils_isSameLength_144_4_Test {

    @Test
    void testIsSameLengthBothNull() throws Exception {
        assertTrue(invokeIsSameLength(null, null));
    }

    @Test
    void testIsSameLengthFirstNull() throws Exception {
        assertFalse(invokeIsSameLength(null, new int[] { 1, 2, 3 }));
    }

    @Test
    void testIsSameLengthSecondNull() throws Exception {
        assertFalse(invokeIsSameLength(new int[] { 1, 2, 3 }, null));
    }

    @Test
    void testIsSameLengthDifferentLengths() throws Exception {
        assertFalse(invokeIsSameLength(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
    }

    @Test
    void testIsSameLengthSameLength() throws Exception {
        assertTrue(invokeIsSameLength(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }));
    }

    @Test
    void testIsSameLengthEmptyArrays() throws Exception {
        assertTrue(invokeIsSameLength(new int[] {}, new int[] {}));
    }

    @Test
    void testIsSameLengthEmptyAndNonEmpty() throws Exception {
        assertFalse(invokeIsSameLength(new int[] {}, new int[] { 1 }));
    }

    private boolean invokeIsSameLength(Object array1, Object array2) throws Exception {
        Method method = ArrayUtils.class.getDeclaredMethod("isSameLength", Object.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, array1, array2);
    }
}
