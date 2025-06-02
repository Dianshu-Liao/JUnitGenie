package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testWriteBoolean() {
        // Arrange
        XMLStreamWriter xmlWriter = Mockito.mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(
            Mockito.mock(com.fasterxml.jackson.core.io.IOContext.class),
            0,
            0,
            null,
            xmlWriter,
            null
        );

        // Set up the protected fields
        QName nextName = new QName("namespaceURI", "localPart");
        generator._nextName = nextName;
        generator._nextIsAttribute = false;

        boolean valueToWrite = true;

        // Act
        try {
            generator.writeBoolean(valueToWrite);
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
        
        // Assert
        try {
            // Verify that the correct methods were called on the xmlWriter
            Mockito.verify(xmlWriter).writeStartElement("namespaceURI", "localPart");
            // Corrected the method call to writeCharacters instead of writeBoolean
            Mockito.verify(xmlWriter).writeCharacters(String.valueOf(valueToWrite));
            Mockito.verify(xmlWriter).writeEndElement();
        } catch (XMLStreamException e) {
            // Handle the XMLStreamException if it occurs
            e.printStackTrace();
        }
    }

}