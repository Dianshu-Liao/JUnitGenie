package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.axes.SimplePathInterpreter;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.EvalContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import org.apache.commons.jxpath.JXPathException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_doPredicatesStandard_10_0_Test {

    @Test
    public void testDoPredicatesStandardWithEmptyParents() throws Exception {
        EvalContext context = createMockEvalContext();
        List<NodePointer> parents = new ArrayList<>();
        Step[] steps = new Step[0];
        Expression[] predicates = new Expression[0];
        NodePointer result = invokeDoPredicatesStandard(context, parents, steps, 0, predicates, 0);
        assertNull(result);
    }

    @Test
    public void testDoPredicatesStandardWithMatchingNameAttribute() throws Exception {
        EvalContext context = createMockEvalContext();
        List<NodePointer> parents = createMockParentsWithName("testName");
        Step[] steps = new Step[1];
        Expression[] predicates = new Expression[] { createNameAttributeTest("testName") };
        NodePointer result = invokeDoPredicatesStandard(context, parents, steps, 0, predicates, 0);
        assertNotNull(result);
        assertEquals("testName", result.getValue());
    }

    @Test
    public void testDoPredicatesStandardWithNoMatchingNameAttribute() throws Exception {
        EvalContext context = createMockEvalContext();
        List<NodePointer> parents = createMockParentsWithName("otherName");
        Step[] steps = new Step[1];
        Expression[] predicates = new Expression[] { createNameAttributeTest("testName") };
        NodePointer result = invokeDoPredicatesStandard(context, parents, steps, 0, predicates, 0);
        assertNull(result);
    }

    @Test
    public void testDoPredicatesStandardWithIndexPredicate() throws Exception {
        EvalContext context = createMockEvalContext();
        List<NodePointer> parents = createMockParentsWithValues(new String[] { "value1", "value2" });
        Step[] steps = new Step[1];
        Expression[] predicates = new Expression[] { createIndexPredicate(1) };
        NodePointer result = invokeDoPredicatesStandard(context, parents, steps, 0, predicates, 0);
        assertNotNull(result);
        assertEquals("value2", result.getValue());
    }

    @Test
    public void testDoPredicatesStandardWithInvalidIndexPredicate() throws Exception {
        EvalContext context = createMockEvalContext();
        List<NodePointer> parents = createMockParentsWithValues(new String[] { "value1" });
        Step[] steps = new Step[1];
        Expression[] predicates = new Expression[] { createIndexPredicate(2) };
        NodePointer result = invokeDoPredicatesStandard(context, parents, steps, 0, predicates, 0);
        assertNull(result);
    }

    private NodePointer invokeDoPredicatesStandard(EvalContext context, List<NodePointer> parents, Step[] steps, int currentStep, Expression[] predicates, int currentPredicate) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doPredicatesStandard", EvalContext.class, List.class, Step[].class, int.class, Expression[].class, int.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(null, context, parents, steps, currentStep, predicates, currentPredicate);
    }

    private EvalContext createMockEvalContext() {
        return mock(EvalContext.class);
    }

    private List<NodePointer> createMockParentsWithName(String name) {
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.getValue()).thenReturn(name);
        return new ArrayList<>(Collections.singletonList(mockPointer));
    }

    private List<NodePointer> createMockParentsWithValues(String[] values) {
        List<NodePointer> pointers = new ArrayList<>();
        for (String value : values) {
            NodePointer mockPointer = mock(NodePointer.class);
            when(mockPointer.getValue()).thenReturn(value);
            pointers.add(mockPointer);
        }
        return pointers;
    }

    private Expression createNameAttributeTest(String name) {
        return new NameAttributeTest(mock(Expression.class), mock(Expression.class));
    }

    private Expression createIndexPredicate(int index) {
        return mock(Expression.class);
    }
}
