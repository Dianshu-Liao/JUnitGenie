package org.apache.commons.collections4.list;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.Factory;
import java.lang.reflect.Method;
import java.util.Collections;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Objects;

public class LazyList_element_2_0_Test {

    @Test
    public void testElementWithTransformerNotNull() throws Exception {
        // Arrange
        Transformer<Integer, String> transformer = index -> "Element " + index;
        LazyList<String> lazyList = new LazyList<>(Collections.emptyList(), transformer);
        // Act
        String result = invokeElementMethod(lazyList, 5);
        // Assert
        assertEquals("Element 5", result);
    }

    @Test
    public void testElementWithTransformerNotNullMultipleCalls() throws Exception {
        // Arrange
        Transformer<Integer, String> transformer = index -> "Element " + index;
        LazyList<String> lazyList = new LazyList<>(Collections.emptyList(), transformer);
        // Act
        String result1 = invokeElementMethod(lazyList, 1);
        String result2 = invokeElementMethod(lazyList, 2);
        String result3 = invokeElementMethod(lazyList, 3);
        // Assert
        assertEquals("Element 1", result1);
        assertEquals("Element 2", result2);
        assertEquals("Element 3", result3);
    }

    @Test
    public void testElementWithBothFactoryAndTransformerNull() {
        // Arrange
        LazyList<String> lazyList = new LazyList<>(Collections.emptyList(), (Factory<String>) null);
        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            invokeElementMethod(lazyList, 0);
        });
        assertEquals("Factory and Transformer are both null!", exception.getMessage());
    }

    private String invokeElementMethod(LazyList<String> lazyList, int index) throws Exception {
        Method method = LazyList.class.getDeclaredMethod("element", int.class);
        method.setAccessible(true);
        return (String) method.invoke(lazyList, index);
    }
}
