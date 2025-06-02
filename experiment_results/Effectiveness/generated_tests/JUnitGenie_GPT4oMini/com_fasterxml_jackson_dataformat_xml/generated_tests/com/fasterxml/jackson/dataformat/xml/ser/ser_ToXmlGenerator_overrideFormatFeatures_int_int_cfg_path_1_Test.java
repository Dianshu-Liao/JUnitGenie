package com.fasterxml.jackson.dataformat.xml.ser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.stream.XMLStreamWriter;

public class ser_ToXmlGenerator_overrideFormatFeatures_int_int_cfg_path_1_Test {

    private ToXmlGenerator generator;


    @Test(timeout = 4000)
    public void testOverrideFormatFeatures() {
        int values = 5; // Example values
        int mask = 3;   // Example mask

        // Capture the original _formatFeatures to verify the change
        int originalFeatures = generator._formatFeatures;

        // Call the method under test
        generator.overrideFormatFeatures(values, mask);

        // Calculate the expected new features based on the logic in the method.
        int expectedNewFeatures = (originalFeatures & ~mask) | (values & mask);

        // Verify that the _formatFeatures have been updated correctly
        assertEquals(expectedNewFeatures, generator._formatFeatures);
    }

}
