package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
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
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getTextLength_33_0_Test {

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws Exception {
        // Mock the XMLStreamReader and required IOContext dependencies
        XMLStreamReader xmlReader = Mockito.mock(XMLStreamReader.class);
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(bufferRecycler, null, false);
        // Create a new FromXmlParser instance with mocked dependencies
        parser = new FromXmlParser(ioContext, 0, 0, null, xmlReader, null);
    }

    @Test
    public void testGetTextLength_NullText() throws IOException {
        // Arrange
        Mockito.when(parser.getText()).thenReturn(null);
        // Act
        int length = parser.getTextLength();
        // Assert
        assertEquals(0, length);
    }

    @Test
    public void testGetTextLength_EmptyText() throws IOException {
        // Arrange
        Mockito.when(parser.getText()).thenReturn("");
        // Act
        int length = parser.getTextLength();
        // Assert
        assertEquals(0, length);
    }

    @Test
    public void testGetTextLength_ValidText() throws IOException {
        // Arrange
        String validText = "Hello, World!";
        Mockito.when(parser.getText()).thenReturn(validText);
        // Act
        int length = parser.getTextLength();
        // Assert
        assertEquals(validText.length(), length);
    }

    @Test
    public void testGetTextLength_WhitespaceText() throws IOException {
        // Arrange
        String whitespaceText = "   ";
        Mockito.when(parser.getText()).thenReturn(whitespaceText);
        // Act
        int length = parser.getTextLength();
        // Assert
        assertEquals(whitespaceText.length(), length);
    }

    @Test
    public void testGetTextLength_ExceptionHandling() throws IOException {
        // Arrange
        Mockito.when(parser.getText()).thenThrow(new IOException("Test Exception"));
        // Act & Assert
        assertThrows(IOException.class, () -> {
            parser.getTextLength();
        });
    }
}
