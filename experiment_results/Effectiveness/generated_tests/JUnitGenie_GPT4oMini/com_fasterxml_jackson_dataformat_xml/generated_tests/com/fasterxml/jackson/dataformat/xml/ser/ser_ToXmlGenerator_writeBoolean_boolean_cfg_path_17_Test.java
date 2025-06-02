package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamException;
import javax.xml.namespace.QName;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_ToXmlGenerator_writeBoolean_boolean_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testWriteBoolean() {
        // Arrange
        QName nextName = new QName("namespaceURI", "localPart");
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, null, null);
        generator._nextName = nextName; // Set a valid QName
        generator._nextIsAttribute = false; // Set to false to meet the constraint
        boolean valueToWrite = true; // Test with a boolean value

        // Act
        try {
            generator.writeBoolean(valueToWrite);
        } catch (IOException e) {
            fail("IOException should not be thrown: " + e.getMessage());
        }
        // Removed XMLStreamException catch block as it is not thrown
    }

    @Test(timeout = 4000)
    public void testWriteBooleanWithNullNextName() {
        // Arrange
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, null, null);
        generator._nextName = null; // Set to null to trigger handleMissingName
        generator._nextIsAttribute = false; // Set to false to meet the constraint
        boolean valueToWrite = true; // Test with a boolean value

        // Act
        try {
            generator.writeBoolean(valueToWrite);
            fail("Expected an IOException to be thrown due to missing name.");
        } catch (IOException e) {
            // Expected exception
        }
        // Removed XMLStreamException catch block as it is not thrown
    }

}