package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_createNullPointerForPredicates_19_1_Test {

    private EvalContext context;

    private NodePointer parent;

    private Step[] steps;

    private Expression[] predicates;

    @BeforeEach
    public void setUp() {
        context = mock(EvalContext.class);
        parent = mock(NodePointer.class);
        steps = new Step[1];
        predicates = new Expression[2];
    }

    @Test
    public void testCreateNullPointerForPredicates_WithNameAttributeTest() {
        NameAttributeTest nameAttributeTest = mock(NameAttributeTest.class);
        when(nameAttributeTest.getNameTestExpression()).thenReturn(mock(Expression.class));
        when(nameAttributeTest.getNameTestExpression().computeValue(context)).thenReturn("testName");
        steps[0] = createStepWithPredicates(nameAttributeTest);
        NodePointer result = SimplePathInterpreter.createNullPointer(context, parent, steps, 0);
        verify(parent, times(1)).getValuePointer();
        assertTrue(result instanceof NullPropertyPointer);
    }

    @Test
    public void testCreateNullPointerForPredicates_WithOtherPredicate() {
        Expression otherPredicate = mock(Expression.class);
        when(otherPredicate.computeValue(context)).thenReturn(1);
        steps[0] = createStepWithPredicates(otherPredicate);
        NodePointer result = SimplePathInterpreter.createNullPointer(context, parent, steps, 0);
        verify(parent, times(1)).getValuePointer();
        assertTrue(result instanceof NullPropertyPointer);
    }

    @Test
    public void testCreateNullPointerForPredicates_WithMultiplePredicates() {
        NameAttributeTest nameAttributeTest = mock(NameAttributeTest.class);
        when(nameAttributeTest.getNameTestExpression()).thenReturn(mock(Expression.class));
        when(nameAttributeTest.getNameTestExpression().computeValue(context)).thenReturn("firstName");
        Expression otherPredicate = mock(Expression.class);
        when(otherPredicate.computeValue(context)).thenReturn(1);
        predicates[0] = nameAttributeTest;
        predicates[1] = otherPredicate;
        steps[0] = createStepWithPredicates(nameAttributeTest, otherPredicate);
        NodePointer result = SimplePathInterpreter.createNullPointer(context, parent, steps, 0);
        verify(parent, times(1)).getValuePointer();
        assertTrue(result instanceof NullPropertyPointer);
    }

    private Step createStepWithPredicates(Expression... predicates) {
        return new StepSubclass(Compiler.AXIS_CHILD, mock(NodeTest.class), predicates);
    }

    // Subclass of Step to allow instantiation in the test
    private static class StepSubclass extends Step {

        StepSubclass(int axis, NodeTest nodeTest, Expression[] predicates) {
            super(axis, nodeTest, predicates);
        }
    }
}
