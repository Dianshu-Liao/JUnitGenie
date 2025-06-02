package org.apache.commons.compress.harmony.pack200;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.compress.harmony.pack200.AttributeDefinitionBands.AttributeDefinition;
import org.apache.commons.compress.harmony.pack200.IcBands.IcTuple;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;

public class ClassBands_isInnerClassOf_29_0_Test {

    private ClassBands classBands;

    // Mock dependencies
    private Segment segment;

    private int numClasses = 1;

    private int effort = 1;

    private boolean stripDebug = false;

    @BeforeEach
    public void setUp() throws Exception {
        segment = Mockito.mock(Segment.class);
        classBands = new ClassBands(segment, numClasses, effort, stripDebug);
    }

    @Test
    public void testIsInnerClassOf_InnerClass() throws Exception {
        // Prepare the inputs
        String possibleInner = "Outer$Inner";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("Outer");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertTrue(result);
    }

    @Test
    public void testIsInnerClassOf_NotInnerClass() throws Exception {
        // Prepare the inputs
        String possibleInner = "NotAnInnerClass";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("Outer");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertFalse(result);
    }

    @Test
    public void testIsInnerClassOf_RecursiveInnerClass() throws Exception {
        // Prepare the inputs
        String possibleInner = "Outer$Inner$Nested";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("Outer$Inner");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertTrue(result);
    }

    @Test
    public void testIsInnerClassOf_OuterClassMismatch() throws Exception {
        // Prepare the inputs
        String possibleInner = "Outer$Inner";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("DifferentOuter");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertFalse(result);
    }

    @Test
    public void testIsInnerClassOf_EmptyClassName() throws Exception {
        // Prepare the inputs
        String possibleInner = "";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("Outer");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertFalse(result);
    }

    @Test
    public void testIsInnerClassOf_SingleDollarSign() throws Exception {
        // Prepare the inputs
        String possibleInner = "Outer$";
        CPClass possibleOuter = Mockito.mock(CPClass.class);
        Mockito.when(possibleOuter.toString()).thenReturn("Outer");
        // Use reflection to invoke the private method
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(classBands, possibleInner, possibleOuter);
        assertFalse(result);
    }
}
