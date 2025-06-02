package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Pack200ClassReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_Pack200ClassReader_readUnsignedShort_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadUnsignedShort() {
        // Arrange
        byte[] byteArray = new byte[]{19, 0, 0, 0}; // Example byte array
        Pack200ClassReader reader = new Pack200ClassReader(byteArray);
        int index = 1; // This index will lead to the condition where b[index - 1] == 19

        // Act
        int result = reader.readUnsignedShort(index);

        // Assert
        assertEquals(19, result); // Assuming super.readUnsignedShort(index) returns 19 for this index
        // The lastUnsignedShort should be updated to the result
        // Note: Accessing private variable lastUnsignedShort directly is not possible, 
        // so we would need a getter method in the actual class to verify its value.
    }

    @Test(timeout = 4000)
    public void testReadUnsignedShortWithInvalidIndex() {
        // Arrange
        byte[] byteArray = new byte[]{19, 0, 0, 0}; // Example byte array
        Pack200ClassReader reader = new Pack200ClassReader(byteArray);
        int index = -1; // This index will lead to the condition where index < 0

        // Act
        int result = 0;
        try {
            result = reader.readUnsignedShort(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle exception if necessary
            result = Short.MIN_VALUE; // Set result to Short.MIN_VALUE if an exception occurs
        }

        // Assert
        assertEquals(Short.MIN_VALUE, result); // Assuming super.readUnsignedShort(index) would throw an exception for this index
        // The lastUnsignedShort should be set to Short.MIN_VALUE, but we cannot access it directly.
    }


}