package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.CharArrayReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class XmlFactory__createParser_char_____int_int_IOContext_boolean_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);
        boolean recycleBuffer = false;

        XmlFactory xmlFactory = new XmlFactory();
        // Using reflection to access the protected method
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
            method.setAccessible(true);

            // Act
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ctxt, recycleBuffer);

            // Assert
            assertNotNull(parser);
            // Additional assertions can be added here based on the expected behavior of the parser

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithException() {
        // Arrange
        char[] data = "<root></root>".toCharArray();
        int offset = 0;
        int len = data.length;
        IOContext ctxt = new IOContext(null, null, false);
        boolean recycleBuffer = false;

        XmlFactory xmlFactory = new XmlFactory();
        // Using reflection to access the protected method
        try {
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", char[].class, int.class, int.class, IOContext.class, boolean.class);
            method.setAccessible(true);

            // Simulate an exception by passing invalid data
            char[] invalidData = null; // This should cause a NullPointerException
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, invalidData, offset, len, ctxt, recycleBuffer);

            // Assert
            assertNull(parser); // Expecting null due to exception handling

        } catch (NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            // Handle the exception as expected
            assertTrue(e.getCause() instanceof NullPointerException);
        } catch (NullPointerException e) {
            // This catch block is added to handle the NullPointerException explicitly
            assertTrue(true); // Test passes if this exception is thrown
        }
    }


}