package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import javax.xml.stream.XMLStreamException;
import static org.mockito.Mockito.*;

public class util_DefaultXmlPrettyPrinter_writeEndElement_XMLStreamWriter2_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteEndElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = mock(XMLStreamWriter2.class);
        
        // Set the internal state to ensure _objectIndenter.isInline() returns false
        // This is done by using reflection to access the protected field
        try {
            java.lang.reflect.Field indenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
            indenterField.setAccessible(true);
            Object indenter = mock(Object.class);
            indenterField.set(printer, indenter); // Corrected this line
            when(indenter.getClass().getMethod("isInline").invoke(indenter)).thenReturn(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the internal state for _justHadStartElement
        try {
            java.lang.reflect.Field justHadStartElementField = DefaultXmlPrettyPrinter.class.getDeclaredField("_justHadStartElement");
            justHadStartElementField.setAccessible(true);
            justHadStartElementField.set(printer, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        try {
            printer.writeEndElement(mockWriter, 0);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }


}