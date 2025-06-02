package com.fasterxml.jackson.dataformat.xml.deser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.ContentReference;

public class XmlReadContext_hasCurrentName_8_0_Test {

    private XmlReadContext context;

    @BeforeEach
    public void setUp() {
        context = XmlReadContext.createRootContext(1, 0);
    }

    @Test
    public void testHasCurrentName_WhenCurrentNameIsNull_ReturnsFalse() {
        // Arrange
        // Current name is null by default
        // Act
        boolean result = context.hasCurrentName();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testHasCurrentName_WhenCurrentNameIsNotNull_ReturnsTrue() {
        // Arrange
        context.setCurrentName("testName");
        // Act
        boolean result = context.hasCurrentName();
        // Assert
        assertTrue(result);
    }

    @Test
    public void testSetCurrentName() {
        // Arrange
        String name = "newName";
        // Act
        context.setCurrentName(name);
        // Assert
        assertEquals(name, context.getCurrentName());
    }

    @Test
    public void testReset() {
        // Arrange
        context.setCurrentName("testName");
        context.setCurrentValue(new Object());
        // Act
        context.reset(0, 1, 1);
        // Assert
        assertNull(context.getCurrentName());
        assertNull(context.getCurrentValue());
        assertEquals(1, context._lineNr);
        assertEquals(1, context._columnNr);
    }
}
