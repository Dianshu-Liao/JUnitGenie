package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Method;
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

public class XmlReadContext_createChildObjectContext_6_0_Test {

    private XmlReadContext xmlReadContext;

    @BeforeEach
    public void setUp() {
        xmlReadContext = new XmlReadContext(null, 0, 0, 0, 0);
    }

    @Test
    public void testCreateChildObjectContext_NewChild() throws Exception {
        int lineNr = 1;
        int colNr = 1;
        XmlReadContext childContext = xmlReadContext.createChildObjectContext(lineNr, colNr);
        assertNotNull(childContext);
        assertSame(childContext, xmlReadContext._child);
        assertEquals(lineNr, getLineNr(childContext));
        assertEquals(colNr, getColumnNr(childContext));
    }

    @Test
    public void testCreateChildObjectContext_ExistingChild() throws Exception {
        int initialLineNr = 1;
        int initialColNr = 1;
        xmlReadContext.createChildObjectContext(initialLineNr, initialColNr);
        int newLineNr = 2;
        int newColNr = 2;
        XmlReadContext childContext = xmlReadContext.createChildObjectContext(newLineNr, newColNr);
        assertNotNull(childContext);
        assertSame(childContext, xmlReadContext._child);
        assertEquals(newLineNr, getLineNr(childContext));
        assertEquals(newColNr, getColumnNr(childContext));
    }

    @Test
    public void testCreateChildObjectContext_ChildReset() throws Exception {
        int initialLineNr = 1;
        int initialColNr = 1;
        xmlReadContext.createChildObjectContext(initialLineNr, initialColNr);
        int newLineNr = 3;
        int newColNr = 3;
        XmlReadContext childContext = xmlReadContext.createChildObjectContext(newLineNr, newColNr);
        assertNotNull(childContext);
        assertEquals(newLineNr, getLineNr(childContext));
        assertEquals(newColNr, getColumnNr(childContext));
    }

    // Assuming there is a private reset method in XmlReadContext
    private void invokeReset(XmlReadContext context, int type, int lineNr, int colNr) throws Exception {
        Method resetMethod = XmlReadContext.class.getDeclaredMethod("reset", int.class, int.class, int.class);
        resetMethod.setAccessible(true);
        resetMethod.invoke(context, type, lineNr, colNr);
    }

    // Reflection methods to access private fields
    private int getLineNr(XmlReadContext context) throws Exception {
        Method getLineNrMethod = XmlReadContext.class.getDeclaredMethod("getLineNr");
        getLineNrMethod.setAccessible(true);
        return (int) getLineNrMethod.invoke(context);
    }

    private int getColumnNr(XmlReadContext context) throws Exception {
        Method getColumnNrMethod = XmlReadContext.class.getDeclaredMethod("getColumnNr");
        getColumnNrMethod.setAccessible(true);
        return (int) getColumnNrMethod.invoke(context);
    }
}
