package com.fasterxml.jackson.dataformat.xml.util;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Test;
import org.mockito.Mockito;
import javax.xml.stream.XMLStreamException;

public class util_DefaultXmlPrettyPrinter_writeLeafElement_XMLStreamWriter2_String_String_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteLeafElement() {
        // Arrange
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        XMLStreamWriter2 mockWriter = Mockito.mock(XMLStreamWriter2.class);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        boolean value = true;

        // Mock the behavior of _objectIndenter.isInline() to return false
        try {
            // Using reflection to access the protected field _objectIndenter
            java.lang.reflect.Field field = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
            field.setAccessible(true);
            Object indenter = field.get(printer);
            java.lang.reflect.Method method = indenter.getClass().getDeclaredMethod("isInline");
            method.setAccessible(true);
            // Create a mock for the indenter to return false for isInline()
            Object mockIndenter = Mockito.mock(indenter.getClass());
            Mockito.when(mockIndenter.getClass().getDeclaredMethod("isInline").invoke(mockIndenter)).thenReturn(false);
            field.set(printer, mockIndenter); // Set the mock indenter back to the printer
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        try {
            printer.writeLeafElement(mockWriter, nsURI, localName, value);
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(mockWriter).writeStartElement(nsURI, localName);
            Mockito.verify(mockWriter).writeBoolean(value);
            Mockito.verify(mockWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}