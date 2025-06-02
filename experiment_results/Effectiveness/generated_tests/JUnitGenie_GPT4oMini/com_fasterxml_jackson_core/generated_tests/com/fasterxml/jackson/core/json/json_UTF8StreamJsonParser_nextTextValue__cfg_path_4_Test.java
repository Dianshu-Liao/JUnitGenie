package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8StreamJsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8StreamJsonParser_nextTextValue__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testNextTextValue() {
        // Setup the necessary context and input stream
        String jsonInput = "{\"key\":\"value\"}";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonInput.getBytes());
        
        // Correctly initialize IOContext with a valid ObjectCodec
        ObjectCodec codec = null; // Assuming no codec is needed for this test
        IOContext ioContext = new IOContext(null, codec, false);
        
        ByteQuadsCanonicalizer canonicalizer = ByteQuadsCanonicalizer.createRoot();
        UTF8StreamJsonParser parser = new UTF8StreamJsonParser(ioContext, 0, inputStream, codec, canonicalizer, null, 0, 0, false);

        try {
            // Call the method under test
            parser.nextToken(); // Advance to the first token (FIELD_NAME)
            String result = parser.nextTextValue(); // Call the method to get the text value

            // Validate the result
            assertEquals("value", result); // Expecting the value from the JSON input

        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure the parser is closed to free resources
            } catch (IOException e) {
                e.printStackTrace(); // Handle potential IOException from close
            }
        }
    }

}