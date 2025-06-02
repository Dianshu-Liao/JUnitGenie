package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeEndElement_XMLStreamWriter2_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteEndElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        
        // Set up the necessary conditions for the test
        // Assuming _objectIndenter.isInline() returns false
        // and _justHadStartElement is initially false
        try {
            // Act
            printer.writeEndElement(mockWriter, 0);
        } catch (XMLStreamException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }

        // Assert
        // Verify that writeEndElement was called on the mock writer
        try {
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}