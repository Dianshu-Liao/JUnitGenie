package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

class WriterBasedJsonGenerator__writeFieldName_7_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    private IOContext ioContext;

    private SerializableString serializableString;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        ioContext = new IOContext(null, null, null, null, null, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, (ObjectCodec) null, stringWriter, '"');
        serializableString = mock(SerializableString.class);
    }

    @Test
    void testWriteFieldNameWithCommaBeforeTrue() throws Exception {
        when(serializableString.asQuotedChars()).thenReturn("fieldName".toCharArray());
        generator._outputTail = 0;
        // Ensure there's space in the buffer
        generator._outputEnd = 32;
        invokePrivateWriteFieldName(generator, serializableString, true);
        assertEquals(",\"fieldName\"", stringWriter.toString());
    }

    @Test
    void testWriteFieldNameWithCommaBeforeFalse() throws Exception {
        when(serializableString.asQuotedChars()).thenReturn("fieldName".toCharArray());
        generator._outputTail = 0;
        // Ensure there's space in the buffer
        generator._outputEnd = 32;
        invokePrivateWriteFieldName(generator, serializableString, false);
        assertEquals("\"fieldName\"", stringWriter.toString());
    }

    @Test
    void testWriteFieldNameWithBufferFlush() throws Exception {
        when(serializableString.asQuotedChars()).thenReturn("fieldName".toCharArray());
        // Simulate the buffer being near full
        generator._outputTail = 30;
        // Ensure there's space in the buffer
        generator._outputEnd = 32;
        invokePrivateWriteFieldName(generator, serializableString, true);
        assertEquals(",\"fieldName\"", stringWriter.toString());
    }

    @Test
    void testWriteFieldNameWithUnquotedNames() throws Exception {
        // Simulate the configuration for unquoted names
        generator._cfgUnqNames = true;
        when(serializableString.asQuotedChars()).thenReturn("fieldName".toCharArray());
        generator._outputTail = 0;
        // Ensure there's space in the buffer
        generator._outputEnd = 32;
        invokePrivateWriteFieldName(generator, serializableString, false);
        assertEquals("fieldName", stringWriter.toString());
    }

    private void invokePrivateWriteFieldName(WriterBasedJsonGenerator generator, SerializableString name, boolean commaBefore) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldName", SerializableString.class, boolean.class);
        method.setAccessible(true);
        method.invoke(generator, name, commaBefore);
    }
}
