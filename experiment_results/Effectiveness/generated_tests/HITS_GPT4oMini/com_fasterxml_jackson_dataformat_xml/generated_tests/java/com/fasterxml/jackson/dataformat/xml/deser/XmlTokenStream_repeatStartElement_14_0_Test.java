package com.fasterxml.jackson.dataformat.xml.deser;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamLocation2;
import org.codehaus.stax2.XMLStreamReader2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

class XmlTokenStream_repeatStartElement_14_0_Test extends XmlTokenStream {

    public XmlTokenStream_repeatStartElement_14_0_Test(XMLStreamReader xmlReader) {
        super(xmlReader, null, 0, null);
    }

    public int getRepeatElement() {
        return _repeatElement;
    }

    @BeforeEach
    void setUp() {
        // Initialize necessary fields for the test
        _currentState = XML_START_ELEMENT;
        _localName = "testElement";
        _namespaceURI = "http://example.com/test";
        _currentWrapper = null;
    }

    @Test
    void testRepeatStartElement() throws XMLStreamException {
        // Call the method under test
        repeatStartElement();
        // Check that the repeat element is set to REPLAY_START_DUP
        assertEquals(1, getRepeatElement(), "Expected repeat element to be REPLAY_START_DUP");
    }

    @Test
    void testRepeatStartElementWithExistingWrapper() throws XMLStreamException {
        // Set up an existing wrapper
        _currentWrapper = ElementWrapper.matchingWrapper(null, "existingElement", "http://example.com/existing");
        // Call the method under test
        repeatStartElement();
        // Check that the repeat element is still set to REPLAY_START_DUP
        assertEquals(1, getRepeatElement(), "Expected repeat element to be REPLAY_START_DUP");
    }

    @Test
    void testRepeatStartElementInvalidState() {
        // Set up an invalid state
        _currentState = XML_END_ELEMENT;
        // Assert that an IllegalStateException is thrown
        IllegalStateException thrown = assertThrows(IllegalStateException.class, this::repeatStartElement);
        assertEquals("Current state not XML_START_ELEMENT but " + _currentStateDesc(), thrown.getMessage());
    }
}
