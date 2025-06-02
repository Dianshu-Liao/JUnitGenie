package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Pack200ClassReader;
import org.junit.Test;
import static org.junit.Assert.*;

public class harmony_pack200_Pack200ClassReader_readUnsignedShort_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadUnsignedShortWithIndexGreaterThanZero() {
        // Arrange
        byte[] mockBytes = new byte[] {0, 0, 19}; // Setting up a byte array to test
        Pack200ClassReader reader = new Pack200ClassReader(mockBytes);
        int index = 1; // Changed index to 1 to point to a valid byte

        // Act
        int result = reader.readUnsignedShort(index); // Expecting that the lastUnsignedShort is set to unsignedShort

        // Assert
        assertNotEquals(Short.MIN_VALUE, result); // Make sure it doesn't use Short.MIN_VALUE
    }

    @Test(timeout = 4000)
    public void testReadUnsignedShortWithIndexZero() {
        // Arrange
        byte[] mockBytes = new byte[] {0, 0}; // Changed to have two bytes
        Pack200ClassReader reader = new Pack200ClassReader(mockBytes);
        int index = 0; // index is 0 which will trigger lastUnsignedShort to be set to Short.MIN_VALUE

        // Act
        int result = reader.readUnsignedShort(index);

        // Assert
        // Since lastUnsignedShort is private, we need to check the result directly
        assertEquals(0, result); // Expecting the result to be 0 since the byte array has only one byte
    }

    @Test(timeout = 4000)
    public void testReadUnsignedShortWithIndexOutOfBounds() {
        // Arrange
        byte[] mockBytes = new byte[] {0, 0, 19}; // Enough bytes for our test
        Pack200ClassReader reader = new Pack200ClassReader(mockBytes);
        int index = 3; // index points out of bounds 

        // Act
        try {
            reader.readUnsignedShort(index);
            fail("Expected an exception to be thrown due to index being out of bounds");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}