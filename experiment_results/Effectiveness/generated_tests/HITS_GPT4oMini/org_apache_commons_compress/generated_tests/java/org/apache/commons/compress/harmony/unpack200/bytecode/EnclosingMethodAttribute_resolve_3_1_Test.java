package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
// Added import for Segment
import org.apache.commons.compress.harmony.unpack200.Segment;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EnclosingMethodAttribute_resolve_3_1_Test {

    private ClassConstantPool classConstantPool;

    private CPUTF8 utf8Name;

    private CPClass cpClass;

    private CPUTF8 utf8Descriptor;

    private CPNameAndType cpNameAndType;

    private EnclosingMethodAttribute enclosingMethodAttribute;

    @BeforeEach
    void setUp() {
        utf8Name = new CPUTF8("TestClass");
        cpClass = new CPClass(utf8Name, 1);
        utf8Descriptor = new CPUTF8("TestMethod()V");
        cpNameAndType = new CPNameAndType(utf8Name, utf8Descriptor, 2);
        classConstantPool = new ClassConstantPool();
        enclosingMethodAttribute = new EnclosingMethodAttribute(cpClass, cpNameAndType);
    }

    @Test
    void testResolveWithMethod() {
        // Simulate resolving the class constant pool
        classConstantPool.resolve(mock(Segment.class));
        enclosingMethodAttribute.resolve(classConstantPool);
        // Use reflection to access private fields for assertions
        assertEquals(1, getPrivateField(enclosingMethodAttribute, "classIndex"));
        assertEquals(2, getPrivateField(enclosingMethodAttribute, "methodIndex"));
    }

    @Test
    void testResolveWithoutMethod() {
        enclosingMethodAttribute = new EnclosingMethodAttribute(cpClass, null);
        classConstantPool.resolve(mock(Segment.class));
        enclosingMethodAttribute.resolve(classConstantPool);
        assertEquals(1, getPrivateField(enclosingMethodAttribute, "classIndex"));
        assertEquals(0, getPrivateField(enclosingMethodAttribute, "methodIndex"));
    }

    @Test
    void testResolveWithUnresolvedPool() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            enclosingMethodAttribute.resolve(new ClassConstantPool());
        });
        assertEquals("Constant pool is not yet resolved; this does not make any sense", thrown.getMessage());
    }

    @Test
    void testResolveWithNullIndexCache() {
        classConstantPool.indexCache = null;
        classConstantPool.resolve(mock(Segment.class));
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            enclosingMethodAttribute.resolve(classConstantPool);
        });
        assertEquals("Index cache is not initialized!", thrown.getMessage());
    }

    // Helper method to access private fields using reflection
    private Object getPrivateField(EnclosingMethodAttribute attribute, String fieldName) {
        try {
            java.lang.reflect.Field field = EnclosingMethodAttribute.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(attribute);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
