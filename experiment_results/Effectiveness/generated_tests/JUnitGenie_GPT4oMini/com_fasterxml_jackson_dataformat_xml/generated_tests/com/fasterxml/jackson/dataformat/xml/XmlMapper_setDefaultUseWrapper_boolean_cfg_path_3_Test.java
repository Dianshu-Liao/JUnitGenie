package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XmlMapper_setDefaultUseWrapper_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetDefaultUseWrapper() {
        // Arrange
        XmlMapper xmlMapper = new XmlMapper();
        boolean state = true;

        // Act
        XmlMapper result = xmlMapper.setDefaultUseWrapper(state);

        // Assert
        assertNotNull(result);
    }

}