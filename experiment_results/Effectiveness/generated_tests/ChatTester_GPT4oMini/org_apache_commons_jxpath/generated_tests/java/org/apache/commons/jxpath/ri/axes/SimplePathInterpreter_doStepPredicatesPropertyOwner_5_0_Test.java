package org.apache.commons.jxpath.ri.axes;

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
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.InfoSetUtil;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.Expression;
import org.apache.commons.jxpath.ri.compiler.NameAttributeTest;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.Step;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_doStepPredicatesPropertyOwner_5_0_Test {

    @Test
    public void testDoStepPredicatesPropertyOwner_ChildPointerIsNotActual() throws Exception {
        // Arrange
        EvalContext context = Mockito.mock(EvalContext.class);
        PropertyOwnerPointer parentPointer = Mockito.mock(PropertyOwnerPointer.class);
        Step[] steps = new Step[1];
        steps[0] = Mockito.mock(Step.class);
        Mockito.when(steps[0].getPredicates()).thenReturn(new Expression[0]);
        // Create a child pointer that is not actual
        NodePointer childPointer = Mockito.mock(NodePointer.class);
        Mockito.when(childPointer.isActual()).thenReturn(false);
        // Mock the createChildPointerForStep method
        Method createChildPointerForStepMethod = SimplePathInterpreter.class.getDeclaredMethod("createChildPointerForStep", PropertyOwnerPointer.class, Step.class);
        createChildPointerForStepMethod.setAccessible(true);
        Mockito.when(createChildPointerForStepMethod.invoke(null, parentPointer, steps[0])).thenReturn(childPointer);
        // Mock the createNullPointer method
        Method createNullPointerMethod = SimplePathInterpreter.class.getDeclaredMethod("createNullPointer", EvalContext.class, PropertyOwnerPointer.class, Step[].class, int.class);
        createNullPointerMethod.setAccessible(true);
        NodePointer nullPointer = Mockito.mock(NodePointer.class);
        Mockito.when(createNullPointerMethod.invoke(null, context, parentPointer, steps, 0)).thenReturn(nullPointer);
        // Act
        Method focalMethod = SimplePathInterpreter.class.getDeclaredMethod("doStepPredicatesPropertyOwner", EvalContext.class, PropertyOwnerPointer.class, Step[].class, int.class);
        focalMethod.setAccessible(true);
        NodePointer result = (NodePointer) focalMethod.invoke(null, context, parentPointer, steps, 0);
        // Assert
        assertEquals(nullPointer, result);
    }

    @Test
    public void testDoStepPredicatesPropertyOwner_ChildPointerIsActual() throws Exception {
        // Arrange
        EvalContext context = Mockito.mock(EvalContext.class);
        PropertyOwnerPointer parentPointer = Mockito.mock(PropertyOwnerPointer.class);
        Step[] steps = new Step[1];
        steps[0] = Mockito.mock(Step.class);
        Mockito.when(steps[0].getPredicates()).thenReturn(new Expression[0]);
        // Create a child pointer that is actual
        NodePointer childPointer = Mockito.mock(NodePointer.class);
        Mockito.when(childPointer.isActual()).thenReturn(true);
        // Mock the createChildPointerForStep method
        Method createChildPointerForStepMethod = SimplePathInterpreter.class.getDeclaredMethod("createChildPointerForStep", PropertyOwnerPointer.class, Step.class);
        createChildPointerForStepMethod.setAccessible(true);
        Mockito.when(createChildPointerForStepMethod.invoke(null, parentPointer, steps[0])).thenReturn(childPointer);
        // Mock the doPredicate method
        Method doPredicateMethod = SimplePathInterpreter.class.getDeclaredMethod("doPredicate", EvalContext.class, NodePointer.class, Step[].class, int.class, Expression[].class, int.class);
        doPredicateMethod.setAccessible(true);
        NodePointer expectedPointer = Mockito.mock(NodePointer.class);
        Mockito.when(doPredicateMethod.invoke(null, context, childPointer, steps, 0, new Expression[0], 0)).thenReturn(expectedPointer);
        // Act
        Method focalMethod = SimplePathInterpreter.class.getDeclaredMethod("doStepPredicatesPropertyOwner", EvalContext.class, PropertyOwnerPointer.class, Step[].class, int.class);
        focalMethod.setAccessible(true);
        NodePointer result = (NodePointer) focalMethod.invoke(null, context, parentPointer, steps, 0);
        // Assert
        assertEquals(expectedPointer, result);
    }
}
