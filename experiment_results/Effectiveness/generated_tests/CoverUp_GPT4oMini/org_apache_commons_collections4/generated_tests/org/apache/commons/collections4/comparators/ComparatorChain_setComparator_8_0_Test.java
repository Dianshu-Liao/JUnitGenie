package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ComparatorChain_setComparator_8_0_Test {

    private ComparatorChain<Integer> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testSetComparator_ValidIndex() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        comparatorChain.setComparator(0, comparator);
        // Verify that the comparator was set correctly
        assertEquals(comparator, invokePrivateMethod("getComparator", 0));
    }

    @Test
    void testSetComparator_ValidIndex_Reverse() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        comparatorChain.setComparator(0, comparator, true);
        // Verify that the comparator was set correctly and the ordering bit is set
        assertEquals(comparator, invokePrivateMethod("getComparator", 0));
        assertTrue(invokePrivateMethod("isReverseSort", 0));
    }

    @Test
    void testSetComparator_IndexOutOfBounds() {
        Comparator<Integer> comparator = Comparator.naturalOrder();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            comparatorChain.setComparator(1, comparator);
        });
    }

    @Test
    void testSetComparator_LockedState() {
        invokePrivateMethod("lock");
        Comparator<Integer> comparator = Comparator.naturalOrder();
        assertThrows(IllegalStateException.class, () -> {
            comparatorChain.setComparator(0, comparator);
        });
    }

    @Test
    void testSetComparator_ChangeExistingComparator() {
        Comparator<Integer> comparator1 = Comparator.naturalOrder();
        Comparator<Integer> comparator2 = Comparator.reverseOrder();
        comparatorChain.setComparator(0, comparator1);
        comparatorChain.setComparator(0, comparator2);
        // Verify that the comparator was changed correctly
        assertEquals(comparator2, invokePrivateMethod("getComparator", 0));
    }

    private <T> T invokePrivateMethod(String methodName, Object... args) {
        try {
            Method method = ComparatorChain.class.getDeclaredMethod(methodName, getParameterTypes(args));
            method.setAccessible(true);
            return (T) method.invoke(comparatorChain, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return Arrays.stream(args).map(arg -> arg.getClass()).toArray(Class<?>[]::new);
    }
}
