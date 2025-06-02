package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import javax.xml.stream.XMLOutputFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XmlFactoryBuilder_xmlOutputFactory__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testXmlOutputFactory_whenXmlOutputFactoryIsNull() {
        // Arrange
        XmlFactoryBuilder xmlFactoryBuilder = new XmlFactoryBuilder();
        
        // Act
        XMLOutputFactory result = null;
        try {
            result = xmlFactoryBuilder.xmlOutputFactory();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Assert
        assertNotNull("Expected XMLOutputFactory to be created", result);
    }

}