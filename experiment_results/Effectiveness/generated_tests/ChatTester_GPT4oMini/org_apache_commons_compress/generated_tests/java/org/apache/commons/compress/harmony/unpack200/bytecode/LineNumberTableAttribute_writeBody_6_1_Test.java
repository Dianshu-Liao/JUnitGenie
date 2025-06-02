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

public class LineNumberTableAttribute_writeBody_6_1_Test {

    private LineNumberTableAttribute lineNumberTableAttribute;

    private DataOutputStream dataOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    public void setUp() {
        int lineNumberTableLength = 3;
        int[] startPcs = { 10, 20, 30 };
        int[] lineNumbers = { 1, 2, 3 };
        lineNumberTableAttribute = new LineNumberTableAttribute(lineNumberTableLength, startPcs, lineNumbers);
        byteArrayOutputStream = new ByteArrayOutputStream();
        dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    @Test
    public void testWriteBody() throws IOException {
        // Invoke the focal method
        lineNumberTableAttribute.writeBody(dataOutputStream);
        // Verify the output
        byte[] expectedOutput = new byte[] { // lineNumberTableLength (short)
        // lineNumberTableLength (short)
        // startPcs[0] (short)
        0, // startPcs[0] (short)
        3, // lineNumbers[0] (short)
        0, // lineNumbers[0] (short)
        10, // startPcs[1] (short)
        0, // startPcs[1] (short)
        1, // lineNumbers[1] (short)
        0, // lineNumbers[1] (short)
        20, // startPcs[2] (short)
        0, // startPcs[2] (short)
        2, // lineNumbers[2] (short)
        0, // lineNumbers[2] (short)
        30, 0, 3 };
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }
}
