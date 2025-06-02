package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

    private final int localVariableTableLength = 3;

    private final int[] startPcs = { 0, 1, 2 };

    private final int[] lengths = { 10, 20, 30 };

    private final int[] nameIndexes = { 1, 2, 3 };

    private final int[] descriptorIndexes = { 4, 5, 6 };

    private final int[] indexes = { 7, 8, 9 };

    private final CPUTF8[] names = { new CPUTF8("name1"), new CPUTF8("name2"), new CPUTF8("name3") };

    private final CPUTF8[] descriptors = { new CPUTF8("descriptor1"), new CPUTF8("descriptor2"), new CPUTF8("descriptor3") };

    @BeforeEach
    public void setUp() {
        // Adjust the constructor call to match the parameters required by LocalVariableTableAttribute
        localVariableTableAttribute = new LocalVariableTableAttribute(localVariableTableLength, startPcs, lengths, names, descriptors, indexes);
    }

    @Test
    public void testWriteBody() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        localVariableTableAttribute.writeBody(dataOutputStream);
        byte[] expectedOutput = new byte[] { // localVariableTableLength
        // localVariableTableLength
        // startPcs[0]
        // startPcs[0]
        0, // lengths[0]
        3, // lengths[0]
        0, // nameIndexes[0]
        0, // nameIndexes[0]
        0, // descriptorIndexes[0]
        10, // descriptorIndexes[0]
        0, // indexes[0]
        1, // indexes[0]
        0, // startPcs[1]
        4, // startPcs[1]
        0, // lengths[1]
        7, // lengths[1]
        0, // nameIndexes[1]
        1, // nameIndexes[1]
        0, // descriptorIndexes[1]
        20, // descriptorIndexes[1]
        0, // indexes[1]
        2, // indexes[1]
        0, // startPcs[2]
        5, // startPcs[2]
        0, // lengths[2]
        8, // lengths[2]
        0, // nameIndexes[2]
        2, // nameIndexes[2]
        0, // descriptorIndexes[2]
        30, // descriptorIndexes[2]
        0, // indexes[2]
        3, // indexes[2]
        0, 6, 0, 9 };
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }
}
