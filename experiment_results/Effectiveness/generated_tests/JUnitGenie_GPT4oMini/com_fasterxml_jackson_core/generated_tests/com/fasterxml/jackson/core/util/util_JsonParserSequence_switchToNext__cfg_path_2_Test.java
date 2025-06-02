package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class util_JsonParserSequence_switchToNext__cfg_path_2_Test {

    private JsonParserSequence jsonParserSequence;
    private Method switchToNextMethod;

    @Before
    public void setUp() throws Exception {
        // Create a JsonParserSequence with a single null parser to avoid ArrayIndexOutOfBoundsException
        JsonParser[] parsers = new JsonParser[1]; // Create an array with one element
        parsers[0] = null; // Set the first element to null to simulate an empty parser
        jsonParserSequence = (JsonParserSequence) JsonParserSequence.class.getDeclaredConstructor(JsonParser[].class).newInstance((Object) parsers);
        switchToNextMethod = JsonParserSequence.class.getDeclaredMethod("switchToNext");
        switchToNextMethod.setAccessible(true);
    }

    @Test(timeout = 4000)
    public void testSwitchToNextWhenNoParsers() throws Exception {
        // The _nextParserIndex should be 0 and _parsers length is 1 (with a null parser), so the method should return false
        boolean result = (Boolean) switchToNextMethod.invoke(jsonParserSequence);
        assertFalse(result);
    }


}