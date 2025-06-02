package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JsonPointerBasedFilter_includeProperty_2_1_Test {

    private JsonPointer mockJsonPointer;

    private JsonPointerBasedFilter filter;

    @BeforeEach
    void setUp() {
        mockJsonPointer = mock(JsonPointer.class);
        filter = new JsonPointerBasedFilter(mockJsonPointer, false);
    }

    @Test
    void testIncludeProperty_MatchingProperty() {
        // Arrange
        String propertyName = "testProperty";
        JsonPointer nextPointer = mock(JsonPointer.class);
        when(mockJsonPointer.matchProperty(propertyName)).thenReturn(nextPointer);
        when(nextPointer.matches()).thenReturn(true);
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertSame(TokenFilter.INCLUDE_ALL, result);
    }

    @Test
    void testIncludeProperty_NonMatchingProperty() {
        // Arrange
        String propertyName = "testProperty";
        JsonPointer nextPointer = mock(JsonPointer.class);
        when(mockJsonPointer.matchProperty(propertyName)).thenReturn(nextPointer);
        when(nextPointer.matches()).thenReturn(false);
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertSame(filter.construct(nextPointer, false), result);
    }

    @Test
    void testIncludeProperty_NoMatchingProperty() {
        // Arrange
        String propertyName = "nonExistentProperty";
        when(mockJsonPointer.matchProperty(propertyName)).thenReturn(null);
        // Act
        TokenFilter result = filter.includeProperty(propertyName);
        // Assert
        assertNull(result);
    }
}
