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

public class XmlReadContext_createChildArrayContext_5_0_Test {

    private XmlReadContext parentContext;

    private XmlReadContext childContext;

    @BeforeEach
    public void setUp() {
        parentContext = new XmlReadContext(null, 0, 0, 1, 1);
        childContext = parentContext.createChildArrayContext(2, 2);
    }

    @Test
    public void testCreateChildArrayContext_NewChild() throws Exception {
        assertNotNull(childContext, "Child context should not be null");
        assertEquals(2, getLineNr(childContext), "Line number should match");
        assertEquals(2, getColumnNr(childContext), "Column number should match");
        assertEquals(1, getNestingDepth(parentContext), "Nesting depth of parent should be 1");
        assertEquals(2, getNestingDepth(childContext), "Nesting depth of child should be 2");
    }

    @Test
    public void testCreateChildArrayContext_ResetsExistingChild() throws Exception {
        XmlReadContext existingChild = parentContext.createChildArrayContext(3, 3);
        assertEquals(3, getLineNr(existingChild), "Line number should be reset to new value");
        assertEquals(3, getColumnNr(existingChild), "Column number should be reset to new value");
        assertNotSame(childContext, existingChild, "Existing child should be a new instance");
    }

    @Test
    public void testIncrementIndex() throws Exception {
        XmlReadContext newChild = parentContext.createChildArrayContext(1, 1);
        Field indexField = XmlReadContext.class.getDeclaredField("_index");
        indexField.setAccessible(true);
        int indexValue = (int) indexField.get(newChild);
        assertEquals(0, indexValue, "Initial index should be 0 after creation");
        parentContext.createChildArrayContext(2, 2);
        indexValue = (int) indexField.get(newChild);
        assertEquals(1, indexValue, "Index should be incremented to 1");
    }

    private int getLineNr(XmlReadContext context) throws Exception {
        Field lineNrField = XmlReadContext.class.getDeclaredField("_lineNr");
        lineNrField.setAccessible(true);
        return (int) lineNrField.get(context);
    }

    private int getColumnNr(XmlReadContext context) throws Exception {
        Field columnNrField = XmlReadContext.class.getDeclaredField("_columnNr");
        columnNrField.setAccessible(true);
        return (int) columnNrField.get(context);
    }

    private int getNestingDepth(XmlReadContext context) throws Exception {
        Field nestingDepthField = XmlReadContext.class.getDeclaredField("_nestingDepth");
        nestingDepthField.setAccessible(true);
        return (int) nestingDepthField.get(context);
    }
}
