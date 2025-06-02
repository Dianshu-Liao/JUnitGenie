package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LocalVariableTableAttribute_resolve_5_3_Test {

    private LocalVariableTableAttribute localVariableTableAttribute;

    private ClassConstantPool classConstantPool;

    @BeforeEach
    public void setUp() {
        classConstantPool = mock(ClassConstantPool.class);
        localVariableTableAttribute = new LocalVariableTableAttribute(2, new int[] { 0, 1 }, new int[] { 1, 1 }, new CPUTF8[] {}, new CPUTF8[] {}, new int[] {});
    }

    @Test
    public void testResolveWithValidPool() throws Exception {
        CPUTF8 name1 = new CPUTF8("variable1");
        CPUTF8 descriptor1 = new CPUTF8("int");
        CPUTF8 name2 = new CPUTF8("variable2");
        CPUTF8 descriptor2 = new CPUTF8("String");
        setPrivateField(localVariableTableAttribute, "names", new CPUTF8[] { name1, name2 });
        setPrivateField(localVariableTableAttribute, "descriptors", new CPUTF8[] { descriptor1, descriptor2 });
        when(classConstantPool.indexOf(name1)).thenReturn(0);
        when(classConstantPool.indexOf(descriptor1)).thenReturn(1);
        when(classConstantPool.indexOf(name2)).thenReturn(2);
        when(classConstantPool.indexOf(descriptor2)).thenReturn(3);
        localVariableTableAttribute.resolve(classConstantPool);
        int[] nameIndexes = (int[]) getPrivateField(localVariableTableAttribute, "nameIndexes");
        int[] descriptorIndexes = (int[]) getPrivateField(localVariableTableAttribute, "descriptorIndexes");
        assertNotNull(nameIndexes);
        assertNotNull(descriptorIndexes);
        assertEquals(2, nameIndexes.length);
        assertEquals(2, descriptorIndexes.length);
        assertTrue(nameIndexes[0] >= 0);
        assertTrue(nameIndexes[1] >= 0);
        assertTrue(descriptorIndexes[0] >= 0);
        assertTrue(descriptorIndexes[1] >= 0);
    }

    @Test
    public void testResolveWithEmptyNamesAndDescriptors() throws Exception {
        setPrivateField(localVariableTableAttribute, "names", new CPUTF8[] {});
        setPrivateField(localVariableTableAttribute, "descriptors", new CPUTF8[] {});
        localVariableTableAttribute.resolve(classConstantPool);
        int[] nameIndexes = (int[]) getPrivateField(localVariableTableAttribute, "nameIndexes");
        assertNotNull(nameIndexes);
        assertEquals(0, nameIndexes.length);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
