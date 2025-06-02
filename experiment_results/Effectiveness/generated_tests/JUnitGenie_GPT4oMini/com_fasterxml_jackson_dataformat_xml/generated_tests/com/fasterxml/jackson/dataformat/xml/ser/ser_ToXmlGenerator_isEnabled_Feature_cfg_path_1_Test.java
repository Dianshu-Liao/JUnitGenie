package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ser_ToXmlGenerator_isEnabled_Feature_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsEnabledWithNoOverlap() {
        // Arrange
        int formatFeatures = 0; // _formatFeatures with all bits as 0
        ToXmlGenerator generator = new ToXmlGenerator(null, 0, 0, null, null, null);
        generator._formatFeatures = formatFeatures; // Set the protected field directly for testing

        Feature feature = Feature.WRITE_XML_DECLARATION; // Use an existing enum constant instead of instantiating

        // Act
        boolean result = false;
        try {
            result = generator.isEnabled(feature);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertFalse(result); // Expecting false since there is no overlap
    }


}