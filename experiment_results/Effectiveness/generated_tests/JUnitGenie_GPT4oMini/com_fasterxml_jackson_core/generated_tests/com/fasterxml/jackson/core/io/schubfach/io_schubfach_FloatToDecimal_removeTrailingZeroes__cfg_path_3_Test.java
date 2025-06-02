package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class io_schubfach_FloatToDecimal_removeTrailingZeroes__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveTrailingZeroes() {
        try {
            // Create an instance of FloatToDecimal using reflection
            FloatToDecimal floatToDecimal = FloatToDecimal.class.getDeclaredConstructor().newInstance();
            
            // Set the private final field 'bytes' using reflection
            java.lang.reflect.Field bytesField = FloatToDecimal.class.getDeclaredField("bytes");
            bytesField.setAccessible(true);
            byte[] testBytes = new byte[] {'1', '2', '3', '0', '0', '0', '.'}; // Example input
            bytesField.set(floatToDecimal, testBytes);
            
            // Set the private field 'index' using reflection
            java.lang.reflect.Field indexField = FloatToDecimal.class.getDeclaredField("index");
            indexField.setAccessible(true);
            indexField.set(floatToDecimal, testBytes.length - 1); // Set index to the last character
            
            // Access the private method 'removeTrailingZeroes' using reflection
            Method removeTrailingZeroesMethod = FloatToDecimal.class.getDeclaredMethod("removeTrailingZeroes");
            removeTrailingZeroesMethod.setAccessible(true);
            
            // Invoke the method
            removeTrailingZeroesMethod.invoke(floatToDecimal);
            
            // Verify the result
            byte[] resultBytes = (byte[]) bytesField.get(floatToDecimal);
            int resultIndex = (int) indexField.get(floatToDecimal);
            
            // Check that trailing zeroes are removed and index is updated correctly
            assertEquals('3', resultBytes[resultIndex]); // The last non-zero character should be '3'
            assertEquals(2, resultIndex); // Index should point to '3'
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}