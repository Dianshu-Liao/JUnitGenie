package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import javax.xml.stream.XMLStreamWriter;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_14_Test {
    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        // Providing a valid XMLStreamWriter to avoid NullPointerException
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null);
        // Setting the necessary internal states to ensure the path coverage
        toXmlGenerator._nextName = null; // _nextName is null to trigger handleMissingName
        toXmlGenerator._nextIsAttribute = false; // Ensures checkNextIsUnwrapped() returns false
    }

    @Test(timeout = 4000)
    public void testWriteBoolean_withNullNextName() {
        // Arrange
        boolean value = true;

        // Act
        try {
            toXmlGenerator.writeBoolean(value);
        } catch (IOException e) {
            // Assert
            // Exception might be thrown due to handleMissingName or internal XMLStreamException.
            assertNotNull(e);
        }
    }

    @Test(timeout = 4000)
    public void testWriteBoolean_withValidNextName() {
        // Arrange
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        
        // Act
        try {
            toXmlGenerator.writeBoolean(true);
        } catch (IOException e) {
            fail("IOException should not have been thrown. " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteBoolean_throwsXMLStreamException() {
        // Arrange
        toXmlGenerator._nextName = new QName("namespaceURI", "localPart");
        try {
            doThrow(new XMLStreamException("Error writing boolean")).when(xmlWriter).writeBoolean(anyBoolean());

            // Act
            toXmlGenerator.writeBoolean(true);
            fail("Expected IOException to be thrown");
        } catch (IOException e) {
            // Assert
            assertNotNull(e);
            assertEquals("Error writing boolean", e.getMessage());
        } catch (XMLStreamException e) {
            // This exception is expected to be caught and wrapped in IOException
            fail("XMLStreamException should not have been thrown directly.");
        }
    }

}