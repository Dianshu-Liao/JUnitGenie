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

public class json_ReaderBasedJsonParser_nextBooleanValue__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsTrue() {
        // Setup
        String json = "{\"key\": true}";
        ReaderBasedJsonParser parser = createParser(json);
        
        try {
            // Act
            Boolean result = parser.nextBooleanValue();
            
            // Assert
            assertEquals(Boolean.TRUE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure parser is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception during close
            }
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsFalse() {
        // Setup
        String json = "{\"key\": false}";
        ReaderBasedJsonParser parser = createParser(json);
        
        try {
            // Act
            Boolean result = parser.nextBooleanValue();
            
            // Assert
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure parser is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception during close
            }
        }
    }

    @Test(timeout = 4000)
    public void testNextBooleanValueReturnsNull() {
        // Setup
        String json = "{\"key\": null}";
        ReaderBasedJsonParser parser = createParser(json);
        
        try {
            // Act
            Boolean result = parser.nextBooleanValue();
            
            // Assert
            assertEquals(null, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        } finally {
            try {
                parser.close(); // Ensure parser is closed
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception during close
            }
        }
    }

    private ReaderBasedJsonParser createParser(String json) {
        IOContext ioContext = new IOContext(null, null, false);
        StringReader reader = new StringReader(json);
        return new ReaderBasedJsonParser(ioContext, 0, reader, null, CharsToNameCanonicalizer.createRoot());
    }

}