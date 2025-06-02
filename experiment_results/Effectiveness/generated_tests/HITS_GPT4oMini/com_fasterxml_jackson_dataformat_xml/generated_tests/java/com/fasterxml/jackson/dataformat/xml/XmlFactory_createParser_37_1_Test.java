package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLInputFactory2;
import org.codehaus.stax2.io.Stax2ByteArraySource;
import org.codehaus.stax2.io.Stax2CharArraySource;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactory_createParser_37_1_Test {

    private XmlFactory xmlFactory;

    private XMLStreamReader xmlStreamReader;

    @BeforeEach
    public void setUp() throws Exception {
        xmlFactory = new XmlFactory();
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        xmlStreamReader = inputFactory.createXMLStreamReader(new java.io.StringReader("<root></root>"));
    }

    @Test
    public void testCreateParserWithStartElement() throws Exception {
        // Arrange
        // Move to START_ELEMENT
        xmlStreamReader.nextTag();
        // Act
        FromXmlParser parser = xmlFactory.createParser(xmlStreamReader);
        // Assert
        assertNotNull(parser);
    }

    @Test
    public void testCreateParserWithNonStartElement() throws Exception {
        // Arrange
        // Move to a non-START_ELEMENT (e.g., END_DOCUMENT)
        xmlStreamReader.next();
        // Act
        FromXmlParser parser = xmlFactory.createParser(xmlStreamReader);
        // Assert
        assertNotNull(parser);
    }

    @Test
    public void testCreateParserWithInvalidXML() {
        // Arrange
        // Invalid XML
        String invalidXml = "<root><child></root>";
        XMLStreamReader invalidReader = null;
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            invalidReader = inputFactory.createXMLStreamReader(new java.io.StringReader(invalidXml));
            // Move to START_ELEMENT
            invalidReader.nextTag();
        } catch (XMLStreamException e) {
            fail("Failed to create XMLStreamReader for invalid XML");
        }
        // Act & Assert
        // Declare final reference
        final XMLStreamReader finalInvalidReader = invalidReader;
        assertThrows(JsonParseException.class, () -> {
            xmlFactory.createParser(finalInvalidReader);
        });
    }

    @Test
    public void testCreateParserWithTextElementName() throws Exception {
        // Arrange
        // Move to START_ELEMENT
        xmlStreamReader.nextTag();
        xmlFactory.setXMLTextElementName("textElement");
        // Act
        FromXmlParser parser = xmlFactory.createParser(xmlStreamReader);
        // Assert
        assertNotNull(parser);
        assertEquals("textElement", parser.getParsingContext().getCurrentName());
    }
}
