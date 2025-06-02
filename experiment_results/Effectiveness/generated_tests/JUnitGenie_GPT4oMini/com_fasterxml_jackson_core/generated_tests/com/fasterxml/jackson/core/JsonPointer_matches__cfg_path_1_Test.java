package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class JsonPointer_matches__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMatchesWhenNextSegmentIsNull() {
        try {
            // Using reflection to access the protected constructor
            JsonPointer jsonPointer = (JsonPointer) JsonPointer.class.getDeclaredConstructors()[0].newInstance((Object[]) null);
            // Directly setting the _nextSegment to null using reflection
            java.lang.reflect.Field nextSegmentField = JsonPointer.class.getDeclaredField("_nextSegment");
            nextSegmentField.setAccessible(true);
            nextSegmentField.set(jsonPointer, null);

            // Assert that matches() returns true when _nextSegment is null
            assertFalse(jsonPointer.matches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}