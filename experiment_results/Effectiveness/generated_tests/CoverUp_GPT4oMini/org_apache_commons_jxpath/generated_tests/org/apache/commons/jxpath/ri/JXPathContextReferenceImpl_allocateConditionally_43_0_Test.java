package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.ri.model.VariablePointerFactory;
import org.apache.commons.jxpath.ri.model.beans.BeanPointerFactory;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.ri.model.container.ContainerPointerFactory;
import org.apache.commons.jxpath.ri.model.dynamic.DynamicPointerFactory;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

class JXPathContextReferenceImpl_allocateConditionally_43_0_Test {

    @Test
    void testAllocateConditionally_ClassNotFound() {
        // Arrange
        String className = "NonExistentClass";
        // This class exists
        String existenceCheckClassName = "java.lang.String";
        // Act
        Object result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        // Assert
        assertNull(result);
    }

    @Test
    void testAllocateConditionally_Success() throws Exception {
        // Arrange
        // This class exists
        String className = "java.lang.String";
        // This class exists
        String existenceCheckClassName = "java.lang.String";
        // Act
        Object result = JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof String);
    }

    @Test
    void testAllocateConditionally_ConstructorThrowsException() {
        // Arrange
        // This class exists but has no public no-arg constructor
        String className = "java.lang.StringBuilder";
        // This class exists
        String existenceCheckClassName = "java.lang.String";
        // Act
        Executable executable = () -> JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        // Assert
        JXPathException thrown = assertThrows(JXPathException.class, executable);
        assertEquals("Cannot allocate " + className, thrown.getMessage());
    }

    @Test
    void testAllocateConditionally_ClassLoaderUtilThrowsException() {
        // Arrange
        // This class exists
        String className = "java.lang.String";
        // This class does not exist
        String existenceCheckClassName = "NonExistentClass";
        // Act
        Executable executable = () -> JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName);
        // Assert
        assertNull(JXPathContextReferenceImpl.allocateConditionally(className, existenceCheckClassName));
    }
}
