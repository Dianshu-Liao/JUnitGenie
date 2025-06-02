package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;

public class XmlTokenStream_skipAttributes_16_1_Test {

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        XMLStreamReader mockReader = Mockito.mock(XMLStreamReader.class);
        ContentReference mockContentRef = Mockito.mock(ContentReference.class);
        XmlNameProcessor mockNameProcessor = Mockito.mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream((XMLStreamReader2) mockReader, mockContentRef, 0, mockNameProcessor);
    }

    @Test
    public void testSkipAttributes_TransitionFromAttributeName() {
        // Arrange
        xmlTokenStream._currentState = XmlTokenStream.XML_ATTRIBUTE_NAME;
        // Assume there were 5 attributes
        xmlTokenStream._attributeCount = 5;
        // Act
        xmlTokenStream.skipAttributes();
        // Assert
        assertEquals(0, xmlTokenStream._attributeCount, "Attribute count should be reset to 0.");
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState, "Current state should transition to XML_START_ELEMENT.");
    }

    @Test
    public void testSkipAttributes_NoActionInStartElement() {
        // Arrange
        xmlTokenStream._currentState = XmlTokenStream.XML_START_ELEMENT;
        // Assume there were 5 attributes
        xmlTokenStream._attributeCount = 5;
        // Act
        xmlTokenStream.skipAttributes();
        // Assert
        assertEquals(5, xmlTokenStream._attributeCount, "Attribute count should remain unchanged.");
        assertEquals(XmlTokenStream.XML_START_ELEMENT, xmlTokenStream._currentState, "Current state should remain XML_START_ELEMENT.");
    }

    @Test
    public void testSkipAttributes_NoActionInText() {
        // Arrange
        xmlTokenStream._currentState = XmlTokenStream.XML_TEXT;
        // Act
        xmlTokenStream.skipAttributes();
        // Assert
        assertEquals(XmlTokenStream.XML_TEXT, xmlTokenStream._currentState, "Current state should remain XML_TEXT.");
    }

    @Test
    public void testSkipAttributes_IllegalStateException() {
        // Arrange
        // Invalid state
        xmlTokenStream._currentState = 999;
        // Act & Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            xmlTokenStream.skipAttributes();
        });
        assertEquals("Current state not XML_START_ELEMENT or XML_ATTRIBUTE_NAME but " + xmlTokenStream._currentStateDesc(), exception.getMessage());
    }
}
