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

public class XmlReadContext_createChildObjectContext_6_0_Test {

    private XmlReadContext parentContext;

    private XmlReadContext childContext;

    @BeforeEach
    public void setUp() {
        parentContext = new XmlReadContext(null, 0, 0, 0);
    }

    @Test
    public void testCreateChildObjectContext_FirstTime() {
        childContext = parentContext.createChildObjectContext(1, 1);
        assertNotNull(childContext);
        assertEquals(1, childContext._lineNr);
        assertEquals(1, childContext._columnNr);
    }

    @Test
    public void testCreateChildObjectContext_ReuseChild() {
        childContext = parentContext.createChildObjectContext(1, 1);
        XmlReadContext reusedChildContext = parentContext.createChildObjectContext(2, 2);
        assertEquals(childContext, reusedChildContext);
        assertEquals(2, reusedChildContext._lineNr);
        assertEquals(2, reusedChildContext._columnNr);
    }
}
