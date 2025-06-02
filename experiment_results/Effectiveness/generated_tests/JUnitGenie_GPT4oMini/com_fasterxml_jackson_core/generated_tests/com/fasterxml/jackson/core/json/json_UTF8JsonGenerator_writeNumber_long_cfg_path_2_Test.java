package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeNumber_long_cfg_path_2_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        // Initialize the output stream and the generator
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, (ObjectCodec) null, outputStream);
        // Set the protected fields directly for testing purposes
        generator._outputTail = 0; // Ensure _outputTail is <= 0
        generator._outputBuffer = new byte[1024]; // Initialize _outputBuffer
        // Remove the line that attempts to set _outputEnd since it's final
        // generator._outputEnd = 1024; // This line is removed
    }

    @Test(timeout = 4000)
    public void testWriteNumber() {
        long numberToWrite = 123456789L;

        try {
            generator.writeNumber(numberToWrite);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Verify the output
        String expectedOutput = "123456789"; // Expected output as a string
        String actualOutput = outputStream.toString(); // Get the actual output as a string
        assertEquals(expectedOutput, actualOutput);
    }

}