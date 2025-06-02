package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.model.NodePointer;
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
import org.apache.commons.jxpath.ri.model.beans.LangAttributePointer;
import org.apache.commons.jxpath.ri.model.beans.NullElementPointer;
import org.apache.commons.jxpath.ri.model.beans.NullPropertyPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class SimplePathInterpreter_computeQuality_14_0_Test {

    @Test
    public void testComputeQuality_PerfectMatch() throws Exception {
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.isActual()).thenReturn(true);
        int quality = invokeComputeQuality(mockPointer);
        assertEquals(1000, quality);
    }

    @Test
    public void testComputeQuality_NonActualPointer() throws Exception {
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.isActual()).thenReturn(false);
        NodePointer parentPointer = mock(NodePointer.class);
        when(parentPointer.isActual()).thenReturn(true);
        when(mockPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        int quality = invokeComputeQuality(mockPointer);
        assertEquals(999, quality);
    }

    @Test
    public void testComputeQuality_MultipleNonActualPointers() throws Exception {
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.isActual()).thenReturn(false);
        NodePointer parentPointer1 = mock(NodePointer.class);
        when(parentPointer1.isActual()).thenReturn(false);
        NodePointer parentPointer2 = mock(NodePointer.class);
        when(parentPointer2.isActual()).thenReturn(true);
        when(mockPointer.getImmediateParentPointer()).thenReturn(parentPointer1);
        when(parentPointer1.getImmediateParentPointer()).thenReturn(parentPointer2);
        int quality = invokeComputeQuality(mockPointer);
        assertEquals(998, quality);
    }

    @Test
    public void testComputeQuality_AllNonActualPointers() throws Exception {
        NodePointer mockPointer = mock(NodePointer.class);
        when(mockPointer.isActual()).thenReturn(false);
        NodePointer parentPointer = mock(NodePointer.class);
        when(parentPointer.isActual()).thenReturn(false);
        when(mockPointer.getImmediateParentPointer()).thenReturn(parentPointer);
        when(parentPointer.getImmediateParentPointer()).thenReturn(null);
        int quality = invokeComputeQuality(mockPointer);
        assertEquals(999, quality);
    }

    private int invokeComputeQuality(NodePointer pointer) throws Exception {
        Method method = SimplePathInterpreter.class.getDeclaredMethod("computeQuality", NodePointer.class);
        method.setAccessible(true);
        return (int) method.invoke(null, pointer);
    }
}
