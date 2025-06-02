package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JsonPointer_matches__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMatchesWhenNextSegmentIsNotNull() {
        try {
            // Using reflection to access the protected constructor
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[0].newInstance((Object[]) null);
            // Set _nextSegment to a non-null value using reflection
            java.lang.reflect.Field nextSegmentField = JsonPointer.class.getDeclaredField("_nextSegment");
            nextSegmentField.setAccessible(true);
            nextSegmentField.set(jsonPointer, JsonPointer.compile("some/path"));

            // Assert that matches() returns false when _nextSegment is not null
            assertFalse(jsonPointer.matches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMatchesWhenNextSegmentIsNull() {
        try {
            // Using reflection to access the protected constructor
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[0].newInstance((Object[]) null);
            // Set _nextSegment to null using reflection
            java.lang.reflect.Field nextSegmentField = JsonPointer.class.getDeclaredField("_nextSegment");
            nextSegmentField.setAccessible(true);
            nextSegmentField.set(jsonPointer, null);

            // Assert that matches() returns true when _nextSegment is null
            assertTrue(jsonPointer.matches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}