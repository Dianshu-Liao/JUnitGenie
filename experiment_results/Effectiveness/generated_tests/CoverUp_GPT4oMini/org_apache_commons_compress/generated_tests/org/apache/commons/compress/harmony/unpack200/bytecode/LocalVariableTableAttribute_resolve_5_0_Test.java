package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LocalVariableTableAttribute_resolve_5_0_Test {

    private LocalVariableTableAttribute localVariableTableAttribute;

    private ClassConstantPool classConstantPool;

    @BeforeEach
    void setUp() {
        CPUTF8[] names = { new CPUTF8("var1"), new CPUTF8("var2") };
        CPUTF8[] descriptors = { new CPUTF8("int"), new CPUTF8("String") };
        int[] startPcs = { 0, 1 };
        int[] lengths = { 1, 1 };
        localVariableTableAttribute = new LocalVariableTableAttribute(2, startPcs, lengths, names, descriptors, new int[] { 0, 1 });
        classConstantPool = new ClassConstantPool();
    }

    @Test
    void testResolve() throws Exception {
        Method indexOfMethod = ClassConstantPool.class.getDeclaredMethod("indexOf", ClassFileEntry.class);
        indexOfMethod.setAccessible(true);
        Method resolveMethod = LocalVariableTableAttribute.class.getDeclaredMethod("resolve", ClassConstantPool.class);
        resolveMethod.setAccessible(true);
        resolveMethod.invoke(localVariableTableAttribute, classConstantPool);
        // Use reflection to access private fields
        Field nameIndexesField = LocalVariableTableAttribute.class.getDeclaredField("nameIndexes");
        nameIndexesField.setAccessible(true);
        int[] nameIndexes = (int[]) nameIndexesField.get(localVariableTableAttribute);
        Field descriptorIndexesField = LocalVariableTableAttribute.class.getDeclaredField("descriptorIndexes");
        descriptorIndexesField.setAccessible(true);
        int[] descriptorIndexes = (int[]) descriptorIndexesField.get(localVariableTableAttribute);
        assertNotNull(nameIndexes);
        assertNotNull(descriptorIndexes);
        assertEquals(2, nameIndexes.length);
        assertEquals(2, descriptorIndexes.length);
    }
}
