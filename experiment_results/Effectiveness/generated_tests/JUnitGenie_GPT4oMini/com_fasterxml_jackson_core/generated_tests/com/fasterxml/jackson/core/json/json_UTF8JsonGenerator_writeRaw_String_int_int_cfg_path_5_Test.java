package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_UTF8JsonGenerator_writeRaw_String_int_int_cfg_path_5_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        // Initialize the output stream and the generator
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        generator._outputTail = 0; // Ensure _outputTail is initialized to 0
        generator._charBuffer = new char[10]; // Initialize _charBuffer
    }

    @Test(timeout = 4000)
    public void testWriteRawWithValidParameters() {
        String text = "Hello";
        int offset = 0;
        int len = 5;

        try {
            generator.writeRaw(text, offset, len);
            String result = outputStream.toString("UTF-8");
            assertEquals("Hello", result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteRawWithSurrogateCharacter() {
        String text = "Hello\uD83D\uDE00"; // Contains a surrogate character
        int offset = 0;
        int len = 6; // Length includes the surrogate

        try {
            generator.writeRaw(text, offset, len);
            String result = outputStream.toString("UTF-8");
            assertEquals("Hello", result); // Surrogate should be dropped
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteRawWithBufferFlush() {
        String text = "HelloWorld";
        int offset = 0;
        int len = 10; // Length exceeds the buffer size

        try {
            generator.writeRaw(text, offset, len);
            String result = outputStream.toString("UTF-8");
            assertEquals("HelloWorld", result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteRawWithInvalidOffset() {
        String text = "Hello";
        int offset = -1; // Invalid offset
        int len = 5;

        try {
            generator.writeRaw(text, offset, len);
        } catch (IOException e) {
            // Expected exception due to invalid offset
            assertEquals("Index out of bounds", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteRawWithZeroLength() {
        String text = "Hello";
        int offset = 0;
        int len = 0; // Zero length

        try {
            generator.writeRaw(text, offset, len);
            String result = outputStream.toString("UTF-8");
            assertEquals("", result); // No output expected
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}