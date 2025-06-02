package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.axes.SimplePathInterpreter;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

@ExtendWith(MockitoExtension.class)
class SimplePathInterpreter_doStepPredicatesPropertyOwner_5_0_Test {

    @Test
    void testDoStepPredicatesPropertyOwner_ValidChildPointer() throws Exception {
        // Arrange
        EvalContext context = createMockEvalContext();
        PropertyOwnerPointer parentPointer = createMockPropertyOwnerPointer();
        Step[] steps = createMockSteps();
        int currentStep = 0;
        // Act
        NodePointer result = invokeDoStepPredicatesPropertyOwner(context, parentPointer, steps, currentStep);
        // Assert
        assertNotNull(result);
        assertTrue(result.isActual());
    }

    @Test
    void testDoStepPredicatesPropertyOwner_NullPointer() throws Exception {
        // Arrange
        EvalContext context = createMockEvalContext();
        PropertyOwnerPointer parentPointer = createMockPropertyOwnerPointerWithInvalidProperty();
        Step[] steps = createMockSteps();
        int currentStep = 0;
        // Act
        NodePointer result = invokeDoStepPredicatesPropertyOwner(context, parentPointer, steps, currentStep);
        // Assert
        assertNull(result);
    }

    private NodePointer invokeDoStepPredicatesPropertyOwner(EvalContext context, PropertyOwnerPointer parentPointer, Step[] steps, int currentStep) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("doStepPredicatesPropertyOwner", EvalContext.class, PropertyOwnerPointer.class, Step[].class, int.class);
        method.setAccessible(true);
        return (NodePointer) method.invoke(null, context, parentPointer, steps, currentStep);
    }

    private EvalContext createMockEvalContext() {
        return mock(EvalContext.class);
    }

    private PropertyOwnerPointer createMockPropertyOwnerPointer() {
        return mock(PropertyOwnerPointer.class);
    }

    private PropertyOwnerPointer createMockPropertyOwnerPointerWithInvalidProperty() {
        PropertyOwnerPointer pointer = mock(PropertyOwnerPointer.class);
        when(pointer.getPropertyPointer()).thenReturn(null);
        return pointer;
    }

    private Step[] createMockSteps() {
        return new Step[] { mock(Step.class) };
    }
}
