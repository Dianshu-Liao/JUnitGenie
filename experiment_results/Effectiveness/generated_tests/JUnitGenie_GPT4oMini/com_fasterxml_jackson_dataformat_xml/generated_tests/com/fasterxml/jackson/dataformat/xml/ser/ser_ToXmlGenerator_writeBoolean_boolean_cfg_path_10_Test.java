package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testWriteBoolean() {
        // Arrange
        XMLStreamWriter xmlWriter = Mockito.mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator._nextName = new QName("namespaceURI", "localPart");
        generator._nextIsAttribute = false;

        // Act
        try {
            generator.writeBoolean(true);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBooleanWithMissingName() {
        // Arrange
        XMLStreamWriter xmlWriter = Mockito.mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator._nextName = null; // Simulate missing name

        // Act
        try {
            generator.writeBoolean(true);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Handle the NullPointerException specifically
            System.err.println("NullPointerException: " + e.getMessage());
        }
    }

}