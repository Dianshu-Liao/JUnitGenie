package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonPointer_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCode() {
        try {
            // Create an instance of JsonPointer using reflection
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[1].newInstance("testString", 1, "testString", null);
            
            // Ensure the _hashCode is initially 0
            assertEquals(0, jsonPointer.hashCode());

            // Call hashCode to trigger the computation
            int hashCode = jsonPointer.hashCode();

            // Verify that the hashCode is not 0 after computation
            assertNotEquals(0, hashCode);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}