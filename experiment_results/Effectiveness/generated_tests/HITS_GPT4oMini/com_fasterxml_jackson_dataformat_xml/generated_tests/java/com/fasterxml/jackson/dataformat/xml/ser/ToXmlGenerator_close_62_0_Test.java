package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class ToXmlGenerator_close_62_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter mockXmlWriter;

    private IOContext mockIOContext;

    private XmlNameProcessor mockNameProcessor;

    @BeforeEach
    public void setUp() throws Exception {
        mockXmlWriter = mock(XMLStreamWriter.class);
        mockIOContext = mock(IOContext.class);
        mockNameProcessor = mock(XmlNameProcessor.class);
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        when(mockIOContext.streamWriteConstraints()).thenReturn(null);
        toXmlGenerator = new ToXmlGenerator(mockIOContext, 0, 0, null, mockXmlWriter, mockNameProcessor);
    }

    @Test
    public void testClose_whenNotClosed_shouldCloseXmlWriter() throws IOException, XMLStreamException {
        // Arrange
        when(mockXmlWriter.getNamespaceContext()).thenReturn(mock(javax.xml.namespace.NamespaceContext.class));
        // Act
        toXmlGenerator.close();
        // Assert
        verify(mockXmlWriter).close();
    }

    @Test
    public void testClose_whenResourceManaged_shouldCloseCompletely() throws IOException, XMLStreamException {
        // Arrange
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        // Act
        toXmlGenerator.close();
        // Assert
        verify(mockXmlWriter).close();
    }

    @Test
    public void testClose_whenInArray_shouldWriteEndArray() throws IOException, XMLStreamException {
        // Arrange
        when(mockXmlWriter.getNamespaceContext()).thenReturn(mock(javax.xml.namespace.NamespaceContext.class));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.setNextName(new QName("test"));
        // Simulate being in an array context
        toXmlGenerator.setNextIsUnwrapped(true);
        // Act
        toXmlGenerator.close();
        // Assert
        verify(mockXmlWriter).writeEndElement();
    }

    @Test
    public void testClose_whenInObject_shouldWriteEndObject() throws IOException, XMLStreamException {
        // Arrange
        when(mockXmlWriter.getNamespaceContext()).thenReturn(mock(javax.xml.namespace.NamespaceContext.class));
        toXmlGenerator.setNextIsAttribute(false);
        toXmlGenerator.setNextName(new QName("test"));
        // Simulate being in an object context
        toXmlGenerator.setNextIsUnwrapped(false);
        // Act
        toXmlGenerator.close();
        // Assert
        verify(mockXmlWriter).writeEndElement();
    }
}
