package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_doStepNoPredicatesStandard_4_2_Test {

    private EvalContext context;

    private NodePointer parentPointer;

    private Step[] steps;

    @BeforeEach
    public void setUp() {
        context = mock(EvalContext.class);
        parentPointer = mock(NodePointer.class);
        steps = new Step[1];
    }

    private class TestStep extends Step {

        public TestStep(int axis, NodeTest nodeTest, Expression[] predicates) {
            super(axis, nodeTest, predicates);
        }
    }

    private Step createStep(int axis, NodeTest nodeTest, Expression[] predicates) {
        return new TestStep(axis, nodeTest, predicates);
    }

    private NodePointer invokeDoStepNoPredicatesStandard(EvalContext context, NodePointer parentPointer, Step[] steps, int currentStep) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doStepNoPredicatesStandard", EvalContext.class, NodePointer.class, Step[].class, int.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(null, context, parentPointer, steps, currentStep);
    }

    @Test
    public void testDoStepNoPredicatesStandard_WithSelfAxis() throws Exception {
        steps[0] = createStep(Compiler.AXIS_SELF, null, null);
        NodePointer result = invokeDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertNotNull(result);
    }

    @Test
    public void testDoStepNoPredicatesStandard_WithChildNodes() throws Exception {
        NodePointer childPointer = mock(NodePointer.class);
        NodeIterator nodeIterator = mock(NodeIterator.class);
        when(nodeIterator.setPosition(1)).thenReturn(true);
        when(nodeIterator.getNodePointer()).thenReturn(childPointer);
        when(parentPointer.childIterator(any(), anyBoolean(), any())).thenReturn(nodeIterator);
        steps[0] = createStep(Compiler.AXIS_CHILD, mock(NodeNameTest.class), null);
        NodePointer result = invokeDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertEquals(childPointer, result);
    }

    @Test
    public void testDoStepNoPredicatesStandard_NoMatchReturnsNullPointer() throws Exception {
        when(parentPointer.childIterator(any(), anyBoolean(), any())).thenReturn(null);
        steps[0] = createStep(Compiler.AXIS_CHILD, mock(NodeNameTest.class), null);
        NodePointer result = invokeDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertNotNull(result);
        assertTrue(result instanceof NullPropertyPointer);
    }
}
