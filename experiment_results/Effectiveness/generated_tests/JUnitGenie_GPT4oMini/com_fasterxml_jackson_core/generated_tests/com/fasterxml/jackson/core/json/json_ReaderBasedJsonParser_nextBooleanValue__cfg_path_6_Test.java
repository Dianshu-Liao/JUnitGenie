package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_ReaderBasedJsonParser_nextBooleanValue__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsFalse() {
        // Setup
        String json = "{\"fieldName\": false}";
        ReaderBasedJsonParser parser = createParser(json);
        try {
            parser.nextToken(); // Move to the FIELD_NAME token

            // Execute
            Boolean result = parser.nextBooleanValue();
            // Verify
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            if (parser != null) {
                try {
                    parser.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsTrue() {
        // Setup
        String json = "{\"fieldName\": true}";
        ReaderBasedJsonParser parser = createParser(json);
        try {
            parser.nextToken(); // Move to the FIELD_NAME token

            // Execute
            Boolean result = parser.nextBooleanValue();
            // Verify
            assertEquals(Boolean.TRUE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            if (parser != null) {
                try {
                    parser.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ReaderBasedJsonParser createParser(String json) {
        try {
            IOContext ioContext = new IOContext(null, null, false);
            return new ReaderBasedJsonParser(ioContext, 0, new StringReader(json), null, CharsToNameCanonicalizer.createRoot(), null, 0, 0, false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}