package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.ReaderBasedJsonParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_ReaderBasedJsonParser_nextBooleanValue__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsFalse() {
        // Setup
        String json = "{\"key\": false}";
        Reader reader = new StringReader(json);
        IOContext ioContext = new IOContext(null, null, false);
        CharsToNameCanonicalizer charsToNameCanonicalizer = CharsToNameCanonicalizer.createRoot();
        ObjectCodec objectCodec = null; // Initialize ObjectCodec to null
        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, 0, reader, objectCodec, charsToNameCanonicalizer);

        try {
            // Simulate the state of the parser to ensure the current token is FIELD_NAME
            parser.nextToken(); // Move to the first token (which should be FIELD_NAME)
            parser.nextToken(); // Move to the next token (which should be VALUE_FALSE)

            // Execute
            Boolean result = parser.nextBooleanValue();

            // Verify
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}