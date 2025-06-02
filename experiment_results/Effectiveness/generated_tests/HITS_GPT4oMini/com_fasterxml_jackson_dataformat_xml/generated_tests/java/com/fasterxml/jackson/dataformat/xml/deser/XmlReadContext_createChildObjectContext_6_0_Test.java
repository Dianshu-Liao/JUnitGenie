package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Field;
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

public class XmlReadContext_createChildObjectContext_6_0_Test {

    private XmlReadContext parentContext;

    private XmlReadContext childContext;

    @BeforeEach
    public void setUp() {
        parentContext = new XmlReadContext(null, 0, 0, 1, 1);
    }

    @Test
    public void testCreateChildObjectContext_NewChild() {
        // Arrange
        int lineNr = 2;
        int colNr = 3;
        // Act
        childContext = parentContext.createChildObjectContext(lineNr, colNr);
        // Assert
        assertNotNull(childContext);
        assertEquals(lineNr, getLineNr(childContext));
        assertEquals(colNr, getColumnNr(childContext));
        assertNotSame(parentContext, childContext);
    }

    @Test
    public void testCreateChildObjectContext_ExistingChildResets() {
        // Arrange
        int lineNr1 = 2;
        int colNr1 = 3;
        int lineNr2 = 4;
        int colNr2 = 5;
        // Create the first child context
        childContext = parentContext.createChildObjectContext(lineNr1, colNr1);
        // Act
        XmlReadContext newChildContext = parentContext.createChildObjectContext(lineNr2, colNr2);
        // Assert
        assertSame(childContext, newChildContext);
        assertEquals(lineNr2, getLineNr(newChildContext));
        assertEquals(colNr2, getColumnNr(newChildContext));
    }

    @Test
    public void testCreateChildObjectContext_IncrementIndex() throws Exception {
        // Arrange
        int initialIndex = getIndex(parentContext);
        // Act
        childContext = parentContext.createChildObjectContext(2, 3);
        // Assert
        assertEquals(initialIndex + 1, getIndex(parentContext));
    }

    // Mocked getter methods for testing
    private int getLineNr(XmlReadContext context) {
        return context._lineNr;
    }

    private int getColumnNr(XmlReadContext context) {
        return context._columnNr;
    }

    private int getIndex(XmlReadContext context) throws Exception {
        Field indexField = XmlReadContext.class.getDeclaredField("_index");
        indexField.setAccessible(true);
        return (int) indexField.get(context);
    }
}
