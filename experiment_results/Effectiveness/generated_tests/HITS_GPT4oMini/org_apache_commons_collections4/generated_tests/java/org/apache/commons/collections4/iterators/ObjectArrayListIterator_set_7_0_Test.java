package org.apache.commons.collections4.iterators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

class ObjectArrayListIterator_set_7_0_Test {

    private ObjectArrayListIterator<String> iterator;

    private String[] array;

    @BeforeEach
    void setUp() {
        array = new String[5];
        iterator = new ObjectArrayListIterator<>(array);
    }

    @Test
    void testSetWithoutCallingNextOrPrevious() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            iterator.set("New Value");
        });
        assertEquals("must call next() or previous() before a call to set()", exception.getMessage());
    }

    @Test
    void testSetAfterCallingNext() {
        // Simulating calling next
        iterator.next();
        iterator.set("New Value");
        // Assuming next() sets lastItemIndex to 0
        assertEquals("New Value", array[0]);
    }

    @Test
    void testSetAfterCallingPrevious() {
        // Simulating calling previous
        iterator.previous();
        iterator.set("New Value");
        // Assuming previous() sets lastItemIndex to 0
        assertEquals("New Value", array[0]);
    }

    @Test
    void testSetUpdatesCorrectIndex() {
        // Simulating calling next
        iterator.next();
        // Assuming next() sets lastItemIndex to 0
        int indexBeforeSet = 0;
        iterator.set("Updated Value");
        assertEquals("Updated Value", array[indexBeforeSet]);
    }

    @Test
    void testSetWithNullValue() {
        // Simulating calling next
        iterator.next();
        iterator.set(null);
        // Assuming next() sets lastItemIndex to 0
        assertNull(array[0]);
    }
}
