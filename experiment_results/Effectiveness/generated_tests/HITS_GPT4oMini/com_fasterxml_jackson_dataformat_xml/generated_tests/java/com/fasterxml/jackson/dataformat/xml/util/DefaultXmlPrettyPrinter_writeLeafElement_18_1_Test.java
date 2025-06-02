package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import java.io.StringWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

class DefaultXmlPrettyPrinter_writeLeafElement_18_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private StringWriter stringWriter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() throws Exception {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        stringWriter = new StringWriter();
        xmlStreamWriter = (XMLStreamWriter2) XMLOutputFactory.newInstance().createXMLStreamWriter(stringWriter);
    }

    @Test
    void testWriteLeafElementTrue() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", "testElement", true);
        xmlStreamWriter.flush();
        String expectedOutput = "<testElement>true</testElement>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }

    @Test
    void testWriteLeafElementFalse() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", "testElement", false);
        xmlStreamWriter.flush();
        String expectedOutput = "<testElement>false</testElement>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }

    @Test
    void testWriteLeafElementWithDifferentNamespaces() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns1", "element1", true);
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns2", "element2", false);
        xmlStreamWriter.flush();
        String expectedOutput = "<element1>true</element1><element2>false</element2>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }

    @Test
    void testWriteLeafElementWithEmptyLocalName() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", "", true);
        xmlStreamWriter.flush();
        // Handling an empty local name
        String expectedOutput = "<true></true>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }

    @Test
    void testWriteLeafElementWithNullNamespace() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, null, "testElement", true);
        xmlStreamWriter.flush();
        String expectedOutput = "<testElement>true</testElement>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }

    @Test
    void testWriteLeafElementWithNullLocalName() throws XMLStreamException {
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", null, true);
        xmlStreamWriter.flush();
        // Handling a null local name
        String expectedOutput = "<null>true</null>";
        assertEquals(expectedOutput, stringWriter.toString().trim());
    }
}
