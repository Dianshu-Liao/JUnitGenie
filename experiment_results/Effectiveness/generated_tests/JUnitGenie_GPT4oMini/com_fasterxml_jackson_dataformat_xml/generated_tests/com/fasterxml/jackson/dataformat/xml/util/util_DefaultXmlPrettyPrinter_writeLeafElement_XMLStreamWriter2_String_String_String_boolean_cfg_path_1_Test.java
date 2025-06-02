package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_String_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteLeafElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "exampleText";
        boolean isCData = true;

        // Set the _nesting variable to 0
        try {
            java.lang.reflect.Field nestingField = DefaultXmlPrettyPrinter.class.getDeclaredField("_nesting");
            nestingField.setAccessible(true);
            nestingField.setInt(printer, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the _justHadStartElement variable to false
        try {
            java.lang.reflect.Field justHadStartElementField = DefaultXmlPrettyPrinter.class.getDeclaredField("_justHadStartElement");
            justHadStartElementField.setAccessible(true);
            justHadStartElementField.setBoolean(printer, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeCData(text);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}