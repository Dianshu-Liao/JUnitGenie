package org.apache.commons.jxpath.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.DynamicPropertyHandler;
import org.apache.commons.jxpath.JXPathException;

public class ValueUtils_getValue_14_1_Test {

    @Test
    public void testGetValue_WithNonContainerObject() {
        // Arrange
        String expectedValue = "Test String";
        // Act
        Object result = ValueUtils.getValue(expectedValue);
        // Assert
        assertSame(expectedValue, result, "The returned value should be the same as the input non-container object.");
    }

    @Test
    public void testGetValue_WithContainerObject() {
        // Arrange
        Container mockContainer = Mockito.mock(Container.class);
        String innerValue = "Inner Value";
        Mockito.when(mockContainer.getValue()).thenReturn(innerValue);
        // Act
        Object result = ValueUtils.getValue(mockContainer);
        // Assert
        assertEquals(innerValue, result, "The returned value should be the value from the container.");
    }

    @Test
    public void testGetValue_WithNestedContainerObject() {
        // Arrange
        Container innerContainer = Mockito.mock(Container.class);
        String innerValue = "Inner Value";
        Mockito.when(innerContainer.getValue()).thenReturn(innerValue);
        Container outerContainer = Mockito.mock(Container.class);
        Mockito.when(outerContainer.getValue()).thenReturn(innerContainer);
        // Act
        Object result = ValueUtils.getValue(outerContainer);
        // Assert
        assertEquals(innerValue, result, "The returned value should be the value from the innermost container.");
    }

    @Test
    public void testGetValue_WithMultipleNestedContainers() {
        // Arrange
        Container deepestContainer = Mockito.mock(Container.class);
        String finalValue = "Final Value";
        Mockito.when(deepestContainer.getValue()).thenReturn(finalValue);
        Container middleContainer = Mockito.mock(Container.class);
        Mockito.when(middleContainer.getValue()).thenReturn(deepestContainer);
        Container outerContainer = Mockito.mock(Container.class);
        Mockito.when(outerContainer.getValue()).thenReturn(middleContainer);
        // Act
        Object result = ValueUtils.getValue(outerContainer);
        // Assert
        assertEquals(finalValue, result, "The returned value should be the value from the deepest container.");
    }
}
