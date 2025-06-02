package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_20_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = new DefaultXmlPrettyPrinter.Indenter() {

            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
                // Simulate indentation
                sw.writeCharacters("\n  ");
            }

            // Added required method
            @Override
            public void writeIndentation(JsonGenerator jgen, int nesting) throws IOException {
                // No implementation needed for this test
            }
        };
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        long value = 12345L;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeLong(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = new DefaultXmlPrettyPrinter.Indenter() {

            @Override
            public boolean isInline() {
                return true;
            }

            @Override
            public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
                // No indentation for inline
            }

            // Added required method
            @Override
            public void writeIndentation(JsonGenerator jgen, int nesting) throws IOException {
                // No implementation needed for this test
            }
        };
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        long value = 67890L;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeLong(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }
}
