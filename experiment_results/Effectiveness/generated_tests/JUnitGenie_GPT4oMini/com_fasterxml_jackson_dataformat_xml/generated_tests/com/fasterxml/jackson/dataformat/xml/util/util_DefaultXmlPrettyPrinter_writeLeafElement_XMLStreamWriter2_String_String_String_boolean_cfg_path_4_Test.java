package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_String_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteLeafElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "exampleText";
        boolean isCData = false;

        try {
            // Act
            printer.writeLeafElement(mockWriter, nsURI, localName, text, isCData);

            // Assert
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCharacters(text);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the exception
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
        String text = "exampleText";
        boolean isCData = true;

        try {
            // Act
            printer.writeLeafElement(mockWriter, nsURI, localName, text, isCData);

            // Assert
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCData(text);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}