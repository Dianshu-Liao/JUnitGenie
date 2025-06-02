package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class iterators_PeekingIterator_fill__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFillWhenExhaustedAndSlotFilled() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);

        // Set the private fields to simulate the state
        setPrivateField(peekingIterator, "exhausted", true);
        setPrivateField(peekingIterator, "slotFilled", true);

        // Access the private method using reflection
        Method fillMethod = PeekingIterator.class.getDeclaredMethod("fill");
        fillMethod.setAccessible(true);
        fillMethod.invoke(peekingIterator);

        // Assert that slot is still null and slotFilled is false
        assertNull(getPrivateField(peekingIterator, "slot"));
        assertFalse((Boolean) getPrivateField(peekingIterator, "slotFilled"));
    }

    @Test(timeout = 4000)
    public void testFillWhenIteratorHasNoNext() throws Exception {
        List<Integer> list = Arrays.asList();
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(iterator);

        // Access the private method using reflection
        Method fillMethod = PeekingIterator.class.getDeclaredMethod("fill");
        fillMethod.setAccessible(true);
        fillMethod.invoke(peekingIterator);

        // Assert that exhausted is true and slot is null
        assertTrue((Boolean) getPrivateField(peekingIterator, "exhausted")); // Fixed assertTrue usage
        assertNull(getPrivateField(peekingIterator, "slot"));
    }

    private Object getPrivateField(PeekingIterator<?> peekingIterator, String fieldName) throws Exception {
        java.lang.reflect.Field field = PeekingIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(peekingIterator);
    }

    private void setPrivateField(PeekingIterator<?> peekingIterator, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = PeekingIterator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(peekingIterator, value);
    }

}