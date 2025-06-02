package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class JsonPointer_matchProperty_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMatchProperty_NextSegmentIsNull() {
        // Arrange
        JsonPointer jsonPointer = new JsonPointer(null, 0, null, 0, null); // Using reflection to instantiate
        String propertyName = "testProperty";

        // Act
        JsonPointer result = jsonPointer.matchProperty(propertyName);

        // Assert
        assertNull(result);
    }

}