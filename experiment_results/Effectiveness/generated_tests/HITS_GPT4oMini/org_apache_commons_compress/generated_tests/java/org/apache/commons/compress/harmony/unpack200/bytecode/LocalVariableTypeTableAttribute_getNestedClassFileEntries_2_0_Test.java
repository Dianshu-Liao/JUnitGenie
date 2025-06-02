package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class LocalVariableTypeTableAttribute_getNestedClassFileEntries_2_0_Test {

    private LocalVariableTypeTableAttribute localVariableTypeTableAttribute;

    @BeforeEach
    public void setUp() {
        // Initialize the LocalVariableTypeTableAttribute with mock data
        int localVariableTypeTableLength = 2;
        int[] startPcs = { 0, 1 };
        int[] lengths = { 1, 1 };
        CPUTF8[] names = { new CPUTF8("name1"), new CPUTF8("name2") };
        CPUTF8[] signatures = { new CPUTF8("signature1"), new CPUTF8("signature2") };
        int[] indexes = { 0, 1 };
        localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(localVariableTypeTableLength, startPcs, lengths, names, signatures, indexes);
    }

    @Test
    public void testGetNestedClassFileEntries() {
        CPUTF8 attributeName = localVariableTypeTableAttribute.getAttributeName();
        ClassFileEntry[] expectedEntries = new ClassFileEntry[] { attributeName, new CPUTF8("name1"), new CPUTF8("signature1"), new CPUTF8("name2"), new CPUTF8("signature2") };
        ClassFileEntry[] actualEntries = localVariableTypeTableAttribute.getNestedClassFileEntries();
        assertArrayEquals(expectedEntries, actualEntries);
    }
}
