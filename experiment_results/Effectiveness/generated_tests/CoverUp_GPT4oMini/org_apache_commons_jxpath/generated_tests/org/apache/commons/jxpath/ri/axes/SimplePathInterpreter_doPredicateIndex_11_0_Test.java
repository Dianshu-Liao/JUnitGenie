package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

class SimplePathInterpreter_doPredicateIndex_11_0_Test {

    private SimplePathInterpreter interpreter;

    private EvalContext context;

    private NodePointer parent;

    private Step[] steps;

    private Expression[] predicates;

    @BeforeEach
    void setUp() {
        interpreter = new SimplePathInterpreter();
        context = mock(EvalContext.class);
        parent = mock(NodePointer.class);
        steps = new Step[] { mock(Step.class) };
        predicates = new Expression[] { mock(Expression.class) };
    }

    @Test
    void testDoPredicateIndex_ValidCollectionElement() throws Exception {
        when(predicates[0].computeValue(context)).thenReturn(1);
        when(parent.isActual()).thenReturn(true);
        when(parent.isCollection()).thenReturn(true);
        when(parent.getLength()).thenReturn(2);
        when(parent.clone()).thenReturn(parent);
        when(parent.getValue()).thenReturn("value");
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicateIndex", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(interpreter, context, parent, steps, 0, predicates, 0);
        assertNotNull(result);
        verify(parent).setIndex(1);
    }

    @Test
    void testDoPredicateIndex_InvalidCollectionElement() throws Exception {
        when(predicates[0].computeValue(context)).thenReturn(-1);
        when(parent.isActual()).thenReturn(true);
        when(parent.isCollection()).thenReturn(true);
        when(parent.getLength()).thenReturn(2);
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicateIndex", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(interpreter, context, parent, steps, 0, predicates, 0);
        assertNotNull(result);
        assertTrue(result instanceof NullElementPointer);
    }

    @Test
    void testDoPredicateIndex_NullPredicateValue() throws Exception {
        when(predicates[0].computeValue(context)).thenReturn(null);
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicateIndex", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        JXPathException thrown = assertThrows(JXPathException.class, () -> {
            method.invoke(interpreter, context, parent, steps, 0, predicates, 0);
        });
        assertEquals("Predicate value is null: " + predicates[0], thrown.getMessage());
    }

    @Test
    void testDoPredicateIndex_ValidIndex() throws Exception {
        when(predicates[0].computeValue(context)).thenReturn(0);
        when(parent.isActual()).thenReturn(true);
        when(parent.isCollection()).thenReturn(true);
        when(parent.getLength()).thenReturn(1);
        when(parent.clone()).thenReturn(parent);
        when(parent.getValue()).thenReturn("value");
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicateIndex", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(interpreter, context, parent, steps, 0, predicates, 0);
        assertNotNull(result);
        verify(parent).setIndex(0);
    }

    @Test
    void testDoPredicateIndex_EmptyCollection() throws Exception {
        when(predicates[0].computeValue(context)).thenReturn(0);
        when(parent.isActual()).thenReturn(true);
        when(parent.isCollection()).thenReturn(true);
        when(parent.getLength()).thenReturn(0);
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicateIndex", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        NodePointer result = (NodePointer) method.invoke(interpreter, context, parent, steps, 0, predicates, 0);
        assertNotNull(result);
        assertTrue(result instanceof NullElementPointer);
    }
}
