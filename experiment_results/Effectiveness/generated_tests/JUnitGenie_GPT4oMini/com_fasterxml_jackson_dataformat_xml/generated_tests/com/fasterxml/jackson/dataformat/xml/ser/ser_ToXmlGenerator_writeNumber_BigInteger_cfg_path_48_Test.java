package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.namespace.QName;
import org.junit.Test;
import org.mockito.Mockito;
import java.math.BigInteger;
import java.io.IOException;
import javax.xml.stream.XMLStreamException;

public class ser_ToXmlGenerator_writeNumber_BigInteger_cfg_path_48_Test {

    @Test(timeout = 4000)
    public void testWriteNumberWithNullValue() throws IOException {
        // Arrange
        XMLStreamWriter xmlWriter = Mockito.mock(XMLStreamWriter.class);
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator._nextName = null; // Simulating _nextName being null

        // Act
        generator.writeNumber((BigInteger) null); // Explicitly casting to BigInteger

        // Assert
        // Verify that writeNull() is called (assuming writeNull is a method in ToXmlGenerator)
        Mockito.verify(generator).writeNull();
    }

    @Test(timeout = 4000)
    public void testWriteNumberWithValidValue() throws IOException, XMLStreamException {
        // Arrange
        XMLStreamWriter xmlWriter = Mockito.mock(XMLStreamWriter.class);
        QName qName = new QName("namespace", "localPart"); // Simulating a valid QName
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        generator._nextName = qName; // Set the QName
        generator._nextIsAttribute = false; // Simulating that it's not an attribute

        // Act
        generator.writeNumber(BigInteger.valueOf(123));

        // Assert
        Mockito.verify(xmlWriter).writeStartElement("namespace", "localPart");
        Mockito.verify(xmlWriter).writeCharacters(BigInteger.valueOf(123).toString()); // Changed to writeCharacters
        Mockito.verify(xmlWriter).writeEndElement();
    }

}