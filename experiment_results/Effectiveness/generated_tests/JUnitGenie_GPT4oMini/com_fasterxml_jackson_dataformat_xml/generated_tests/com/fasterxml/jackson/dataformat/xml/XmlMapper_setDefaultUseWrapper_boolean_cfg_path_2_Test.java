package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlMapper_setDefaultUseWrapper_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetDefaultUseWrapper() {
        XmlMapper xmlMapper = new XmlMapper();
        boolean state = true; // Test with state set to true

        // Call the focal method
        XmlMapper result = xmlMapper.setDefaultUseWrapper(state);

        // Verify that the method returns the same instance
        assertSame(xmlMapper, result);
        
        // Test with state set to false
        state = false;
        result = xmlMapper.setDefaultUseWrapper(state);
        
        // Verify that the method returns the same instance again
        assertSame(xmlMapper, result);
    }

}