package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import java.lang.reflect.Method;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_18_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementTrue() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        boolean value = true;
        // Act
        invokeWriteLeafElement(nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBoolean(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementFalse() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        boolean value = false;
        // Act
        invokeWriteLeafElement(nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBoolean(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void invokeWriteLeafElement(String nsURI, String localName, boolean value) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, boolean.class);
        method.setAccessible(true);
        method.invoke(prettyPrinter, xmlStreamWriter, nsURI, localName, value);
    }
}
