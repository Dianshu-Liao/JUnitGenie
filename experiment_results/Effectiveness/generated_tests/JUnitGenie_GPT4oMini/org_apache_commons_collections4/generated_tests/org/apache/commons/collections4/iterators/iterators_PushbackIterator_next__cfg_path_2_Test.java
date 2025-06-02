package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PushbackIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class iterators_PushbackIterator_next__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextWhenItemsNotEmpty() {
        // Arrange
        Deque<Object> items = new ArrayDeque<>();
        items.push(new Object()); // Add an item to the deque
        Iterator<Object> iterator = new ArrayDeque<Object>().iterator(); // Empty iterator
        PushbackIterator pushbackIterator = new PushbackIterator(iterator);
        // Access the private field 'items' using reflection
        try {
            java.lang.reflect.Field field = PushbackIterator.class.getDeclaredField("items");
            field.setAccessible(true);
            field.set(pushbackIterator, items);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        // Act
        Object result = pushbackIterator.next();

        // Assert
        assertNotNull(result);
        assertEquals("Expected the popped item to be returned", items.peek(), result);
    }

    @Test(timeout = 4000)
    public void testNextWhenItemsEmpty() {
        // Arrange
        Deque<Object> items = new ArrayDeque<>(); // Empty deque
        Iterator<Object> iterator = new ArrayDeque<Object>() {{ add(new Object()); }}.iterator(); // Non-empty iterator
        PushbackIterator pushbackIterator = new PushbackIterator(iterator);
        // Access the private field 'items' using reflection
        try {
            java.lang.reflect.Field field = PushbackIterator.class.getDeclaredField("items");
            field.setAccessible(true);
            field.set(pushbackIterator, items);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        // Act
        Object result = pushbackIterator.next();

        // Assert
        assertNotNull(result);
    }

}