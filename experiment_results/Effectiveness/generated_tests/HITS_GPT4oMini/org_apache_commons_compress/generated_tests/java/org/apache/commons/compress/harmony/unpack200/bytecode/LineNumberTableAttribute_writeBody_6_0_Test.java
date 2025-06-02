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

public class LineNumberTableAttribute_writeBody_6_0_Test {

    private LineNumberTableAttribute lineNumberTableAttribute;

    private DataOutputStream dataOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        // Initialize the fields for testing
        int[] startPcs = { 1, 2, 3 };
        int[] lineNumbers = { 10, 20, 30 };
        lineNumberTableAttribute = new LineNumberTableAttribute(3, startPcs, lineNumbers);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testWriteBody() throws IOException {
        // Call the method under test
        lineNumberTableAttribute.writeBody(dataOutputStream);
        // Expected output: first short for length, followed by pairs of shorts for startPcs and lineNumbers
        byte[] expectedOutput = new byte[] { // lineNumberTableLength
        // lineNumberTableLength
        // startPcs[0]
        0, // startPcs[0]
        3, // lineNumbers[0]
        0, // lineNumbers[0]
        1, // startPcs[1]
        0, // startPcs[1]
        10, // lineNumbers[1]
        0, // lineNumbers[1]
        2, // startPcs[2]
        0, // startPcs[2]
        20, // lineNumbers[2]
        0, // lineNumbers[2]
        3, 0, 30 };
        // Verify the output
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

    @Test
    public void testWriteBodyWithZeroLength() throws IOException {
        // Initialize with zero length
        lineNumberTableAttribute = new LineNumberTableAttribute(0, new int[] {}, new int[] {});
        // Clear the previous output
        byteArrayOutputStream.reset();
        // Call the method under test
        lineNumberTableAttribute.writeBody(dataOutputStream);
        // Expected output: just the length
        byte[] expectedOutput = new byte[] { // lineNumberTableLength
        // lineNumberTableLength
        0, 0 };
        // Verify the output
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }
}
