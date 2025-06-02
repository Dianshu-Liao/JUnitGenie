package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafXsiNilElement_XMLStreamWriter2_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteLeafXsiNilElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";

        // Act
        try {
            printer.writeLeafXsiNilElement(mockWriter, nsURI, localName);
        } catch (XMLStreamException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockWriter).writeEmptyElement(nsURI, localName);
            Mockito.verify(mockWriter).writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "true");
        } catch (XMLStreamException e) {
            // Handle exception if thrown during verification
            e.printStackTrace();
        }
    }

}