package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class LocalVariableTypeTableAttribute_getNestedClassFileEntries_2_0_Test {

    private LocalVariableTypeTableAttribute localVariableTypeTableAttribute;

    private CPUTF8 mockName1;

    private CPUTF8 mockName2;

    private CPUTF8 mockSignature1;

    private CPUTF8 mockSignature2;

    @BeforeEach
    public void setUp() {
        mockName1 = mock(CPUTF8.class);
        mockName2 = mock(CPUTF8.class);
        mockSignature1 = mock(CPUTF8.class);
        mockSignature2 = mock(CPUTF8.class);
        int localVariableTypeTableLength = 2;
        int[] startPcs = { 0, 1 };
        int[] lengths = { 1, 1 };
        CPUTF8[] names = { mockName1, mockName2 };
        CPUTF8[] signatures = { mockSignature1, mockSignature2 };
        int[] indexes = { 0, 1 };
        localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(localVariableTypeTableLength, startPcs, lengths, names, signatures, indexes);
    }

    @Test
    public void testGetNestedClassFileEntries() throws Exception {
        // Invoke the private method using reflection
        Method method = LocalVariableTypeTableAttribute.class.getDeclaredMethod("getNestedClassFileEntries");
        method.setAccessible(true);
        ClassFileEntry[] result = (ClassFileEntry[]) method.invoke(localVariableTypeTableAttribute);
        // Verify the expected output
        assertNotNull(result);
        // 1 attribute name + 2 names + 2 signatures
        assertEquals(4, result.length);
        // Corrected line to access the instance method
        assertEquals(localVariableTypeTableAttribute.getAttributeName(), result[0]);
        // Check names and signatures
        assertEquals(mockName1, result[1]);
        assertEquals(mockSignature1, result[2]);
        assertEquals(mockName2, result[3]);
        assertEquals(mockSignature2, result[4]);
    }
}
