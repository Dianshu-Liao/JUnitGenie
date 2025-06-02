package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

class WriterBasedJsonGenerator__writeFieldName_6_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, writer, true);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer, '"');
    }

    @Test
    void testWriteFieldNameWithCommaBefore() throws IOException {
        generator._writeFieldName("fieldName", true);
        assertEquals(",\"fieldName\"", writer.toString());
    }

    @Test
    void testWriteFieldNameWithoutCommaBefore() throws IOException {
        generator._writeFieldName("fieldName", false);
        assertEquals("\"fieldName\"", writer.toString());
    }

    @Test
    void testWriteFieldNameWithUnquotedNames() throws IOException {
        generator._cfgUnqNames = true;
        generator._writeFieldName("fieldName", true);
        assertEquals(",fieldName", writer.toString());
    }

    @Test
    void testWriteFieldNameWithLongString() throws IOException {
        // Create a long string manually
        StringBuilder longFieldNameBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            longFieldNameBuilder.append("a");
        }
        String longFieldName = longFieldNameBuilder.toString();
        generator._writeFieldName(longFieldName, false);
        assertEquals("\"" + longFieldName + "\"", writer.toString());
    }
}
