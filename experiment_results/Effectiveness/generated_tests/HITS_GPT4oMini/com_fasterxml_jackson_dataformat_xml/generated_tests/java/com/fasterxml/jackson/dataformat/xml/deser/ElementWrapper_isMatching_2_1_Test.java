package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ElementWrapper_isMatching_2_1_Test {

    private ElementWrapper createElementWrapper(String wrapperName, String wrapperNamespace) {
        try {
            Constructor<ElementWrapper> constructor = ElementWrapper.class.getDeclaredConstructor(ElementWrapper.class, String.class, String.class);
            // Make the constructor accessible
            constructor.setAccessible(true);
            return constructor.newInstance(null, wrapperName, wrapperNamespace);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ElementWrapper instance", e);
        }
    }

    @Test
    void testIsMatching_WhenWrapperNameIsNotNull_ShouldReturnTrue() {
        // Arrange
        ElementWrapper elementWrapper = createElementWrapper("testName", "testNamespace");
        // Act
        boolean result = elementWrapper.isMatching();
        // Assert
        assertTrue(result, "Expected isMatching() to return true when _wrapperName is not null.");
    }

    @Test
    void testIsMatching_WhenWrapperNameIsNull_ShouldReturnFalse() {
        // Arrange
        ElementWrapper elementWrapper = createElementWrapper(null, "testNamespace");
        // Act
        boolean result = elementWrapper.isMatching();
        // Assert
        assertFalse(result, "Expected isMatching() to return false when _wrapperName is null.");
    }

    @Test
    void testIsMatching_WhenWrapperNameIsEmpty_ShouldReturnTrue() {
        // Arrange
        ElementWrapper elementWrapper = createElementWrapper("", "testNamespace");
        // Act
        boolean result = elementWrapper.isMatching();
        // Assert
        assertTrue(result, "Expected isMatching() to return true when _wrapperName is an empty string.");
    }
}
