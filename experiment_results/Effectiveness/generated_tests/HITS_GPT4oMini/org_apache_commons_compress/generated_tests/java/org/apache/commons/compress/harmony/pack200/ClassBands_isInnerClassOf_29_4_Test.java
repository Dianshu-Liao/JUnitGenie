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

public class ClassBands_isInnerClassOf_29_4_Test {

    private ClassBands classBands;

    private Segment segment;

    @BeforeEach
    public void setUp() throws Exception {
        segment = new Segment();
        classBands = new ClassBands(segment, 1, 0, false);
    }

    private boolean invokeIsInnerClassOf(String innerClassName, CPClass outerClass) throws Exception {
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(classBands, innerClassName, outerClass);
    }

    @Test
    public void testIsInnerClassOf_InnerClassDirectParent() throws Exception {
        CPClass innerClass = new CPClass(new CPUTF8("com/example/Outer$Inner"));
        CPClass outerClass = new CPClass(new CPUTF8("com/example/Outer"));
        assertTrue(invokeIsInnerClassOf(innerClass.toString(), outerClass));
    }

    @Test
    public void testIsInnerClassOf_InnerClassIndirectParent() throws Exception {
        CPClass innerClass = new CPClass(new CPUTF8("com/example/Outer$Inner$Nested"));
        CPClass outerClass = new CPClass(new CPUTF8("com/example/Outer"));
        assertTrue(invokeIsInnerClassOf(innerClass.toString(), outerClass));
    }

    @Test
    public void testIsInnerClassOf_NotInnerClass() throws Exception {
        CPClass nonInnerClass = new CPClass(new CPUTF8("com/example/Outer"));
        CPClass outerClass = new CPClass(new CPUTF8("com/example/Outer"));
        assertFalse(invokeIsInnerClassOf(nonInnerClass.toString(), outerClass));
    }

    @Test
    public void testIsInnerClassOf_DifferentOuterClass() throws Exception {
        CPClass innerClass = new CPClass(new CPUTF8("com/example/Outer$Inner"));
        CPClass differentOuterClass = new CPClass(new CPUTF8("com/example/DifferentOuter"));
        assertFalse(invokeIsInnerClassOf(innerClass.toString(), differentOuterClass));
    }

    @Test
    public void testIsInnerClassOf_EmptyString() throws Exception {
        CPClass innerClass = new CPClass(new CPUTF8(""));
        CPClass outerClass = new CPClass(new CPUTF8("com/example/Outer"));
        assertFalse(invokeIsInnerClassOf(innerClass.toString(), outerClass));
    }

    @Test
    public void testIsInnerClassOf_NullInnerClass() throws Exception {
        CPClass outerClass = new CPClass(new CPUTF8("com/example/Outer"));
        assertFalse(invokeIsInnerClassOf(null, outerClass));
    }

    @Test
    public void testIsInnerClassOf_NullOuterClass() throws Exception {
        CPClass innerClass = new CPClass(new CPUTF8("com/example/Outer$Inner"));
        assertFalse(invokeIsInnerClassOf(innerClass.toString(), null));
    }
}
