package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.events.XMLEvent;
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
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

public class XmlTokenStream__skipAndCollectTextUntilTag_19_2_Test {

    private XMLStreamReader xmlReaderMock;

    private ContentReference contentReferenceMock;

    private XmlNameProcessor nameProcessorMock;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        xmlReaderMock = mock(XMLStreamReader.class);
        contentReferenceMock = mock(ContentReference.class);
        nameProcessorMock = mock(XmlNameProcessor.class);
        xmlTokenStream = new XmlTokenStream(xmlReaderMock, contentReferenceMock, 0, nameProcessorMock);
    }

    @Test
    public void testSkipAndCollectTextUntilTag_StartElement() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, true, false);
        when(xmlReaderMock.next()).thenReturn(XMLEvent.START_ELEMENT, XMLEvent.CHARACTERS, XMLEvent.END_ELEMENT);
        when(xmlReaderMock.getText()).thenReturn("text");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XMLEvent.START_ELEMENT, result);
        assertEquals("text", getPrivateField("_textValue"));
    }

    @Test
    public void testSkipAndCollectTextUntilTag_EndElement() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, false);
        when(xmlReaderMock.next()).thenReturn(XMLEvent.END_ELEMENT, XMLEvent.CHARACTERS);
        when(xmlReaderMock.getText()).thenReturn("text");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XMLEvent.END_ELEMENT, result);
        assertEquals("text", getPrivateField("_textValue"));
    }

    @Test
    public void testSkipAndCollectTextUntilTag_EndDocument() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, false);
        when(xmlReaderMock.next()).thenReturn(XMLEvent.END_DOCUMENT);
        assertThrows(IllegalStateException.class, () -> invokeSkipAndCollectTextUntilTag());
    }

    @Test
    public void testSkipAndCollectTextUntilTag_Characters() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, true, false);
        when(xmlReaderMock.next()).thenReturn(XMLEvent.CHARACTERS, XMLEvent.CHARACTERS, XMLEvent.START_ELEMENT);
        when(xmlReaderMock.getText()).thenReturn("text1", "text2");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XMLEvent.START_ELEMENT, result);
        assertEquals("text1text2", getPrivateField("_textValue"));
    }

    @Test
    public void testSkipAndCollectTextUntilTag_IgnoreOtherTypes() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, true, false);
        when(xmlReaderMock.next()).thenReturn(XMLEvent.PROCESSING_INSTRUCTION, XMLEvent.CHARACTERS, XMLEvent.END_ELEMENT);
        when(xmlReaderMock.getText()).thenReturn("text");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XMLEvent.END_ELEMENT, result);
        assertEquals("text", getPrivateField("_textValue"));
    }

    private int invokeSkipAndCollectTextUntilTag() throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_skipAndCollectTextUntilTag");
        method.setAccessible(true);
        return (int) method.invoke(xmlTokenStream);
    }

    private String getPrivateField(String fieldName) throws Exception {
        Field field = XmlTokenStream.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (String) field.get(xmlTokenStream);
    }
}
