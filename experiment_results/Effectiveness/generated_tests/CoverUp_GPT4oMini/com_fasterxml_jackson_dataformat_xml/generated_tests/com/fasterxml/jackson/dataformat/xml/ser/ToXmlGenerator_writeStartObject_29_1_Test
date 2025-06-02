package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

class ToXmlGenerator_writeStartObject_29_1_Test {

    private ToXmlGenerator generator;

    private XMLStreamWriter2 mockXmlWriter;

    private XMLStreamWriter mockOriginalXmlWriter;

    private IOContext mockIOContext;

    private XmlNameProcessor mockNameProcessor;

    private XmlPrettyPrinter mockPrettyPrinter;

    @BeforeEach
    void setUp() throws Exception {
        mockXmlWriter = mock(XMLStreamWriter2.class);
        mockOriginalXmlWriter = mock(XMLStreamWriter.class);
        mockIOContext = mock(IOContext.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        mockPrettyPrinter = mock(XmlPrettyPrinter.class);
        // Set up the mock IOContext to return a mock StreamWriteConstraints
        StreamWriteConstraints mockConstraints = mock(StreamWriteConstraints.class);
        when(mockIOContext.streamWriteConstraints()).thenReturn(mockConstraints);
        generator = new ToXmlGenerator(mockIOContext, 0, 0, (ObjectCodec) null, mockOriginalXmlWriter, mockNameProcessor);
        generator.setNextName(new QName("http://example.com", "example"));
    }

    @Test
    void testWriteStartObjectWithoutPrettyPrinter() throws Exception {
        // Arrange
        generator.setPrettyPrinter(null);
        // Act
        generator.writeStartObject();
        // Assert
        verify(mockXmlWriter).writeStartElement("http://example.com", "example");
    }

    @Test
    void testWriteStartObjectWithPrettyPrinter() throws Exception {
        // Arrange
        generator.setPrettyPrinter(mockPrettyPrinter);
        // Act
        generator.writeStartObject();
        // Assert
        verify(mockPrettyPrinter).writeStartObject(generator);
    }

    @Test
    void testWriteStartObjectHandlesMissingName() throws Exception {
        // Arrange
        generator.setNextName(null);
        // Act & Assert
        assertThrows(XMLStreamException.class, () -> {
            generator.writeStartObject();
        });
    }

    @Test
    void testWriteStartObjectThrowsIOException() throws Exception {
        // Arrange
        doThrow(new IOException("Test Exception")).when(mockXmlWriter).writeStartElement(anyString(), anyString());
        generator.setNextName(new QName("http://example.com", "example"));
        // Act & Assert
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeStartObject();
        });
        assertEquals("Test Exception", exception.getMessage());
    }
}
