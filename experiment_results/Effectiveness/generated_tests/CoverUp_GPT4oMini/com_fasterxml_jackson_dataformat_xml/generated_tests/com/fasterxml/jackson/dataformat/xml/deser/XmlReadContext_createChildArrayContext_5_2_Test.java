package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Field;
import java.util.HashSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Set;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.ContentReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class XmlReadContext_createChildArrayContext_5_2_Test {

    private XmlReadContext context;

    @BeforeEach
    public void setUp() {
        context = new XmlReadContext(null, 0, 0, 0, 0);
    }

    @Test
    public void testCreateChildArrayContext_NewChild() throws Exception {
        XmlReadContext childContext = context.createChildArrayContext(1, 2);
        assertNotNull(childContext);
        assertEquals(1, getFieldValue(childContext, "_lineNr"));
        assertEquals(2, getFieldValue(childContext, "_columnNr"));
        assertEquals(1, getFieldValue(childContext, "_nestingDepth"));
    }

    @Test
    public void testCreateChildArrayContext_ReuseChild() throws Exception {
        XmlReadContext firstChild = context.createChildArrayContext(1, 2);
        XmlReadContext secondChild = context.createChildArrayContext(3, 4);
        assertSame(firstChild, secondChild);
        assertEquals(3, getFieldValue(secondChild, "_lineNr"));
        assertEquals(4, getFieldValue(secondChild, "_columnNr"));
    }

    @Test
    public void testCreateChildArrayContext_ChildReset() throws Exception {
        XmlReadContext childContext = context.createChildArrayContext(1, 2);
        childContext.setCurrentName("test");
        XmlReadContext reusedChild = context.createChildArrayContext(3, 4);
        assertSame(childContext, reusedChild);
        assertNull(getFieldValue(reusedChild, "_currentName"));
        assertEquals(3, getFieldValue(reusedChild, "_lineNr"));
        assertEquals(4, getFieldValue(reusedChild, "_columnNr"));
    }

    // Reflection helper methods
    private int getNestingDepth(XmlReadContext context) throws Exception {
        return (int) getFieldValue(context, "_nestingDepth");
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
