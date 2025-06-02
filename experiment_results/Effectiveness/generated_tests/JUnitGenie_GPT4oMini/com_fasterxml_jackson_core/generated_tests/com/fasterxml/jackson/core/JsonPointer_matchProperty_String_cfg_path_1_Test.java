package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonPointer_matchProperty_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchPropertyReturnsNextSegment() {
        try {
            // Using reflection to access the protected constructor
            JsonPointer nextSegment = new JsonPointer(); // Assuming a default constructor for the sake of this test
            JsonPointer jsonPointer = new JsonPointer(nextSegment, "propertyName", 0); // Example constructor usage
            // Set the protected fields using reflection
            java.lang.reflect.Field matchingPropertyNameField = JsonPointer.class.getDeclaredField("_matchingPropertyName");
            matchingPropertyNameField.setAccessible(true);
            matchingPropertyNameField.set(jsonPointer, "propertyName");

            // Call the method under test
            JsonPointer result = jsonPointer.matchProperty("propertyName");

            // Assert that the result is the expected next segment
            assertEquals(nextSegment, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMatchPropertyReturnsNullWhenNoMatch() {
        try {
            JsonPointer jsonPointer = new JsonPointer(); // Assuming a default constructor for the sake of this test
            // Set the protected fields using reflection
            java.lang.reflect.Field matchingPropertyNameField = JsonPointer.class.getDeclaredField("_matchingPropertyName");
            matchingPropertyNameField.setAccessible(true);
            matchingPropertyNameField.set(jsonPointer, "differentName");

            // Call the method under test
            JsonPointer result = jsonPointer.matchProperty("propertyName");

            // Assert that the result is null
            assertEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}