package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import org.junit.Test;
import javax.xml.stream.XMLStreamReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class deser_XmlTokenStream_skipAttributes__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSkipAttributes_caseXMLAttributeName() {
        try {
            // Arrange
            XMLStreamReader xmlStreamReader = null; // Mock or actual instance as needed
            XmlTokenStream stream = new XmlTokenStream(xmlStreamReader, null, 0, null);
            // Set _currentState to XML_ATTRIBUTE_NAME (which I assume is 1)
            setCurrentState(stream, 1);

            // Act
            invokeSkipAttributes(stream);

            // Assert
            assertEquals(0, getAttributeCount(stream));
            assertEquals(2, getCurrentState(stream)); // XML_START_ELEMENT is assumed to be 2

        } catch (Exception e) {
            fail("SkipAttributes threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSkipAttributes_caseXMLStartElement() {
        try {
            // Arrange
            XMLStreamReader xmlStreamReader = null; // Mock or actual instance as needed
            XmlTokenStream stream = new XmlTokenStream(xmlStreamReader, null, 0, null);
            // Set _currentState to XML_START_ELEMENT (which I assume is 2)
            setCurrentState(stream, 2);

            // Act
            invokeSkipAttributes(stream);

            // Assert
            assertEquals(0, getAttributeCount(stream));
            assertEquals(2, getCurrentState(stream)); // Should remain as XML_START_ELEMENT

        } catch (Exception e) {
            fail("SkipAttributes threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSkipAttributes_caseXMLText() {
        try {
            // Arrange
            XMLStreamReader xmlStreamReader = null; // Mock or actual instance as needed
            XmlTokenStream stream = new XmlTokenStream(xmlStreamReader, null, 0, null);
            // Set _currentState to XML_TEXT (which I assume is 3)
            setCurrentState(stream, 3);

            // Act
            invokeSkipAttributes(stream);

            // Assert - Since nothing happens, we check state remains the same
            assertEquals(3, getCurrentState(stream)); // Should remain as XML_TEXT

        } catch (Exception e) {
            fail("SkipAttributes threw an exception: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSkipAttributes_invalidState() {
        try {
            // Arrange
            XMLStreamReader xmlStreamReader = null; // Mock or actual instance as needed
            XmlTokenStream stream = new XmlTokenStream(xmlStreamReader, null, 0, null);
            // Set _currentState to an invalid state (assuming any state greater than 3 is invalid)
            setCurrentState(stream, 99);

            // Act
            invokeSkipAttributes(stream);
            fail("Expected IllegalStateException was not thrown");
        } catch (IllegalStateException e) {
            // Assert
            assertEquals("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME but 99", e.getMessage());
        } catch (Exception e) {
            fail("Expected IllegalStateException but another exception was thrown: " + e.getMessage());
        }
    }

    private void invokeSkipAttributes(XmlTokenStream stream) throws Exception {
        java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("skipAttributes");
        method.setAccessible(true); // Enable access to the protected method
        method.invoke(stream);
    }

    private void setCurrentState(XmlTokenStream stream, int state) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_currentState");
        field.setAccessible(true);
        field.setInt(stream, state);
    }

    private int getCurrentState(XmlTokenStream stream) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_currentState");
        field.setAccessible(true);
        return field.getInt(stream);
    }

    private int getAttributeCount(XmlTokenStream stream) throws Exception {
        java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_attributeCount");
        field.setAccessible(true);
        return field.getInt(stream);
    }

}