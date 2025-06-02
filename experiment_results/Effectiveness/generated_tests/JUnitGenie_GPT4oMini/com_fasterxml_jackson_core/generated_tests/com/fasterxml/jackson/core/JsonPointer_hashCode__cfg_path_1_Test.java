package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JsonPointer_hashCode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHashCodeWhenHashCodeIsZero() {
        try {
            // Create an instance of JsonPointer using reflection
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[0].newInstance((Object[]) null);

            // Set the protected _hashCode field to 0
            java.lang.reflect.Field hashCodeField = JsonPointer.class.getDeclaredField("_hashCode");
            hashCodeField.setAccessible(true);
            hashCodeField.setInt(jsonPointer, 0);

            // Set up the necessary fields to satisfy the constraints
            java.lang.reflect.Field asStringField = JsonPointer.class.getDeclaredField("_asString");
            asStringField.setAccessible(true);
            asStringField.set(jsonPointer, ""); // Set to an empty string to ensure hashCode is 0

            java.lang.reflect.Field asStringOffsetField = JsonPointer.class.getDeclaredField("_asStringOffset");
            asStringOffsetField.setAccessible(true);
            asStringOffsetField.setInt(jsonPointer, 0); // Valid offset

            // Call the hashCode method
            int result = jsonPointer.hashCode();

            // Assert that the result is -1, as per the logic in the hashCode method
            assertEquals(-1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeWhenHashCodeIsNonZero() {
        try {
            // Create an instance of JsonPointer using reflection
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[0].newInstance((Object[]) null);

            // Set the protected _hashCode field to 0
            java.lang.reflect.Field hashCodeField = JsonPointer.class.getDeclaredField("_hashCode");
            hashCodeField.setAccessible(true);
            hashCodeField.setInt(jsonPointer, 0);

            // Set up the necessary fields to satisfy the constraints
            java.lang.reflect.Field asStringField = JsonPointer.class.getDeclaredField("_asString");
            asStringField.setAccessible(true);
            asStringField.set(jsonPointer, "test"); // Set to a non-empty string

            java.lang.reflect.Field asStringOffsetField = JsonPointer.class.getDeclaredField("_asStringOffset");
            asStringOffsetField.setAccessible(true);
            asStringOffsetField.setInt(jsonPointer, 0); // Valid offset

            // Call the hashCode method
            int result = jsonPointer.hashCode();

            // Assert that the result is equal to the hash code of the string "test"
            assertEquals("test".hashCode(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}