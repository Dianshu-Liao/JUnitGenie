package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_schubfach_FloatToDecimal_removeTrailingZeroes__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveTrailingZeroes() {
        try {
            // Create an instance of FloatToDecimal using reflection
            FloatToDecimal floatToDecimal = FloatToDecimal.class.getDeclaredConstructor().newInstance();
            
            // Set the private final field 'bytes' using reflection
            java.lang.reflect.Field bytesField = FloatToDecimal.class.getDeclaredField("bytes");
            bytesField.setAccessible(true);
            bytesField.set(floatToDecimal, new byte[] {'1', '2', '3', '0', '0', '0', '.'}); // Example input
            
            // Set the private field 'index' using reflection
            java.lang.reflect.Field indexField = FloatToDecimal.class.getDeclaredField("index");
            indexField.setAccessible(true);
            indexField.set(floatToDecimal, 6); // Set index to the last character position
            
            // Invoke the private method 'removeTrailingZeroes' using reflection
            Method method = FloatToDecimal.class.getDeclaredMethod("removeTrailingZeroes");
            method.setAccessible(true);
            method.invoke(floatToDecimal);
            
            // Verify the result
            byte[] expectedBytes = new byte[] {'1', '2', '3', '.'}; // Expected output after removing trailing zeroes
            byte[] actualBytes = (byte[]) bytesField.get(floatToDecimal);
            assertArrayEquals(expectedBytes, actualBytes);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}