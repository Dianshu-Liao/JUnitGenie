package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
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
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;

public class SimplePathInterpreter_doStepPredicatesPropertyOwner_5_0_Test {

    private EvalContext context;

    private PropertyOwnerPointer parentPointer;

    private Step[] steps;

    @BeforeEach
    public void setUp() {
        context = mock(EvalContext.class);
        parentPointer = mock(PropertyOwnerPointer.class);
        steps = new Step[1];
    }

    private static class TestStep extends Step {

        public TestStep(int axis, NodeTest nodeTest, Expression[] predicates) {
            super(axis, nodeTest, predicates);
        }
    }

    private NodePointer invokeDoStepPredicatesPropertyOwner() throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doStepPredicatesPropertyOwner", EvalContext.class, PropertyOwnerPointer.class, Step[].class, int.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(null, context, parentPointer, steps, 0);
    }

    @Test
    public void testDoStepPredicatesPropertyOwner_WithValidChildPointer() throws Exception {
        // Arrange
        PropertyPointer childPointer = mock(PropertyPointer.class);
        when(childPointer.isActual()).thenReturn(true);
        when(parentPointer.getPropertyPointer()).thenReturn(childPointer);
        steps[0] = new TestStep(Compiler.AXIS_CHILD, new NodeNameTest(new QName(null, "validNode")), new Expression[0]);
        // Act
        NodePointer result = invokeDoStepPredicatesPropertyOwner();
        // Assert
        assertNotNull(result);
        assertEquals(childPointer, result);
    }

    @Test
    public void testDoStepPredicatesPropertyOwner_WithInvalidChildPointer() throws Exception {
        // Arrange
        when(parentPointer.getPropertyPointer()).thenReturn(null);
        steps[0] = new TestStep(Compiler.AXIS_CHILD, new NodeNameTest(new QName(null, "invalidNode")), new Expression[0]);
        // Act
        NodePointer result = invokeDoStepPredicatesPropertyOwner();
        // Assert
        assertNull(result);
    }

    @Test
    public void testDoStepPredicatesPropertyOwner_WithNullPointer() throws Exception {
        // Arrange
        when(parentPointer.getPropertyPointer()).thenReturn(null);
        steps[0] = new TestStep(Compiler.AXIS_CHILD, new NodeNameTest(new QName(null, "anotherNode")), new Expression[0]);
        // Act
        NodePointer result = invokeDoStepPredicatesPropertyOwner();
        // Assert
        assertNull(result);
    }
}
