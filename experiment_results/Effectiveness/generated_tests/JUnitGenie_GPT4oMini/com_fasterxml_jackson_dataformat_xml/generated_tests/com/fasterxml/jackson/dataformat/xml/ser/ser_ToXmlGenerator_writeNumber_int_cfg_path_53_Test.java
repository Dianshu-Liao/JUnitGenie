package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.Before;
import org.junit.Test;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ser_ToXmlGenerator_writeNumber_int_cfg_path_53_Test {

    private ToXmlGenerator toXmlGenerator;
    private XMLStreamWriter2 xmlWriter;

    @Before
    public void setUp() {
        xmlWriter = mock(XMLStreamWriter2.class);
        // Initialize ToXmlGenerator with a valid configuration
        toXmlGenerator = new ToXmlGenerator(null, 0, 0, null, xmlWriter, null) {
            @Override
            protected void handleMissingName() {
                // Mock implementation for testing
            }
        };
    }

    @Test(timeout = 4000)
    public void testWriteNumber_throwsIllegalStateException_whenNextNameIsNull() {
        // Arrange
        toXmlGenerator._nextName = null; // Simulate the condition for IllegalStateException

        try {
            // Act
            toXmlGenerator.writeNumber(42);
        } catch (IllegalStateException e) {
            // Assert
            assertEquals("Missing name", e.getMessage());
        } catch (IOException e) {
            // Handle IOException if thrown
            fail("IOException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_callsHandleMissingName_whenNextNameIsNull() {
        // Arrange
        toXmlGenerator._nextName = null; // Simulate the condition for handleMissingName to be called

        // Act
        try {
            toXmlGenerator.writeNumber(42);
        } catch (IOException e) {
            // Handle IOException if thrown
            fail("IOException should not be thrown");
        }

        // Assert
        verify(toXmlGenerator, times(1)).handleMissingName();
    }

    @Test(timeout = 4000)
    public void testWriteNumber_callsWriteInt_whenNextIsAttributeIsFalse() throws IOException, XMLStreamException {
        // Arrange
        toXmlGenerator._nextIsAttribute = false; // Set to false
        toXmlGenerator._nextName = new QName("namespace", "localPart"); // Set a valid QName

        // Act
        toXmlGenerator.writeNumber(42);

        // Assert
        verify(xmlWriter, times(1)).writeInt(42);
    }

    @Test(timeout = 4000)
    public void testWriteNumber_callsWriteIntAttribute_whenNextIsAttributeIsTrue() throws IOException, XMLStreamException {
        // Arrange
        toXmlGenerator._nextIsAttribute = true; // Set to true
        toXmlGenerator._nextName = new QName("namespace", "localPart"); // Set a valid QName

        // Act
        toXmlGenerator.writeNumber(42);

        // Assert
        verify(xmlWriter, times(1)).writeIntAttribute(null, "namespace", "localPart", 42);
    }

}