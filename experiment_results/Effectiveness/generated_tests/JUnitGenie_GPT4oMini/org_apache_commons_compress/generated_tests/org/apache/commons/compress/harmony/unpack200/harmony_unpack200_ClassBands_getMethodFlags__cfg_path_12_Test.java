package org.apache.commons.compress.harmony.unpack200;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class harmony_unpack200_ClassBands_getMethodFlags__cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testGetMethodFlags() {
        // Arrange
        Segment segment = new Segment(); // Assuming a default constructor is available
        ClassBands classBands = new ClassBands(segment);
        
        // Initialize methodFlags for testing
        long[][] methodFlags = new long[2][2]; // Example initialization
        methodFlags[0][0] = 0b0000000000000001; // Example values
        methodFlags[0][1] = 0b0000000000000010;
        methodFlags[1][0] = 0b0000000000000100;
        methodFlags[1][1] = 0b0000000000001000;
        
        // Set the private field methodFlags using reflection
        try {
            java.lang.reflect.Field field = ClassBands.class.getDeclaredField("methodFlags");
            field.setAccessible(true);
            field.set(classBands, methodFlags);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        long[][] result = classBands.getMethodFlags();

        // Assert
        long[][] expected = new long[2][2]; // Expected output based on the logic
        expected[0][0] = methodFlags[0][0] & 0x7FFF; // Apply mask
        expected[0][1] = methodFlags[0][1] & 0x7FFF;
        expected[1][0] = methodFlags[1][0] & 0x7FFF;
        expected[1][1] = methodFlags[1][1] & 0x7FFF;

        assertArrayEquals(expected, result);
    }


}