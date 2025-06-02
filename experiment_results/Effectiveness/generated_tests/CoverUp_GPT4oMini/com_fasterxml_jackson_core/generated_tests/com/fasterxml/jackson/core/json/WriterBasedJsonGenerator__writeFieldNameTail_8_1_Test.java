package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import java.lang.reflect.Method;
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
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator__writeFieldNameTail_8_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter, '"');
    }

    @Test
    public void testWriteFieldNameTail() throws Exception {
        SerializableString mockString = Mockito.mock(SerializableString.class);
        char[] quotedChars = "\"fieldName\"".toCharArray();
        Mockito.when(mockString.asQuotedChars()).thenReturn(quotedChars);
        // Accessing the private method using reflection
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldNameTail", SerializableString.class);
        method.setAccessible(true);
        // Invoking the method
        method.invoke(generator, mockString);
        // Verifying the output
        // Expecting the quote char to be added at the end
        String expectedOutput = "\"fieldName\"\"";
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @Test
    public void testWriteFieldNameTailFlushBuffer() throws Exception {
        // Setting a small buffer
        generator._outputBuffer = new char[10];
        // Fill the buffer close to full
        generator._outputTail = 9;
        SerializableString mockString = Mockito.mock(SerializableString.class);
        char[] quotedChars = "\"longFieldName\"".toCharArray();
        Mockito.when(mockString.asQuotedChars()).thenReturn(quotedChars);
        // Accessing the private method using reflection
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldNameTail", SerializableString.class);
        method.setAccessible(true);
        // Invoking the method
        method.invoke(generator, mockString);
        // Verifying the output
        // Expecting the quote char to be added at the end
        String expectedOutput = "\"longFieldName\"\"";
        assertEquals(expectedOutput, stringWriter.toString());
    }
}
