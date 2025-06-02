package org.apache.commons.jxpath.servlet;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Variables;

public class KeywordVariables_KeywordVariables_4_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        // Arrange
        String keyword = "testKeyword";
        Object object = new Object();
        // Act
        KeywordVariables keywordVariables = new KeywordVariables(keyword, object);
        // Assert
        assertNotNull(keywordVariables);
    }

    @Test
    public void testConstructorWithNullKeyword() {
        // Arrange
        String keyword = null;
        Object object = new Object();
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new KeywordVariables(keyword, object);
        });
        assertEquals("keyword cannot be null", exception.getMessage());
    }

    @Test
    public void testConstructorWithNullObject() {
        // Arrange
        String keyword = "testKeyword";
        Object object = null;
        // Act
        KeywordVariables keywordVariables = new KeywordVariables(keyword, object);
        // Assert
        assertNotNull(keywordVariables);
    }
}
