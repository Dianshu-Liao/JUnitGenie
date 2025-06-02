package org.apache.commons.collections4.iterators;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.ResettableListIterator;

class SingletonListIterator_next_3_0_Test {

    private SingletonListIterator<String> iterator;

    @BeforeEach
    void setUp() {
        iterator = new SingletonListIterator<>("test");
    }

    @Test
    void testNextReturnsElement() {
        // Act
        String result = iterator.next();
        // Assert
        assertEquals("test", result);
    }

    @Test
    void testNextThrowsNoSuchElementExceptionWhenCalledTwice() {
        // Act
        iterator.next();
        // Assert
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementExceptionWhenRemoved() throws Exception {
        // Act
        iterator.next();
        invokePrivateMethod(iterator, "remove");
        // Assert
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementExceptionBeforeFirst() {
        // Assert
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    private void invokePrivateMethod(SingletonListIterator<?> iterator, String methodName) throws Exception {
        Method method = iterator.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(iterator);
    }
}
