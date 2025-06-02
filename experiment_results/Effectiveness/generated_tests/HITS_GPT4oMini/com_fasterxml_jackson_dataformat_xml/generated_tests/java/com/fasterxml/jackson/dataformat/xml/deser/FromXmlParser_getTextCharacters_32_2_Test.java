package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getTextCharacters_32_2_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamReader = Mockito.mock(XMLStreamReader.class);
        objectCodec = Mockito.mock(ObjectCodec.class);
        BufferRecycler bufferRecycler = Mockito.mock(BufferRecycler.class);
        IOContext ioContext = new IOContext(bufferRecycler, null, false);
        parser = Mockito.spy(new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, new XmlNameProcessor() {

            @Override
            public void decodeName(XmlName name) {
                // No-op for this test
            }

            @Override
            public void encodeName(XmlName name) {
                // No-op for this test
            }
        }));
    }

    @Test
    public void testGetTextCharacters_WhenTextIsNull() throws IOException {
        // Arrange
        when(parser.getText()).thenReturn(null);
        // Act
        char[] result = parser.getTextCharacters();
        // Assert
        assertNull(result);
    }

    @Test
    public void testGetTextCharacters_WhenTextIsEmpty() throws IOException {
        // Arrange
        when(parser.getText()).thenReturn("");
        // Act
        char[] result = parser.getTextCharacters();
        // Assert
        assertArrayEquals(new char[] {}, result);
    }

    @Test
    public void testGetTextCharacters_WhenTextIsNotEmpty() throws IOException {
        // Arrange
        String text = "Hello, World!";
        when(parser.getText()).thenReturn(text);
        // Act
        char[] result = parser.getTextCharacters();
        // Assert
        assertArrayEquals(text.toCharArray(), result);
    }

    @Test
    public void testGetTextCharacters_WhenGetTextThrowsIOException() throws IOException {
        // Arrange
        when(parser.getText()).thenThrow(new IOException("Test Exception"));
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> {
            parser.getTextCharacters();
        });
        assertEquals("Test Exception", exception.getMessage());
    }
}
