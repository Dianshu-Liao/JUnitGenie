package org.apache.commons.compress.harmony.unpack200.bytecode;

import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.LocalVariableTableAttribute;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;

public class LocalVariableTableAttribute_writeBody_8_0_Test {

    private LocalVariableTableAttribute localVariableTableAttribute;

    private DataOutputStream dataOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        // Sample data for testing
        int localVariableTableLength = 2;
        int[] startPcs = { 0, 10 };
        int[] lengths = { 10, 20 };
        CPUTF8[] names = { new CPUTF8("var1"), new CPUTF8("var2") };
        CPUTF8[] descriptors = { new CPUTF8("int"), new CPUTF8("String") };
        int[] indexes = { 1, 2 };
        localVariableTableAttribute = new LocalVariableTableAttribute(localVariableTableLength, startPcs, lengths, names, descriptors, indexes);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testWriteBody() throws IOException {
        // Invoke the focal method
        invokeWriteBody(localVariableTableAttribute, dataOutputStream);
        // Expected output
        byte[] expectedOutput = new byte[] { // localVariableTableLength
        // localVariableTableLength
        // startPcs[0]
        // startPcs[0]
        0, // lengths[0]
        2, // lengths[0]
        0, // nameIndexes[0] (assuming index for "var1")
        0, // nameIndexes[0] (assuming index for "var1")
        0, // descriptorIndexes[0] (assuming index for "int")
        10, // descriptorIndexes[0] (assuming index for "int")
        0, // indexes[0]
        1, // indexes[0]
        0, // startPcs[1]
        4, // startPcs[1]
        0, // lengths[1]
        1, // lengths[1]
        0, // nameIndexes[1] (assuming index for "var2")
        10, // nameIndexes[1] (assuming index for "var2")
        0, // descriptorIndexes[1] (assuming index for "String")
        20, // descriptorIndexes[1] (assuming index for "String")
        0, // indexes[1]
        2, // indexes[1]
        0, 6, 0, 2 };
        // Assert the output
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

    private void invokeWriteBody(LocalVariableTableAttribute attribute, DataOutputStream dos) throws IOException {
        try {
            Method method = LocalVariableTableAttribute.class.getDeclaredMethod("writeBody", DataOutputStream.class);
            method.setAccessible(true);
            method.invoke(attribute, dos);
        } catch (Exception e) {
            throw new IOException("Failed to invoke writeBody", e);
        }
    }
}
