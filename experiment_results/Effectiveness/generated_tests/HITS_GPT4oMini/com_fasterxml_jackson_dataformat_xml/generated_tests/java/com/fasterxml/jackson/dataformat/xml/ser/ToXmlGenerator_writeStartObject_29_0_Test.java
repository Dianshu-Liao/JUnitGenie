package com.fasterxml.jackson.dataformat.xml.ser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLStreamException;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.ri.Stax2WriterAdapter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class ToXmlGenerator_writeStartObject_29_0_Test {

    private ToXmlGenerator toXmlGenerator;

    private XMLStreamWriter xmlStreamWriter;

    private XmlPrettyPrinter prettyPrinter;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamWriter = mock(XMLStreamWriter.class);
        toXmlGenerator = new ToXmlGenerator(Mockito.mock(IOContext.class), 0, 0, null, xmlStreamWriter, null);
        // Mocking the XmlPrettyPrinter
        prettyPrinter = mock(XmlPrettyPrinter.class);
    }

    @Test
    public void testWriteStartObject_ValidCall() throws Exception {
        // Arrange
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        // Act
        toXmlGenerator.writeStartObject();
        // Assert
        verify(xmlStreamWriter, times(1)).writeStartElement("namespace", "localPart");
    }

    @Test
    public void testWriteStartObject_NullName() throws Exception {
        // Arrange
        toXmlGenerator.setNextName(null);
        // Act & Assert
        try {
            toXmlGenerator.writeStartObject();
        } catch (IOException e) {
            // Expecting an IOException due to missing name
            assertTrue(e.getMessage().contains("expecting field name"));
        }
    }

    @Test
    public void testWriteStartObject_EmptyName() throws Exception {
        // Arrange
        QName name = new QName("", "");
        toXmlGenerator.setNextName(name);
        // Act
        toXmlGenerator.writeStartObject();
        // Assert
        verify(xmlStreamWriter, times(1)).writeStartElement("", "");
    }

    @Test
    public void testWriteStartObject_ThrowsXMLStreamException() throws Exception {
        // Arrange
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        doThrow(new XMLStreamException("XML Error")).when(xmlStreamWriter).writeStartElement(anyString(), anyString());
        // Act & Assert
        try {
            toXmlGenerator.writeStartObject();
        } catch (IOException e) {
            assertTrue(e.getCause() instanceof XMLStreamException);
            assertEquals("XML Error", e.getCause().getMessage());
        }
    }

    @Test
    public void testWriteStartObject_WithPrettyPrinter() throws Exception {
        // Arrange
        QName name = new QName("namespace", "localPart");
        toXmlGenerator.setNextName(name);
        // Using the mocked PrettyPrinter
        toXmlGenerator.setPrettyPrinter(prettyPrinter);
        // Act
        toXmlGenerator.writeStartObject();
        // Assert
        verify(prettyPrinter, times(1)).writeStartObject(toXmlGenerator);
        verify(xmlStreamWriter, times(0)).writeStartElement("namespace", "localPart");
    }
}
