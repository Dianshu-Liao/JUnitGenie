package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import static org.mockito.Mockito.*;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeEndElement_XMLStreamWriter2_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteEndElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = mock(XMLStreamWriter2.class);
        
        // Set the state of the printer to test the specific path
        // Assuming _justHadStartElement is initially false
        // and _nesting is initially 0
        // We can use reflection to set the protected fields if necessary
        try {
            java.lang.reflect.Field justHadStartElementField = DefaultXmlPrettyPrinter.class.getDeclaredField("_justHadStartElement");
            justHadStartElementField.setAccessible(true);
            justHadStartElementField.set(printer, false);
            
            java.lang.reflect.Field nestingField = DefaultXmlPrettyPrinter.class.getDeclaredField("_nesting");
            nestingField.setAccessible(true);
            nestingField.set(printer, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Act
        try {
            printer.writeEndElement(mockWriter, 0);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        // Assert
        // Verify that writeIndentation and writeEndElement were called
        try {
            verify(mockWriter, times(1)).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}