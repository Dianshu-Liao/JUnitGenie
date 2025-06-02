package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
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
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_doStep_2_3_Test {

    private EvalContext context;

    private NodePointer parentPointer;

    private Step[] steps;

    @BeforeEach
    public void setUp() {
        context = createMockEvalContext();
        parentPointer = createMockNodePointer();
        steps = new Step[] { createMockStep() };
    }

    private EvalContext createMockEvalContext() {
        return Mockito.mock(EvalContext.class);
    }

    private NodePointer createMockNodePointer() {
        return Mockito.mock(NodePointer.class);
    }

    private PropertyOwnerPointer createMockPropertyOwnerPointer() {
        return Mockito.mock(PropertyOwnerPointer.class);
    }

    private Step createMockStep() {
        Step step = Mockito.mock(Step.class);
        when(step.getAxis()).thenReturn(Compiler.AXIS_CHILD);
        when(step.getPredicates()).thenReturn(null);
        return step;
    }

    private NodePointer invokeDoStep(EvalContext context, NodePointer parent, Step[] steps, int currentStep) {
        try {
            Method method = SimplePathInterpreter.class.getDeclaredMethod("doStep", EvalContext.class, NodePointer.class, Step[].class, int.class);
            method.setAccessible(true);
            return (NodePointer) method.invoke(null, context, parent, steps, currentStep);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDoStep_NullParent() {
        NodePointer result = invokeDoStep(context, null, steps, 0);
        assertNull(result, "Expected null when parent is null.");
    }
}
