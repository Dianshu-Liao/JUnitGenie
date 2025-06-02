package org.apache.commons.compress.harmony.unpack200.bytecode;

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

class LineNumberTableAttribute_writeBody_6_0_Test {

    private LineNumberTableAttribute lineNumberTableAttribute;

    private int lineNumberTableLength = 2;

    private int[] startPcs = { 10, 20 };

    private int[] lineNumbers = { 1, 2 };

    @BeforeEach
    void setUp() {
        lineNumberTableAttribute = new LineNumberTableAttribute(lineNumberTableLength, startPcs, lineNumbers);
    }

    @Test
    void testWriteBody() throws IOException, ReflectiveOperationException {
        // Prepare a DataOutputStream to capture the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        // Invoke the writeBody method using reflection
        Method method = LineNumberTableAttribute.class.getDeclaredMethod("writeBody", DataOutputStream.class);
        method.setAccessible(true);
        method.invoke(lineNumberTableAttribute, dataOutputStream);
        // Convert the output to a byte array
        byte[] output = byteArrayOutputStream.toByteArray();
        // Verify the output
        assertEquals(2 + 4 * lineNumberTableLength, output.length);
        // First byte of length
        assertEquals(0, output[0]);
        // Second byte of length
        assertEquals(2, output[1]);
        assertArrayEquals(new byte[] { 0, 10, 0, 1, 0, 20, 0, 2 }, new byte[] { // startPcs[0]
        // startPcs[0]
        // lineNumbers[0]
        // lineNumbers[0]
        output[2], // startPcs[1]
        output[3], // startPcs[1]
        output[4], // lineNumbers[1]
        output[5], // lineNumbers[1]
        output[6], output[7], output[8], output[9] });
    }
}
