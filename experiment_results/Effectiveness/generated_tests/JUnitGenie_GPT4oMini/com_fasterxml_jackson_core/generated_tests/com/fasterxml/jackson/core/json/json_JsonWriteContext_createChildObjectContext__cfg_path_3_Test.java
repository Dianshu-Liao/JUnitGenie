package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class json_JsonWriteContext_createChildObjectContext__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateChildObjectContextWhenChildIsNull() {
        JsonWriteContext context = new JsonWriteContext(0, null, null);
        JsonWriteContext childContext = context.createChildObjectContext();
        assertNotNull("Child context should not be null", childContext);
    }

    @Test(timeout = 4000)
    public void testCreateChildObjectContextWhenChildIsNotNull() {
        JsonWriteContext parentContext = new JsonWriteContext(0, null, null);
        JsonWriteContext childContext = parentContext.createChildObjectContext();
        JsonWriteContext newChildContext = parentContext.createChildObjectContext();
        assertNotNull("New child context should not be null", newChildContext);
    }

    @Test(timeout = 4000)
    public void testCreateChildObjectContextWithDupDetector() {
        // Create a dummy JsonGenerator or JsonParser to pass to rootDetector
        JsonGenerator jsonGenerator = null; // Replace with actual generator if available
        DupDetector dupDetector = DupDetector.rootDetector(jsonGenerator); // Use the public static method to get a DupDetector instance
        JsonWriteContext parentContext = new JsonWriteContext(0, null, dupDetector);
        JsonWriteContext childContext = parentContext.createChildObjectContext();
        assertNotNull("Child context should not be null", childContext);
    }


}