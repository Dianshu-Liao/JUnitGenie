package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.TruePredicate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;

public class FilterIterator_setNextObject_7_0_Test {

    private FilterIterator<Integer> filterIterator;

    @BeforeEach
    public void setUp() {
        filterIterator = new FilterIterator<>();
    }

    private boolean invokeSetNextObject() throws Exception {
        Method method = FilterIterator.class.getDeclaredMethod("setNextObject");
        method.setAccessible(true);
        return (Boolean) method.invoke(filterIterator);
    }

    @Test
    public void testSetNextObject_WithMatchingElements() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        filterIterator.setIterator(numbers.iterator());
        filterIterator.setPredicate(new Predicate<Integer>() {

            @Override
            public boolean evaluate(Integer object) {
                return object > 3;
            }
        });
        assertTrue(invokeSetNextObject(), "setNextObject should return true when there are matching elements.");
    }

    @Test
    public void testSetNextObject_WithoutMatchingElements() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        filterIterator.setIterator(numbers.iterator());
        filterIterator.setPredicate(new Predicate<Integer>() {

            @Override
            public boolean evaluate(Integer object) {
                return object > 3;
            }
        });
        assertFalse(invokeSetNextObject(), "setNextObject should return false when there are no matching elements.");
    }

    @Test
    public void testSetNextObject_EmptyIterator() throws Exception {
        List<Integer> numbers = Arrays.asList();
        filterIterator.setIterator(numbers.iterator());
        filterIterator.setPredicate(TruePredicate.truePredicate());
        assertFalse(invokeSetNextObject(), "setNextObject should return false for an empty iterator.");
    }

    @Test
    public void testSetNextObject_MultipleCalls() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        filterIterator.setIterator(numbers.iterator());
        filterIterator.setPredicate(new Predicate<Integer>() {

            @Override
            public boolean evaluate(Integer object) {
                return object > 3;
            }
        });
        assertTrue(invokeSetNextObject(), "First call should return true.");
        assertFalse(invokeSetNextObject(), "Second call should return false as the next matching element has been consumed.");
    }
}
