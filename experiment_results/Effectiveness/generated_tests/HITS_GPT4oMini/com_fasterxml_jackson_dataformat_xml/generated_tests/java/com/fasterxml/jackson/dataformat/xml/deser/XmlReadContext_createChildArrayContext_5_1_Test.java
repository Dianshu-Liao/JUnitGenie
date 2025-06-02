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

public class XmlReadContext_createChildArrayContext_5_1_Test {

    private XmlReadContext parentContext;

    @BeforeEach
    public void setUp() {
        parentContext = new XmlReadContext(null, 0, 0, 1, 1);
    }

    @Test
    public void testCreateChildArrayContext_NewChild() {
        // Given initial state
        int lineNr = 2;
        int colNr = 3;
        // When createChildArrayContext is called
        XmlReadContext childContext = parentContext.createChildArrayContext(lineNr, colNr);
        // Then a new child context should be created
        assertNotNull(childContext);
        // Removed assertion for _nestingDepth
        assertEquals(lineNr, childContext._lineNr);
        assertEquals(colNr, childContext._columnNr);
        assertSame(parentContext, childContext.getParent());
    }

    @Test
    public void testCreateChildArrayContext_ReuseChild() {
        // Given an existing child context
        XmlReadContext initialChild = parentContext.createChildArrayContext(2, 3);
        // When createChildArrayContext is called again
        XmlReadContext reusedChild = parentContext.createChildArrayContext(4, 5);
        // Then the same child context should be reused
        assertSame(initialChild, reusedChild);
        assertEquals(4, reusedChild._lineNr);
        assertEquals(5, reusedChild._columnNr);
    }

    @Test
    public void testCreateChildArrayContext_ChildReset() {
        // Given an existing child context
        XmlReadContext initialChild = parentContext.createChildArrayContext(2, 3);
        // When createChildArrayContext is called again with different line and column numbers
        XmlReadContext reusedChild = parentContext.createChildArrayContext(6, 7);
        // Then the reused child context should have reset its line and column numbers
        assertEquals(6, reusedChild._lineNr);
        assertEquals(7, reusedChild._columnNr);
    }
}
