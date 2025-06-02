package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Pack200ClassReader;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_Pack200ClassReader_readUnsignedShort_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReadUnsignedShortWhenIndexIsLessThanOrEqualToZero() {
        // Arrange
        byte[] dummyData = new byte[10]; // Dummy data for constructor
        Pack200ClassReader reader = new Pack200ClassReader(dummyData);
        int index = 0; // Index is less than or equal to zero

        // Act
        int result = reader.readUnsignedShort(index);

        // Assert
        // Since lastUnsignedShort is private, we cannot access it directly.
        // Assuming readUnsignedShort sets lastUnsignedShort, we can check the result instead.
        assertEquals(Short.MIN_VALUE, result);
    }


}