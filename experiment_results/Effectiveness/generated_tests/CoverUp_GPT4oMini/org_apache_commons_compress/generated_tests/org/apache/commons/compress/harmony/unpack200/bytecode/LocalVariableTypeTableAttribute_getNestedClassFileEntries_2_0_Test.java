package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
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

class LocalVariableTypeTableAttribute_getNestedClassFileEntries_2_0_Test {

    private LocalVariableTypeTableAttribute localVariableTypeTableAttribute;

    @BeforeEach
    void setUp() {
        // Initialize the CPUTF8 objects
        CPUTF8 name1 = new CPUTF8("name1");
        CPUTF8 signature1 = new CPUTF8("signature1");
        CPUTF8 name2 = new CPUTF8("name2");
        CPUTF8 signature2 = new CPUTF8("signature2");
        // Initialize the LocalVariableTypeTableAttribute with test data
        int[] startPcs = { 0, 1 };
        int[] lengths = { 10, 20 };
        CPUTF8[] names = { name1, name2 };
        CPUTF8[] signatures = { signature1, signature2 };
        int[] indexes = { 0, 1 };
        localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(2, startPcs, lengths, names, signatures, indexes);
        // Set the attribute name using the static method
        LocalVariableTypeTableAttribute.setAttributeName(new CPUTF8("LocalVariableTypeTable"));
    }

    @Test
    void testGetNestedClassFileEntries() throws Exception {
        // Invoke the private method using reflection
        Method method = LocalVariableTypeTableAttribute.class.getDeclaredMethod("getNestedClassFileEntries");
        method.setAccessible(true);
        // Execute the method
        ClassFileEntry[] result = (ClassFileEntry[]) method.invoke(localVariableTypeTableAttribute);
        // Assertions to verify the results
        assertNotNull(result);
        // 1 attribute name + 2 names + 2 signatures
        assertEquals(4, result.length);
        // Check the attribute name
        assertEquals("LocalVariableTypeTable", result[0].toString());
        // Check the names
        assertEquals("name1", result[1].toString());
        assertEquals("name2", result[2].toString());
        // Check the signatures
        assertEquals("signature1", result[3].toString());
        assertEquals("signature2", result[4].toString());
    }
}
