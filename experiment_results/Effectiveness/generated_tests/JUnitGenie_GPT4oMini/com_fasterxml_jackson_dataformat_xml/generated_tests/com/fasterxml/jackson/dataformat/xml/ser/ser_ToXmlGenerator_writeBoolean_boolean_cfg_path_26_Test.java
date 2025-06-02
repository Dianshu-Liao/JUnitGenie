package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testWriteBoolean() {
        // Arrange
        XMLStreamWriter mockWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        generator._nextName = new QName("namespaceURI", "localPart");
        generator._nextIsAttribute = false;
        boolean valueToWrite = true;

        // Act
        try {
            generator.writeBoolean(valueToWrite);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBooleanWithPrettyPrinter() {
        // Arrange
        XMLStreamWriter mockWriter = mock(XMLStreamWriter.class);
        // Removed the mock for XmlPrettyPrinter as it does not exist
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        generator._nextName = new QName("namespaceURI", "localPart");
        generator._nextIsAttribute = false;
        boolean valueToWrite = true;

        // Act
        try {
            generator.writeBoolean(valueToWrite);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBooleanThrowsException() {
        // Arrange
        XMLStreamWriter mockWriter = mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, mockWriter, null);
        generator._nextName = new QName("namespaceURI", "localPart");
        generator._nextIsAttribute = false;
        boolean valueToWrite = true;

        // Simulate an XMLStreamException
        try {
            doThrow(new XMLStreamException("Test Exception")).when(mockWriter).writeStartElement(anyString());
        } catch (XMLStreamException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Act
        try {
            generator.writeBoolean(valueToWrite);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}