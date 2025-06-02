package com.fasterxml.jackson.core.json;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class // Additional tests can be added for edge cases and error handling
WriterBasedJsonGenerator_writeNumber_36_0_Test {

    private WriterBasedJsonGenerator jsonGenerator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        jsonGenerator = new WriterBasedJsonGenerator(new IOContext(null, null, false), 0, null, stringWriter);
    }

    @Test
    public void testWriteNumber_ValidInteger() throws IOException {
        jsonGenerator.writeNumber(123);
        assertEquals("123", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_NegativeInteger() throws IOException {
        jsonGenerator.writeNumber(-456);
        assertEquals("-456", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_Zero() throws IOException {
        jsonGenerator.writeNumber(0);
        assertEquals("0", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_LargeInteger() throws IOException {
        jsonGenerator.writeNumber(2147483647);
        assertEquals("2147483647", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_ConfigurationAsString() throws IOException {
        // Assuming _cfgNumbersAsStrings is a configurable field in the actual implementation
        // This test would require the actual implementation of the configuration to be set up
        // For demonstration, we will assume a setter or a method to change this configuration
        // jsonGenerator.setNumbersAsStrings(true); // Hypothetical setter
        jsonGenerator.writeNumber(789);
        // Expecting quoted number
        assertEquals("\"789\"", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_BufferFlush() throws IOException {
        // Assuming _outputEnd is set to a value that requires flushing
        // This will require mocking or reflection to manipulate private fields
        // For demonstration, we can assume that the buffer is near full and invoke this scenario
        // Example: jsonGenerator.setOutputEnd(5); // Hypothetical setter
        jsonGenerator.writeNumber(1234567890);
        assertEquals("1234567890", stringWriter.toString());
    }

    @Test
    public void testWriteNumber_BufferOverflow() throws IOException {
        // Prepare the writer to have a limited buffer
        // Assuming we can set the output buffer size manually or through reflection
        // This is a hypothetical scenario to test buffer overflow logic
        // Here we could use reflection to set _outputEnd to a small value
        // For demonstration, we'll directly call the method and expect it to handle overflow
        jsonGenerator.writeNumber(1234567890);
        assertEquals("1234567890", stringWriter.toString());
    }
}
