package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringReader;
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

public class DefaultXmlPrettyPrinter_writeLeafXsiNilElement_27_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private StringWriter stringWriter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() throws Exception {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        stringWriter = new StringWriter();
        xmlStreamWriter = (XMLStreamWriter2) XMLOutputFactory.newInstance().createXMLStreamWriter(stringWriter);
    }

    @Test
    public void testWriteLeafXsiNilElement() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        prettyPrinter.writeLeafXsiNilElement(xmlStreamWriter, nsURI, localName);
        xmlStreamWriter.flush();
        String expectedOutput = "<exampleElement xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>";
        String actualOutput = stringWriter.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteLeafXsiNilElementDifferentLocalName() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "anotherElement";
        prettyPrinter.writeLeafXsiNilElement(xmlStreamWriter, nsURI, localName);
        xmlStreamWriter.flush();
        String expectedOutput = "<anotherElement xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>";
        String actualOutput = stringWriter.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWriteLeafXsiNilElementWithDifferentNamespace() throws XMLStreamException {
        String nsURI = "http://different.com/ns";
        String localName = "differentElement";
        prettyPrinter.writeLeafXsiNilElement(xmlStreamWriter, nsURI, localName);
        xmlStreamWriter.flush();
        String expectedOutput = "<differentElement xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>";
        String actualOutput = stringWriter.toString().trim();
        assertEquals(expectedOutput, actualOutput);
    }
}
