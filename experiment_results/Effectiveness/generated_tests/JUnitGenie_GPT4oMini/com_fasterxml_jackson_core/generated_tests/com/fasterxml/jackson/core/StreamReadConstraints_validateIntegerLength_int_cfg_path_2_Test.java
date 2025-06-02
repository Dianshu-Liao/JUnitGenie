package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.junit.Test;
import static org.junit.Assert.*;

public class StreamReadConstraints_validateIntegerLength_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidateIntegerLength() {
        try {
            // Create an instance of StreamReadConstraints using reflection
            Class<?> clazz = StreamReadConstraints.class;
            java.lang.reflect.Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, long.class, int.class, int.class);
            constructor.setAccessible(true);
            StreamReadConstraints constraints = (StreamReadConstraints) constructor.newInstance(0, 0L, 0, 0);

            // Set the _maxNumLen field using reflection
            java.lang.reflect.Field maxNumLenField = clazz.getDeclaredField("_maxNumLen");
            maxNumLenField.setAccessible(true);
            maxNumLenField.setInt(constraints, 5); // Set max length to 5

            // Test with a valid length
            constraints.validateIntegerLength(5); // Should not throw an exception

            // Test with an invalid length
            constraints.validateIntegerLength(6); // Should throw StreamReadConstraintsException
            fail("Expected StreamReadConstraintsException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception for invalid length
            fail("Unexpected exception: " + e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


}