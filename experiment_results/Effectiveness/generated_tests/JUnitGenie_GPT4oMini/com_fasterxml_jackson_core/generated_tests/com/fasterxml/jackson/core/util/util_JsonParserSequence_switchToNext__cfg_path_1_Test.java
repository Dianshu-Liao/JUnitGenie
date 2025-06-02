package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class util_JsonParserSequence_switchToNext__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSwitchToNext() {
        try {
            // Create an array of JsonParser
            JsonParser[] parsers = new JsonParser[2]; // Example with 2 parsers
            // Initialize the JsonParser array (mock or real instances can be used)

            // Use reflection to access the constructor
            Constructor<JsonParserSequence> constructor = JsonParserSequence.class.getDeclaredConstructor(JsonParser[].class);
            constructor.setAccessible(true);
            JsonParserSequence jsonParserSequence = constructor.newInstance((Object) parsers);

            // Access the protected field _nextParserIndex using reflection
            Method getNextParserIndex = JsonParserSequence.class.getDeclaredMethod("_nextParserIndex");
            getNextParserIndex.setAccessible(true);
            int initialIndex = (int) getNextParserIndex.invoke(jsonParserSequence);

            // Call the switchToNext method
            Method switchToNextMethod = JsonParserSequence.class.getDeclaredMethod("switchToNext");
            switchToNextMethod.setAccessible(true);
            boolean result = (boolean) switchToNextMethod.invoke(jsonParserSequence);

            // Assert that the method returns true and the index has incremented
            assertTrue(result);
            assertTrue(initialIndex + 1 == (int) getNextParserIndex.invoke(jsonParserSequence));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}