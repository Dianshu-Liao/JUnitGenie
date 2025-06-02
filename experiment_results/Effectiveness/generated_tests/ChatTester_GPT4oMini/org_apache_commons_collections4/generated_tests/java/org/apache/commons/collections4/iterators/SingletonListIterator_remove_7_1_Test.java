// Test method
package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonListIterator_remove_7_1_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    public void setUp() {
        iterator = new SingletonListIterator<>("Test");
    }

    @Test
    public void testRemove_ThrowsIllegalStateException_WhenNextNotCalled() {
        assertThrows(IllegalStateException.class, () -> {
            invokeRemoveMethod(iterator);
        });
    }

    @Test
    public void testRemove_ThrowsIllegalStateException_WhenAlreadyRemoved() throws Exception {
        // Simulate calling next
        iterator.next();
        invokeRemoveMethod(iterator);
        assertThrows(IllegalStateException.class, () -> {
            // Call remove second time
            invokeRemoveMethod(iterator);
        });
    }

    @Test
    public void testRemove_SuccessfullyRemovesElement_WhenNextCalled() throws Exception {
        // Simulate calling next
        iterator.next();
        assertDoesNotThrow(() -> {
            invokeRemoveMethod(iterator);
        });
        assertNull(getObjectField(iterator));
    }

    private void invokeRemoveMethod(SingletonListIterator<?> iterator) throws Exception {
        Method method = SingletonListIterator.class.getDeclaredMethod("remove");
        method.setAccessible(true);
        method.invoke(iterator);
    }

    private Object getObjectField(SingletonListIterator<?> iterator) throws Exception {
        Field field = SingletonListIterator.class.getDeclaredField("object");
        field.setAccessible(true);
        return field.get(iterator);
    }
}
