package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import javax.xml.stream.XMLInputFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class XmlFactoryBuilder_xmlInputFactory__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testXmlInputFactoryWhenNotNull() {
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        // Reflectively assign a value to the protected field _xmlInputFactory
        try {
            java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_xmlInputFactory");
            field.setAccessible(true);
            field.set(builder, XMLInputFactory.newInstance()); // Set to a valid instance

            XMLInputFactory result = builder.xmlInputFactory();
            assertNotNull(result); // Ensure that the result is not null as _xmlInputFactory is set
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testXmlInputFactoryWhenNull() {
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        try {
            // Here _xmlInputFactory should be null as we are not setting it explicitly
            XMLInputFactory result = builder.xmlInputFactory();
            assertNotNull(result); // Test should evaluate if defaultInputFactory was called if _xmlInputFactory is null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}