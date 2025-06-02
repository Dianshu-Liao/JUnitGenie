package com.fasterxml.jackson.dataformat.xml.deser;

import java.lang.reflect.Method;
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

    private XmlReadContext context;

    @BeforeEach
    public void setUp() {
        context = new XmlReadContext(null, 0, 0, 1, 1);
    }

    @Test
    public void testCreateChildArrayContext_NewChild() throws Exception {
        // Arrange
        int lineNr = 2;
        int colNr = 3;
        // Act
        XmlReadContext childContext = invokeCreateChildArrayContext(context, lineNr, colNr);
        // Assert
        assertNotNull(childContext);
        assertEquals(1, getNestingDepth(childContext));
        assertEquals(lineNr, getLineNr(childContext));
        assertEquals(colNr, getColNr(childContext));
    }

    @Test
    public void testCreateChildArrayContext_ExistingChild() throws Exception {
        // Arrange
        int lineNr1 = 2;
        int colNr1 = 3;
        // Create the first child
        context.createChildArrayContext(lineNr1, colNr1);
        int lineNr2 = 4;
        int colNr2 = 5;
        // Act
        XmlReadContext childContext = invokeCreateChildArrayContext(context, lineNr2, colNr2);
        // Assert
        assertNotNull(childContext);
        assertEquals(1, getNestingDepth(childContext));
        assertEquals(lineNr2, getLineNr(childContext));
        assertEquals(colNr2, getColNr(childContext));
    }

    private XmlReadContext invokeCreateChildArrayContext(XmlReadContext context, int lineNr, int colNr) throws Exception {
        Method method = XmlReadContext.class.getDeclaredMethod("createChildArrayContext", int.class, int.class);
        method.setAccessible(true);
        return (XmlReadContext) method.invoke(context, lineNr, colNr);
    }

    private int getNestingDepth(XmlReadContext context) throws Exception {
        Method method = XmlReadContext.class.getDeclaredMethod("getNestingDepth");
        method.setAccessible(true);
        return (int) method.invoke(context);
    }

    private int getLineNr(XmlReadContext context) throws Exception {
        Method method = XmlReadContext.class.getDeclaredMethod("getLineNr");
        method.setAccessible(true);
        return (int) method.invoke(context);
    }

    private int getColNr(XmlReadContext context) throws Exception {
        Method method = XmlReadContext.class.getDeclaredMethod("getColNr");
        method.setAccessible(true);
        return (int) method.invoke(context);
    }
}
