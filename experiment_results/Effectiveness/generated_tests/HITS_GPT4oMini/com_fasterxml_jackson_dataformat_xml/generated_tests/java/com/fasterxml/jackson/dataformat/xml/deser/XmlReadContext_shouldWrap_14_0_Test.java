package com.fasterxml.jackson.dataformat.xml.deser;

import java.util.HashSet;
import java.util.Set;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.ContentReference;

public class XmlReadContext_shouldWrap_14_0_Test {

    private XmlReadContext xmlReadContext;

    @BeforeEach
    public void setUp() {
        // Initializing a parent context to pass to the XmlReadContext constructor
        // No parent for the root context
        XmlReadContext parentContext = null;
        xmlReadContext = new XmlReadContext(parentContext, 0, 0, 1, 1);
    }

    @Test
    public void testShouldWrap_WhenNamesToWrapIsNull_ReturnsFalse() {
        // Arrange
        xmlReadContext.setNamesToWrap(null);
        String localName = "testName";
        // Act
        boolean result = xmlReadContext.shouldWrap(localName);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testShouldWrap_WhenNamesToWrapIsEmpty_ReturnsFalse() {
        // Arrange
        xmlReadContext.setNamesToWrap(new HashSet<>());
        String localName = "testName";
        // Act
        boolean result = xmlReadContext.shouldWrap(localName);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testShouldWrap_WhenLocalNameIsInNamesToWrap_ReturnsTrue() {
        // Arrange
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("testName");
        xmlReadContext.setNamesToWrap(namesToWrap);
        String localName = "testName";
        // Act
        boolean result = xmlReadContext.shouldWrap(localName);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testShouldWrap_WhenLocalNameIsNotInNamesToWrap_ReturnsFalse() {
        // Arrange
        Set<String> namesToWrap = new HashSet<>();
        namesToWrap.add("anotherName");
        xmlReadContext.setNamesToWrap(namesToWrap);
        String localName = "testName";
        // Act
        boolean result = xmlReadContext.shouldWrap(localName);
        // Assert
        assertFalse(result);
    }
}
