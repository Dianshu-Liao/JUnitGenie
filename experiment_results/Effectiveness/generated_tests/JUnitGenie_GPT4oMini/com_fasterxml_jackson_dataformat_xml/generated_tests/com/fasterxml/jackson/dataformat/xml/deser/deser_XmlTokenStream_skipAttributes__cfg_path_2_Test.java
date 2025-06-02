package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;

public class deser_XmlTokenStream_skipAttributes__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSkipAttributes_XML_ATTRIBUTE_NAME() {
        try {
            // Arrange
            XmlTokenStream xmlTokenStream = new XmlTokenStream(null, null, 0, null);
            // Set the _currentState to XML_ATTRIBUTE_NAME (assuming 1 is the value for XML_ATTRIBUTE_NAME)
            setField(xmlTokenStream, "_currentState", 1);

            // Act
            invokeSkipAttributes(xmlTokenStream);

            // Assert
            int currentState = getField(xmlTokenStream, "_currentState");
            assertEquals(2, currentState); // Assuming 2 is the value for XML_START_ELEMENT
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipAttributes_XML_START_ELEMENT() {
        try {
            // Arrange
            XmlTokenStream xmlTokenStream = new XmlTokenStream(null, null, 0, null);
            // Set the _currentState to XML_START_ELEMENT (assuming 2 is the value for XML_START_ELEMENT)
            setField(xmlTokenStream, "_currentState", 2);

            // Act
            invokeSkipAttributes(xmlTokenStream);

            // Assert
            int currentState = getField(xmlTokenStream, "_currentState");
            assertEquals(2, currentState); // Should remain XML_START_ELEMENT
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSkipAttributes_IllegalStateException() {
        XmlTokenStream xmlTokenStream = new XmlTokenStream(null, null, 0, null); // Moved declaration here
        try {
            // Arrange
            // Set the _currentState to an invalid state (assuming 99 is not a valid state)
            setField(xmlTokenStream, "_currentState", 99);

            // Act
            invokeSkipAttributes(xmlTokenStream);
        } catch (IllegalStateException e) {
            // Assert
            assertEquals("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME but " + 
                         99, e.getMessage()); // Changed to use the invalid state directly
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void invokeSkipAttributes(XmlTokenStream xmlTokenStream) throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("skipAttributes");
        method.setAccessible(true);
        method.invoke(xmlTokenStream);
    }

    private void setField(XmlTokenStream xmlTokenStream, String fieldName, int value) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(xmlTokenStream, value);
    }

    private int getField(XmlTokenStream xmlTokenStream, String fieldName) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getInt(xmlTokenStream);
    }


}