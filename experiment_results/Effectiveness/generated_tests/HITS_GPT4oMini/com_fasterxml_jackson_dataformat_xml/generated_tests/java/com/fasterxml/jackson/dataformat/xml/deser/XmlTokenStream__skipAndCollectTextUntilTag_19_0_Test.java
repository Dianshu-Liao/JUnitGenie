package com.fasterxml.jackson.dataformat.xml.deser;

import org.codehaus.stax2.XMLStreamReader2;
import javax.xml.XMLConstants;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.codehaus.stax2.XMLStreamLocation2;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.Stax2JacksonReaderAdapter;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.xml.stream.*;

public class XmlTokenStream__skipAndCollectTextUntilTag_19_0_Test {

    private XMLStreamReader2 xmlReaderMock;

    private XmlTokenStream xmlTokenStream;

    @BeforeEach
    public void setUp() {
        xmlReaderMock = mock(XMLStreamReader2.class);
        xmlTokenStream = new XmlTokenStream(xmlReaderMock, null, 0, null);
    }

    private int invokeSkipAndCollectTextUntilTag() throws Exception {
        Method method = XmlTokenStream.class.getDeclaredMethod("_skipAndCollectTextUntilTag");
        method.setAccessible(true);
        return (int) method.invoke(xmlTokenStream);
    }

    @Test
    public void testSkipAndCollectTextUntilTag_StartElement() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, true, false);
        when(xmlReaderMock.next()).thenReturn(XmlTokenStream.XML_TEXT, XmlTokenStream.XML_START_ELEMENT);
        when(xmlReaderMock.getText()).thenReturn("Sample text");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XmlTokenStream.XML_START_ELEMENT, result);
        assertEquals("Sample text", xmlTokenStream.getText());
    }

    @Test
    public void testSkipAndCollectTextUntilTag_EndElement() throws Exception {
        when(xmlReaderMock.hasNext()).thenReturn(true, true, true, false);
        when(xmlReaderMock.next()).thenReturn(XmlTokenStream.XML_TEXT, XmlTokenStream.XML_END_ELEMENT);
        when(xmlReaderMock.getText()).thenReturn("Another text");
        int result = invokeSkipAndCollectTextUntilTag();
        assertEquals(XmlTokenStream.XML_END_ELEMENT, result);
        assertEquals("Another text", xmlTokenStream.getText());
    }
}
