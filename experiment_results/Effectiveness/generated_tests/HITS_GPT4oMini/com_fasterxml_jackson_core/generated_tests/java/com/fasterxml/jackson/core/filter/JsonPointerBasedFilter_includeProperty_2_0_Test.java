package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JsonPointerBasedFilter_includeProperty_2_0_Test {

    private JsonPointerBasedFilter filter;

    @BeforeEach
    void setUp() {
        // Initialize the filter with a sample JsonPointer
        JsonPointer pointer = JsonPointer.compile("/samplePath");
        filter = new JsonPointerBasedFilter(pointer);
    }

    @Test
    void testIncludeProperty_MatchingProperty() {
        // Arrange
        String propertyName = "samplePath";
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertNotNull(result);
        assertEquals(TokenFilter.INCLUDE_ALL, result);
    }

    @Test
    void testIncludeProperty_NonMatchingProperty() {
        // Arrange
        String propertyName = "nonMatchingPath";
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertNull(result);
    }

    @Test
    void testIncludeProperty_EmptyProperty() {
        // Arrange
        String propertyName = "";
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertNull(result);
    }

    @Test
    void testIncludeProperty_NullProperty() {
        // Act
        TokenFilter result = filter.includeProperty(null);
        // Assert
        assertNull(result);
    }

    @Test
    void testIncludeProperty_WithMatchingNestedProperty() {
        // Arrange
        JsonPointer nestedPointer = JsonPointer.compile("/nested/sample");
        filter = new JsonPointerBasedFilter(nestedPointer);
        String propertyName = "nested";
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertNotNull(result);
        assertEquals(TokenFilter.INCLUDE_ALL, result);
    }
}
