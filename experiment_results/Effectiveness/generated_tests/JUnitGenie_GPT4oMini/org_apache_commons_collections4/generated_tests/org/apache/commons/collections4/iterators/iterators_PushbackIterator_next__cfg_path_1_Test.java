package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.PushbackIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class iterators_PushbackIterator_next__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextWhenItemsNotEmpty() {
        // Arrange
        Deque<Object> items = new ArrayDeque<>();
        items.push("item1");
        items.push("item2");
        PushbackIterator<Object> iterator = new PushbackIterator<>(new Iterator<Object>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < 2;
            }

            @Override
            public Object next() {
                return count++ == 0 ? "iterItem1" : "iterItem2";
            }
        });
        
        // Act
        Object result = iterator.next();

        // Assert
        assertEquals("item2", result); // The last pushed item should be returned
    }

    @Test(timeout = 4000)
    public void testNextWhenItemsEmpty() {
        // Arrange
        Deque<Object> items = new ArrayDeque<>();
        PushbackIterator<Object> iterator = new PushbackIterator<>(new Iterator<Object>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < 2;
            }

            @Override
            public Object next() {
                return count++ == 0 ? "iterItem1" : "iterItem2";
            }
        });

        // Act
        Object result1 = iterator.next(); // This should return "iterItem1"
        Object result2 = iterator.next(); // This should return "iterItem2"

        // Assert
        assertEquals("iterItem1", result1);
        assertEquals("iterItem2", result2);
    }

}