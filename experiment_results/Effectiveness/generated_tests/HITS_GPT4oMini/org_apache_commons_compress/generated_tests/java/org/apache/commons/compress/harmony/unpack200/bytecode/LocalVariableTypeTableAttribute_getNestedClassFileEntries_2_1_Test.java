package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class LocalVariableTypeTableAttribute_getNestedClassFileEntries_2_1_Test {

    private LocalVariableTypeTableAttribute localVariableTypeTableAttribute;

    private int localVariableTypeTableLength;

    private CPUTF8[] names;

    private CPUTF8[] signatures;

    @BeforeEach
    public void setUp() {
        // Initialize the LocalVariableTypeTableAttribute instance with necessary parameters
        localVariableTypeTableLength = 2;
        int[] startPcs = { 0, 1 };
        int[] lengths = { 1, 1 };
        names = new CPUTF8[] { new CPUTF8("name1"), new CPUTF8("name2") };
        signatures = new CPUTF8[] { new CPUTF8("signature1"), new CPUTF8("signature2") };
        int[] indexes = { 0, 1 };
        localVariableTypeTableAttribute = new LocalVariableTypeTableAttribute(localVariableTypeTableLength, startPcs, lengths, names, signatures, indexes);
    }

    @Test
    public void testGetNestedClassFileEntries_NotNull() {
        ClassFileEntry[] result = localVariableTypeTableAttribute.getNestedClassFileEntries();
        assertNotNull(result, "The result should not be null.");
    }

    @Test
    public void testGetNestedClassFileEntries_ContainsAttributeName() {
        CPUTF8 expectedAttributeName = localVariableTypeTableAttribute.getAttributeName();
        ClassFileEntry[] result = localVariableTypeTableAttribute.getNestedClassFileEntries();
        assertArrayEquals(new CPUTF8[] { expectedAttributeName }, Arrays.copyOf(result, 1), "The first entry should be the attribute name.");
    }

    @Test
    public void testGetNestedClassFileEntries_ContainsCorrectNumberOfEntries() {
        int expectedLength = localVariableTypeTableLength * 2 + 1;
        ClassFileEntry[] result = localVariableTypeTableAttribute.getNestedClassFileEntries();
        assertEquals(expectedLength, result.length, "The number of entries should match the expected length.");
    }
}
