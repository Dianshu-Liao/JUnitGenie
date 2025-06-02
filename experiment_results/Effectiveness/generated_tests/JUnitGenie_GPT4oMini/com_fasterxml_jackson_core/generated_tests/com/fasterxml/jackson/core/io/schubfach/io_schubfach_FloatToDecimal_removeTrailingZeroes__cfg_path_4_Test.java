package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class io_schubfach_FloatToDecimal_removeTrailingZeroes__cfg_path_4_Test {

    private FloatToDecimal floatToDecimal;
    private byte[] testBytes;
    private int testIndex;

    @Before
    public void setUp() throws Exception {
        testBytes = new byte[] {'1', '2', '3', '0', '0', '.'};
        testIndex = 5; // Pointing to the last '0'
        
        // Use reflection to create an instance of the private class
        floatToDecimal = FloatToDecimal.class.getDeclaredConstructor().newInstance();
        
        // Set the private final bytes and index fields
        setPrivateField(floatToDecimal, "bytes", testBytes);
        setPrivateField(floatToDecimal, "index", testIndex);
    }

    @Test(timeout = 4000)
    public void testRemoveTrailingZeroes() throws Exception {
        // Access the private method using reflection
        Method method = FloatToDecimal.class.getDeclaredMethod("removeTrailingZeroes");
        method.setAccessible(true);
        
        // Execute the focal method
        method.invoke(floatToDecimal);
        
        // Modify the expected outcome based on the removal of trailing zeroes
        byte[] expectedBytes = new byte[] {'1', '2', '3', '.', '0'};  // Expect the last '0' to be removed

        // Use reflection to retrieve the modified bytes array
        byte[] actualBytes = (byte[]) getPrivateField(floatToDecimal, "bytes");

        // Assert that the actual bytes array matches the expected
        assertArrayEquals(expectedBytes, actualBytes);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

}