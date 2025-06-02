package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

class SingletonListIterator_remove_7_3_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    void setUp() {
        iterator = new SingletonListIterator<>("Test Object");
    }

    @Test
    void testRemoveThrowsIllegalStateExceptionBeforeNextCalled() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
        assertEquals("IllegalStateException expected", exception.getMessage());
    }

    @Test
    void testRemoveThrowsIllegalStateExceptionAfterRemoveCalled() {
        iterator.next();
        iterator.remove();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
        assertEquals("IllegalStateException expected", exception.getMessage());
    }

    @Test
    void testRemoveSetsObjectToNullAndRemovedToTrue() throws NoSuchFieldException, IllegalAccessException {
        iterator.next();
        iterator.remove();
        Field objectField = SingletonListIterator.class.getDeclaredField("object");
        objectField.setAccessible(true);
        Object objectValue = objectField.get(iterator);
        Field removedField = SingletonListIterator.class.getDeclaredField("removed");
        removedField.setAccessible(true);
        boolean removedValue = removedField.getBoolean(iterator);
        assertNull(objectValue);
        assertTrue(removedValue);
    }

    @Test
    void testRemoveWorksCorrectlyAfterNext() throws NoSuchFieldException, IllegalAccessException {
        iterator.next();
        assertDoesNotThrow(() -> {
            iterator.remove();
        });
        Field objectField = SingletonListIterator.class.getDeclaredField("object");
        objectField.setAccessible(true);
        Object objectValue = objectField.get(iterator);
        Field removedField = SingletonListIterator.class.getDeclaredField("removed");
        removedField.setAccessible(true);
        boolean removedValue = removedField.getBoolean(iterator);
        assertNull(objectValue);
        assertTrue(removedValue);
    }
}
