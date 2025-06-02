package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import static org.junit.Assert.assertEquals;

public class json_ReaderBasedJsonParser_nextBooleanValue__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsTrue() {
        // Setup
        String json = "{\"fieldName\": true}";
        ReaderBasedJsonParser parser = createParser(json);
        try {
            parser.nextToken(); // Move to the first token (FIELD_NAME)
            parser.nextToken(); // Move to the VALUE_TRUE token

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertEquals(Boolean.TRUE, result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure parser is closed to avoid resource leaks
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsFalse() {
        // Setup
        String json = "{\"fieldName\": false}";
        ReaderBasedJsonParser parser = createParser(json);
        try {
            parser.nextToken(); // Move to the first token (FIELD_NAME)
            parser.nextToken(); // Move to the VALUE_FALSE token

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure parser is closed to avoid resource leaks
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ReaderBasedJsonParser createParser(String json) {
        // Mocking IOContext and other dependencies for the parser
        IOContext ioContext = new IOContext(null, null, false); // Create a proper IOContext
        CharsToNameCanonicalizer canonicalizer = CharsToNameCanonicalizer.createRoot();
        return new ReaderBasedJsonParser(ioContext, 0, new StringReader(json), null, canonicalizer);
    }

}