package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import javax.xml.stream.XMLOutputFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XmlFactoryBuilder_xmlOutputFactory__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testXmlOutputFactoryWhenNotNull() {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        // Using reflection to set the protected field _xmlOutputFactory
        try {
            java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_xmlOutputFactory");
            field.setAccessible(true);
            field.set(builder, XMLOutputFactory.newInstance()); // Setting a non-null value

            // Act
            XMLOutputFactory result = builder.xmlOutputFactory();

            // Assert
            assertNotNull(result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

    @Test(timeout = 4000)
    public void testXmlOutputFactoryWhenNull() {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        // Using reflection to set the protected field _xmlOutputFactory to null
        try {
            java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_xmlOutputFactory");
            field.setAccessible(true);
            field.set(builder, null); // Setting a null value

            // Act
            XMLOutputFactory result = builder.xmlOutputFactory();

            // Assert
            assertNotNull(result); // Expecting defaultOutputFactory() to be called
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}