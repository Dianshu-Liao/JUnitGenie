package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.LocationPath;
import org.apache.commons.jxpath.JXPathInvalidSyntaxException;
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
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.JXPathFunctionNotFoundException;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.axes.InitialContext;
import org.apache.commons.jxpath.ri.axes.RootContext;
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

public class JXPathContextReferenceImpl_checkSimplePath_22_1_Test {

    private JXPathContextReferenceImpl context;

    @BeforeEach
    public void setUp() {
        context = new JXPathContextReferenceImpl(null, new Object());
    }

    private void invokeCheckSimplePath(Expression expr) throws Exception {
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("checkSimplePath", Expression.class);
        method.setAccessible(true);
        method.invoke(context, expr);
    }

    @Test
    public void testCheckSimplePath_WithSimplePath() throws Exception {
        // Create a mock simple path expression
        Expression simplePathExpr = Mockito.mock(LocationPath.class);
        Mockito.when(simplePathExpr instanceof LocationPath).thenReturn(true);
        Mockito.when(((LocationPath) simplePathExpr).isSimplePath()).thenReturn(true);
        // This should not throw an exception
        assertDoesNotThrow(() -> {
            invokeCheckSimplePath(simplePathExpr);
        });
    }

    @Test
    public void testCheckSimplePath_WithComplexPath() throws Exception {
        // Create a mock complex path expression
        Expression complexPathExpr = Mockito.mock(LocationPath.class);
        Mockito.when(complexPathExpr instanceof LocationPath).thenReturn(true);
        Mockito.when(((LocationPath) complexPathExpr).isSimplePath()).thenReturn(false);
        // Expecting JXPathInvalidSyntaxException to be thrown
        assertThrows(JXPathInvalidSyntaxException.class, () -> {
            invokeCheckSimplePath(complexPathExpr);
        });
    }

    @Test
    public void testCheckSimplePath_WithNonLocationPath() throws Exception {
        // Create a mock expression that is not a LocationPath
        Expression nonLocationPathExpr = Mockito.mock(Expression.class);
        // Expecting JXPathInvalidSyntaxException to be thrown
        assertThrows(JXPathInvalidSyntaxException.class, () -> {
            invokeCheckSimplePath(nonLocationPathExpr);
        });
    }
}
