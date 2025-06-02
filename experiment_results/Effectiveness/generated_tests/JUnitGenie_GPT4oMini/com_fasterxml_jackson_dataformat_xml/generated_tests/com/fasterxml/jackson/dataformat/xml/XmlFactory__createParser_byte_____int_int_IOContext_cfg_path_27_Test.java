package com.fasterxml.jackson.dataformat.xml;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import org.junit.Assert;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;

public class XmlFactory__createParser_byte_____int_int_IOContext_cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testCreateParser() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory(); // Instantiating XmlFactory
        byte[] data = "<root></root>".getBytes(); // Sample XML data
        int offset = 0;
        int len = data.length;

        // Create an IOContext instance
        IOContext ioContext = new IOContext(xmlFactory._getBufferRecycler(), null, false); // Corrected parameters

        // Act
        try {
            // Access the protected method `_createParser` using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            
            FromXmlParser parser = (FromXmlParser) method.invoke(xmlFactory, data, offset, len, ioContext);

            // Assert
            Assert.assertNotNull(parser);
        } catch (Exception e) {
            // Handle any exceptions that might be thrown
            Assert.fail("An unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testCreateParserWithArrayIndexOutOfBoundsException() {
        // Arrange
        XmlFactory xmlFactory = new XmlFactory(); // Instantiating XmlFactory
        byte[] data = new byte[0]; // This should cause ArrayIndexOutOfBoundsException
        int offset = 0;
        int len = 1; // Length greater than data size to trigger the exception

        // Create an IOContext instance
        IOContext ioContext = new IOContext(xmlFactory._getBufferRecycler(), null, false); // Corrected parameters

        // Act
        try {
            // Access the protected method `_createParser` using reflection
            java.lang.reflect.Method method = XmlFactory.class.getDeclaredMethod("_createParser", byte[].class, int.class, int.class, IOContext.class);
            method.setAccessible(true);
            
            method.invoke(xmlFactory, data, offset, len, ioContext);
            Assert.fail("Expected ArrayIndexOutOfBoundsException was not thrown.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Expected exception
        } catch (Exception e) {
            // Handle any other type of exception that might be thrown
            Assert.fail("An unexpected exception occurred: " + e.getMessage());
        }
    }


}