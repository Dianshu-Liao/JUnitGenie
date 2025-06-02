package com.fasterxml.jackson.dataformat.xml.deser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.stream.*;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

public class XmlTokenStream_skipAttributes_16_1_Test {

    private XmlTokenStream xmlTokenStream;

    private XMLStreamReader xmlReader;

    private ContentReference sourceReference;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    public void setUp() {
        xmlReader = mock(XMLStreamReader.class);
        sourceReference = mock(ContentReference.class);
        nameProcessor = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(xmlReader, sourceReference, 0, nameProcessor);
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsXmlAttributeName() {
        // Arrange
        setCurrentState(XmlTokenStream.XML_ATTRIBUTE_NAME);
        // Act
        invokeSkipAttributes();
        // Assert
        assertEquals(0, getAttributeCount());
        assertEquals(XmlTokenStream.XML_START_ELEMENT, getCurrentState());
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsXmlStartElement() {
        // Arrange
        setCurrentState(XmlTokenStream.XML_START_ELEMENT);
        // Act
        invokeSkipAttributes();
        // Assert
        assertEquals(0, getAttributeCount());
        assertEquals(XmlTokenStream.XML_START_ELEMENT, getCurrentState());
    }

    @Test
    public void testSkipAttributesWhenCurrentStateIsXmlText() {
        // Arrange
        setCurrentState(XmlTokenStream.XML_TEXT);
        // Act
        invokeSkipAttributes();
        // Assert
        assertEquals(0, getAttributeCount());
        assertEquals(XmlTokenStream.XML_TEXT, getCurrentState());
    }

    @Test
    public void testSkipAttributesThrowsExceptionForInvalidState() {
        // Arrange
        // Invalid state
        setCurrentState(99);
        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, this::invokeSkipAttributes);
        assertTrue(exception.getMessage().contains("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME"));
    }

    private void setCurrentState(int state) {
        try {
            java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_currentState");
            field.setAccessible(true);
            field.setInt(xmlTokenStream, state);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getCurrentState() {
        try {
            java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_currentState");
            field.setAccessible(true);
            return field.getInt(xmlTokenStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getAttributeCount() {
        try {
            java.lang.reflect.Field field = XmlTokenStream.class.getDeclaredField("_attributeCount");
            field.setAccessible(true);
            return field.getInt(xmlTokenStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeSkipAttributes() {
        try {
            java.lang.reflect.Method method = XmlTokenStream.class.getDeclaredMethod("skipAttributes");
            method.setAccessible(true);
            method.invoke(xmlTokenStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
