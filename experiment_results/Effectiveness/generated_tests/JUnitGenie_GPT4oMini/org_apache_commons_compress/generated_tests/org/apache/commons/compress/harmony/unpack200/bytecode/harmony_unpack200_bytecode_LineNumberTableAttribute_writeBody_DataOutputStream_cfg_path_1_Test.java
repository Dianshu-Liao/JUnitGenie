package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.apache.commons.compress.harmony.unpack200.bytecode.LineNumberTableAttribute;
import org.junit.Test;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class harmony_unpack200_bytecode_LineNumberTableAttribute_writeBody_DataOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteBody() {
        // Arrange
        int[] startPcs = {0, 1, 2};
        int[] lineNumbers = {10, 11, 12};
        int lineNumberTableLength = startPcs.length;

        LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(lineNumberTableLength, startPcs, lineNumbers);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);

        // Act
        try {
            Method method = LineNumberTableAttribute.class.getDeclaredMethod("writeBody", DataOutputStream.class);
            method.setAccessible(true);
            method.invoke(lineNumberTableAttribute, dos);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        byte[] expectedOutput = new byte[] {
            0, 3, // lineNumberTableLength
            0, 0, // startPcs[0]
            0, 10, // lineNumbers[0]
            0, 1, // startPcs[1]
            0, 11, // lineNumbers[1]
            0, 2, // startPcs[2]
            0, 12  // lineNumbers[2]
        };
        assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
    }

}