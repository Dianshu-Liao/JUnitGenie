package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_char_____int_int_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteLeafElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "exampleContent".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;

        // Act
        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        } catch (XMLStreamException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCharacters(buffer, offset, len);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteLeafElementWithCData() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "exampleContent".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;

        // Act
        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        } catch (XMLStreamException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCData(buffer, offset, len);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}