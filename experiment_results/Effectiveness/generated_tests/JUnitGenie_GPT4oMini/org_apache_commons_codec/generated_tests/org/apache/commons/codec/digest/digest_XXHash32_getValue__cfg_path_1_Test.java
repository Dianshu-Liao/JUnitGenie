package org.apache.commons.codec.digest;
import org.apache.commons.codec.digest.XXHash32;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class digest_XXHash32_getValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetValueWithStateUpdated() {
        XXHash32 xxHash32 = new XXHash32();
        // Set up the internal state to simulate stateUpdated being true
        setPrivateField(xxHash32, "stateUpdated", true);
        setPrivateField(xxHash32, "totalLen", 10);
        setPrivateField(xxHash32, "state", new int[]{1, 2, 3, 4});
        setPrivateField(xxHash32, "pos", 16);
        setPrivateField(xxHash32, "buffer", new byte[16]);

        long expectedValue = 123456789L; // Replace with the actual expected value
        long actualValue = xxHash32.getValue();
        assertEquals(expectedValue, actualValue);
    }

    @Test(timeout = 4000)
    public void testGetValueWithStateNotUpdated() {
        XXHash32 xxHash32 = new XXHash32();
        // Set up the internal state to simulate stateUpdated being false
        setPrivateField(xxHash32, "stateUpdated", false);
        setPrivateField(xxHash32, "totalLen", 10);
        setPrivateField(xxHash32, "state", new int[]{1, 2, 3, 4});
        setPrivateField(xxHash32, "pos", 16);
        setPrivateField(xxHash32, "buffer", new byte[16]);

        long expectedValue = 987654321L; // Replace with the actual expected value
        long actualValue = xxHash32.getValue();
        assertEquals(expectedValue, actualValue);
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}