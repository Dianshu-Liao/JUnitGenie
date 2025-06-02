package org.apache.commons.compress.harmony.unpack200.bytecode;
import org.junit.Test;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class harmony_unpack200_bytecode_LocalVariableTableAttribute_writeBody_DataOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteBody() {
        // Prepare the data for the LocalVariableTableAttribute
        int[] startPcs = {0, 1, 2};
        int[] lengths = {3, 4, 5};
        int[] nameIndexes = {6, 7, 8};
        int[] descriptorIndexes = {9, 10, 11};
        int[] indexes = {12, 13, 14};
        
        // Create CPUTF8 instances for name and descriptor
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8[] nameUTF8s = {
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("name1"),
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("name2"),
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("name3")
        };
        
        org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8[] descriptorUTF8s = {
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("desc1"),
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("desc2"),
            new org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8("desc3")
        };
        
        LocalVariableTableAttribute localVariableTableAttribute = 
            new LocalVariableTableAttribute(3, startPcs, lengths, 
                nameUTF8s, descriptorUTF8s, 
                indexes);
        
        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(byteArrayOutputStream);
        
        try {
            // Access the protected method using reflection
            Method method = LocalVariableTableAttribute.class.getDeclaredMethod("writeBody", DataOutputStream.class);
            method.setAccessible(true);
            method.invoke(localVariableTableAttribute, dos);
            
            // Verify the output
            byte[] expectedOutput = new byte[] {
                0, 3, // localVariableTableLength
                0, 0, // startPcs[0]
                0, 3, // lengths[0]
                0, 6, // nameIndexes[0]
                0, 9, // descriptorIndexes[0]
                0, 12, // indexes[0]
                0, 1, // startPcs[1]
                0, 4, // lengths[1]
                0, 7, // nameIndexes[1]
                0, 10, // descriptorIndexes[1]
                0, 13, // indexes[1]
                0, 2, // startPcs[2]
                0, 5, // lengths[2]
                0, 8, // nameIndexes[2]
                0, 11, // descriptorIndexes[2]
                0, 14  // indexes[2]
            };
            
            assertArrayEquals(expectedOutput, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}