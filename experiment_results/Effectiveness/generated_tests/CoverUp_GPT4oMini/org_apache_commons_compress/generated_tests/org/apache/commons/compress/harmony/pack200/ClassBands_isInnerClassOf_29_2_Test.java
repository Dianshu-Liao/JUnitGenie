package org.apache.commons.compress.harmony.pack200;

import org.apache.commons.compress.harmony.pack200.CPClass;
import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.Segment;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.harmony.pack200.CPUTF8;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ClassBands_isInnerClassOf_29_2_Test {

    private ClassBands classBands;

    @BeforeEach
    void setUp() throws IOException {
        Segment segment = new Segment();
        classBands = new ClassBands(segment, 1, 0, false);
    }

    @Test
    void testIsInnerClassOf_WithInnerClass() throws Exception {
        // Arrange
        String innerClassName = "Outer$Inner";
        CPClass outerClass = new CPClass(new CPUTF8("Outer"));
        // Act
        boolean result = invokeIsInnerClassOf(innerClassName, outerClass);
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsInnerClassOf_WithNonInnerClass() throws Exception {
        // Arrange
        String nonInnerClassName = "Outer";
        CPClass outerClass = new CPClass(new CPUTF8("Outer"));
        // Act
        boolean result = invokeIsInnerClassOf(nonInnerClassName, outerClass);
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsInnerClassOf_WithNestedInnerClass() throws Exception {
        // Arrange
        String nestedInnerClassName = "Outer$Inner$Nested";
        CPClass outerClass = new CPClass(new CPUTF8("Outer$Inner"));
        // Act
        boolean result = invokeIsInnerClassOf(nestedInnerClassName, outerClass);
        // Assert
        assertTrue(result);
    }

    private boolean invokeIsInnerClassOf(String possibleInner, CPClass possibleOuter) throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = ClassBands.class.getDeclaredMethod("isInnerClassOf", String.class, CPClass.class);
        method.setAccessible(true);
        return (boolean) method.invoke(classBands, possibleInner, possibleOuter);
    }
}
