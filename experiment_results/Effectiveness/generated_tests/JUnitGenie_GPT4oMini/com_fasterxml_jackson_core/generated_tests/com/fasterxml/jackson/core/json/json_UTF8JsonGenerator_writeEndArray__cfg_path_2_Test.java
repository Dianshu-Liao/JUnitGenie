package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeEndArray__cfg_path_2_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteEndArrayWhenInArray() throws IOException {
        // Set up the context to be in an array
        generator.writeStartArray(); // Start an array context

        // Call the method under test
        generator.writeEndArray();

        // Verify the output
        assertEquals(93, outputStream.toByteArray()[outputStream.size() - 1]); // Check if the last byte is ']'
    }

}
