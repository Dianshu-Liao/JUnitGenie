package org.apache.commons.jxpath.ri;

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
import org.apache.commons.jxpath.util.ClassLoaderUtil;
import org.apache.commons.jxpath.util.ReverseComparator;
import org.apache.commons.jxpath.util.TypeUtils;

public class JXPathContextReferenceImpl_checkSimplePath_22_0_Test {

    private JXPathContextReferenceImpl jXPathContextReferenceImpl;

    private JXPathContext parentContext;

    private Object contextBean;

    private Pointer contextPointer;

    @BeforeEach
    public void setUp() {
        parentContext = Mockito.mock(JXPathContext.class);
        contextBean = new Object();
        contextPointer = Mockito.mock(Pointer.class);
        jXPathContextReferenceImpl = new JXPathContextReferenceImpl(parentContext, contextBean, contextPointer);
    }

    @Test
    public void testCheckSimplePath_ValidExpression() throws Exception {
        // Create a mock LocationPath that is a simple path
        LocationPath validExpr = Mockito.mock(LocationPath.class);
        Mockito.when(validExpr.isSimplePath()).thenReturn(true);
        // Use reflection to invoke the private method
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("checkSimplePath", Expression.class);
        method.setAccessible(true);
        // No exception should be thrown
        assertDoesNotThrow(() -> method.invoke(jXPathContextReferenceImpl, validExpr));
    }

    @Test
    public void testCheckSimplePath_InvalidExpression_NotLocationPath() throws Exception {
        // Create a mock Expression that is not a LocationPath
        Expression invalidExpr = Mockito.mock(Expression.class);
        // Use reflection to invoke the private method
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("checkSimplePath", Expression.class);
        method.setAccessible(true);
        // Expect JXPathInvalidSyntaxException to be thrown
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            method.invoke(jXPathContextReferenceImpl, invalidExpr);
        });
        assertEquals("JXPath can only create a path if it uses exclusively the child:: and attribute:: axes and has no context-dependent predicates", exception.getMessage());
    }

    @Test
    public void testCheckSimplePath_InvalidExpression_NotSimplePath() throws Exception {
        // Create a mock LocationPath that is not a simple path
        LocationPath invalidExpr = Mockito.mock(LocationPath.class);
        Mockito.when(invalidExpr.isSimplePath()).thenReturn(false);
        // Use reflection to invoke the private method
        Method method = JXPathContextReferenceImpl.class.getDeclaredMethod("checkSimplePath", Expression.class);
        method.setAccessible(true);
        // Expect JXPathInvalidSyntaxException to be thrown
        Exception exception = assertThrows(JXPathInvalidSyntaxException.class, () -> {
            method.invoke(jXPathContextReferenceImpl, invalidExpr);
        });
        assertEquals("JXPath can only create a path if it uses exclusively the child:: and attribute:: axes and has no context-dependent predicates", exception.getMessage());
    }
}
