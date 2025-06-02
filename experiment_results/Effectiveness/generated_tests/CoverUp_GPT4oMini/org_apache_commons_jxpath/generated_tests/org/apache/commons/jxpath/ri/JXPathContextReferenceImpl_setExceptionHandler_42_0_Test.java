package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ExceptionHandler;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
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
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.Functions;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.LocationPath;
import org.apache.commons.jxpath.ri.compiler.Path;
import org.apache.commons.jxpath.ri.compiler.TreeCompiler;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

@ExtendWith(MockitoExtension.class)
class JXPathContextReferenceImpl_setExceptionHandler_42_0_Test {

    private JXPathContextReferenceImpl contextReference;

    private NodePointer rootPointer;

    private ExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        // Create a mock NodePointer
        rootPointer = mock(NodePointer.class);
        // Initialize the context reference with a mock root pointer
        contextReference = new JXPathContextReferenceImpl(null, new Object()) {

            {
                try {
                    Field rootPointerField = JXPathContextReferenceImpl.class.getDeclaredField("rootPointer");
                    rootPointerField.setAccessible(true);
                    rootPointerField.set(this, rootPointer);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        exceptionHandler = mock(ExceptionHandler.class);
    }

    @Test
    void testSetExceptionHandlerWhenRootPointerIsNodePointer() {
        // Act
        contextReference.setExceptionHandler(exceptionHandler);
        // Assert
        verify(rootPointer).setExceptionHandler(exceptionHandler);
    }

    @Test
    void testSetExceptionHandlerWhenRootPointerIsNotNodePointer() {
        // Arrange
        contextReference = new JXPathContextReferenceImpl(null, new Object()) {

            {
                try {
                    Field rootPointerField = JXPathContextReferenceImpl.class.getDeclaredField("rootPointer");
                    rootPointerField.setAccessible(true);
                    // Set to a non-NodePointer
                    rootPointerField.set(this, new Object());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // Act
        contextReference.setExceptionHandler(exceptionHandler);
        // Assert
        // Verify that setExceptionHandler on rootPointer is not called
        verify(rootPointer, never()).setExceptionHandler(any());
    }
}
