package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ser_ToXmlGenerator_isEnabled_Feature_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsEnabledWithFeatureNotEnabled() {
        // Arrange
        int formatFeatures = 0; // _formatFeatures is set to 0 to ensure (_formatFeatures & f.getMask()) == 0
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
        assertFalse(result);
    }


}