package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.CPClass;
import org.apache.commons.compress.harmony.pack200.CPUTF8;
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

    @BeforeEach
    public void setUp() throws IOException {
        Segment segment = new Segment();
        classBands = new ClassBands(segment, 10, 1, false);
    }

    private boolean invokeIsInnerClassOf(String innerClassName, CPClass outerClass) throws Exception {
        Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        return (Boolean) method.invoke(classBands, innerClassName, outerClass);
    }

    @Test
    public void testIsInnerClassOf_WithInnerClassName_ReturnsTrue() throws Exception {
        String innerClassName = "OuterClass$InnerClass";
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        assertTrue(result, "Expected isInnerClassOf to return true for inner class.");
    }

    @Test
    public void testIsInnerClassOf_WithNonInnerClassName_ReturnsFalse() throws Exception {
        String nonInnerClassName = "OuterClass";
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(nonInnerClassName, outerClass);
        assertFalse(result, "Expected isInnerClassOf to return false for non-inner class.");
    }

    @Test
    public void testIsInnerClassOf_WithNestedInnerClass_ReturnsTrue() throws Exception {
        String innerClassName = "OuterClass$InnerClass$NestedInnerClass";
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        assertTrue(result, "Expected isInnerClassOf to return true for nested inner class.");
    }

    @Test
    public void testIsInnerClassOf_WithDifferentOuterClass_ReturnsFalse() throws Exception {
        String innerClassName = "AnotherOuterClass$InnerClass";
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        assertFalse(result, "Expected isInnerClassOf to return false for different outer class.");
    }

    @Test
    public void testIsInnerClassOf_WithEmptyClassName_ReturnsFalse() throws Exception {
        String innerClassName = "";
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        assertFalse(result, "Expected isInnerClassOf to return false for empty class name.");
    }

    @Test
    public void testIsInnerClassOf_WithNullClassName_ReturnsFalse() throws Exception {
        String innerClassName = null;
        CPClass outerClass = new CPClass(new CPUTF8("OuterClass"));
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        assertFalse(result, "Expected isInnerClassOf to return false for null class name.");
    }
}
