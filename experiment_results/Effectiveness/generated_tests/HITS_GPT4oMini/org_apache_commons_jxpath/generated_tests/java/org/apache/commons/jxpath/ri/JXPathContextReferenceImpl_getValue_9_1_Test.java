package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import org.apache.commons.jxpath.CompiledExpression;
import org.apache.commons.jxpath.ExceptionHandler;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.LocationPath;
import org.apache.commons.jxpath.ri.compiler.Path;
import org.apache.commons.jxpath.ri.compiler.TreeCompiler;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

public class JXPathContextReferenceImpl_getValue_9_1_Test {

    private JXPathContextReferenceImpl context;

    @BeforeEach
    public void setUp() {
        context = new JXPathContextReferenceImpl(null, new Object());
    }

    @Test
    public void testGetValue_ValidXPath_ReturnsCorrectValue() {
        context.setValue("/example", "testValue");
        Object result = context.getValue("/example", String.class);
        assertEquals("testValue", result);
    }

    @Test
    public void testGetValue_ValidXPathWithTypeConversion_ReturnsCorrectType() {
        context.setValue("/number", 42);
        Integer result = (Integer) context.getValue("/number", Integer.class);
        assertEquals(Integer.valueOf(42), result);
    }

    @Test
    public void testGetValue_InvalidXPath_ThrowsJXPathNotFoundException() {
        assertThrows(JXPathNotFoundException.class, () -> {
            context.getValue("/invalidPath", String.class);
        });
    }

    @Test
    public void testGetValue_TypeMismatch_ThrowsJXPathTypeConversionException() {
        context.setValue("/example", "stringValue");
        assertThrows(JXPathTypeConversionException.class, () -> {
            context.getValue("/example", Integer.class);
        });
    }

    @Test
    public void testGetValue_NullValue_ReturnsNull() {
        context.setValue("/example", null);
        Object result = context.getValue("/example", String.class);
        assertNull(result);
    }

    @Test
    public void testGetValue_NullRequiredType_ReturnsValue() {
        context.setValue("/example", "testValue");
        Object result = context.getValue("/example", String.class);
        assertEquals("testValue", result);
    }

    @Test
    public void testGetValue_EmptyXPath_ThrowsJXPathInvalidSyntaxException() {
        assertThrows(JXPathInvalidSyntaxException.class, () -> {
            context.getValue("", String.class);
        });
    }

    @Test
    public void testGetValue_ValidXPathWithNullContext_ReturnsNull() {
        context = new JXPathContextReferenceImpl(null, null);
        Object result = context.getValue("/example", String.class);
        assertNull(result);
    }
}
