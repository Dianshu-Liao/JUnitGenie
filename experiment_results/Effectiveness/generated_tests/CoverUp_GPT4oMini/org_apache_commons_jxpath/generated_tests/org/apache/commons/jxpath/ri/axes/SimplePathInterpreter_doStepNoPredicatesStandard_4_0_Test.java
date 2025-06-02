package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
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
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

@ExtendWith(MockitoExtension.class)
class SimplePathInterpreter_doStepNoPredicatesStandard_4_0_Test {

    private SimplePathInterpreter interpreter;

    private EvalContext context;

    private NodePointer parentPointer;

    private Step[] steps;

    @BeforeEach
    void setUp() {
        interpreter = new SimplePathInterpreter();
        context = mock(EvalContext.class);
        parentPointer = mock(NodePointer.class);
        steps = new Step[2];
        steps[0] = createStep(Compiler.AXIS_CHILD, mock(NodeTest.class));
        steps[1] = createStep(Compiler.AXIS_SELF, mock(NodeTest.class));
    }

    private Step createStep(int axis, NodeTest nodeTest) {
        try {
            return (Step) Step.class.getDeclaredConstructor(int.class, NodeTest.class, Expression[].class).newInstance(axis, nodeTest, new Expression[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testDoStepNoPredicatesStandard_LastStep() throws Exception {
        NodePointer childPointer = mock(NodePointer.class);
        NodeIterator iterator = mock(NodeIterator.class);
        when(iterator.setPosition(1)).thenReturn(true);
        when(iterator.getNodePointer()).thenReturn(childPointer);
        when(invokePrivateMethod("getNodeIterator", context, parentPointer, steps[0])).thenReturn(iterator);
        NodePointer result = invokePrivateDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertEquals(childPointer, result);
    }

    @Test
    void testDoStepNoPredicatesStandard_BestMatch() throws Exception {
        NodePointer childPointer1 = mock(NodePointer.class);
        NodePointer childPointer2 = mock(NodePointer.class);
        NodeIterator iterator = mock(NodeIterator.class);
        when(iterator.setPosition(1)).thenReturn(true);
        when(iterator.getNodePointer()).thenReturn(childPointer1).thenReturn(childPointer2);
        when(invokePrivateMethod("getNodeIterator", context, parentPointer, steps[0])).thenReturn(iterator);
        when(invokePrivateMethod("computeQuality", childPointer1)).thenReturn(999);
        when(invokePrivateMethod("computeQuality", childPointer2)).thenReturn(1000);
        NodePointer result = invokePrivateDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertEquals(childPointer2, result);
    }

    @Test
    void testDoStepNoPredicatesStandard_NoMatch() throws Exception {
        NodeIterator iterator = mock(NodeIterator.class);
        when(iterator.setPosition(1)).thenReturn(false);
        when(invokePrivateMethod("getNodeIterator", context, parentPointer, steps[0])).thenReturn(iterator);
        NodePointer result = invokePrivateDoStepNoPredicatesStandard(context, parentPointer, steps, 0);
        assertNotNull(result);
        assertTrue(result instanceof NullPropertyPointer);
    }

    private NodePointer invokePrivateDoStepNoPredicatesStandard(EvalContext context, NodePointer parentPointer, Step[] steps, int currentStep) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doStepNoPredicatesStandard", EvalContext.class, NodePointer.class, Step[].class, int.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(null, context, parentPointer, steps, currentStep);
    }

    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true);
        return method.invoke(interpreter, args);
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return Arrays.stream(args).map(arg -> arg.getClass()).toArray(Class<?>[]::new);
    }
}
