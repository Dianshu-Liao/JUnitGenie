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

class XmlReadContext_createChildObjectContext_6_1_Test {

    private XmlReadContext parentContext;

    private final int LINE_NR = 1;

    private final int COL_NR = 1;

    @BeforeEach
    void setUp() {
        parentContext = new XmlReadContext(null, 0, 0, LINE_NR, COL_NR);
    }

    @Test
    void testCreateChildObjectContext_NewChild() {
        XmlReadContext childContext = parentContext.createChildObjectContext(LINE_NR, COL_NR);
        assertNotNull(childContext);
        assertEquals(LINE_NR, childContext._lineNr);
        assertEquals(COL_NR, childContext._columnNr);
        assertEquals(parentContext, childContext.getParent());
    }

    @Test
    void testCreateChildObjectContext_ExistingChildReset() {
        XmlReadContext childContext = parentContext.createChildObjectContext(LINE_NR, COL_NR);
        assertNotNull(childContext);
        // Reset child context with new values
        int newLineNr = 2;
        int newColNr = 2;
        XmlReadContext resetChildContext = parentContext.createChildObjectContext(newLineNr, newColNr);
        // Should return the same instance
        assertSame(childContext, resetChildContext);
        assertEquals(newLineNr, resetChildContext._lineNr);
        assertEquals(newColNr, resetChildContext._columnNr);
    }

    @Test
    void testCreateChildObjectContext_MultipleCalls() {
        XmlReadContext firstChild = parentContext.createChildObjectContext(LINE_NR, COL_NR);
        XmlReadContext secondChild = parentContext.createChildObjectContext(LINE_NR + 1, COL_NR + 1);
        // Should return the same instance
        assertSame(firstChild, secondChild);
        assertEquals(LINE_NR + 1, secondChild._lineNr);
        assertEquals(COL_NR + 1, secondChild._columnNr);
    }
}
