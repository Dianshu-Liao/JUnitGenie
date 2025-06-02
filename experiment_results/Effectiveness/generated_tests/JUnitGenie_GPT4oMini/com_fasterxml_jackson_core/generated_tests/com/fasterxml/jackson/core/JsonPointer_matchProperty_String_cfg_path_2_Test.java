package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.lang.reflect.Field;

public class JsonPointer_matchProperty_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchProperty_NextSegmentIsNull() {
        // Arrange
        JsonPointer jsonPointer = new JsonPointer(null, null); // Using reflection to access protected constructor
        // Set _matchingPropertyName to a value
        setField(jsonPointer, "_matchingPropertyName", "testName");

        // Act
        JsonPointer result = jsonPointer.matchProperty("testName");

        // Assert
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testMatchProperty_MatchingPropertyName() {
        // Arrange
        JsonPointer jsonPointer = new JsonPointer(null, null); // Using reflection to access protected constructor
        setField(jsonPointer, "_nextSegment", new JsonPointer(null, null)); // Set _nextSegment to a new JsonPointer
        setField(jsonPointer, "_matchingPropertyName", "testName");

        // Act
        JsonPointer result = jsonPointer.matchProperty("testName");

        // Assert
        assertNotNull(result); // Assuming _nextSegment is not null, we expect a non-null result
    }

    private void setField(JsonPointer jsonPointer, String fieldName, Object value) {
        try {
            Field field = JsonPointer.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(jsonPointer, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}