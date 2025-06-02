package org.apache.commons.jxpath.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.jxpath.JXPathException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.util.ClassLoaderUtil;

class DocumentContainer_getValue_2_0_Test {

    private DocumentContainer documentContainer;

    private URL validUrl;

    private URL invalidUrl;

    @BeforeEach
    void setUp() throws Exception {
        validUrl = new URL("http://example.com/test.xml");
        invalidUrl = new URL("http://invalid-url");
        documentContainer = new DocumentContainer(validUrl);
    }

    @Test
    void testGetValueWhenDocumentIsNull() throws Exception {
        // Mocking InputStream to simulate XML parsing
        InputStream mockStream = new ByteArrayInputStream("<xml></xml>".getBytes());
        URL mockUrl = mock(URL.class);
        when(mockUrl.openStream()).thenReturn(mockStream);
        // Use reflection to set the private field xmlURL
        java.lang.reflect.Field field = DocumentContainer.class.getDeclaredField("xmlURL");
        field.setAccessible(true);
        field.set(documentContainer, mockUrl);
        // Mocking the parseXML method to return a Document
        Document mockDocument = mock(Document.class);
        doReturn(mockDocument).when(documentContainer).parseXML(any(InputStream.class));
        Object result = documentContainer.getValue();
        assertNotNull(result);
        assertTrue(result instanceof Document);
    }

    @Test
    void testGetValueWhenIOExceptionOccurs() throws Exception {
        // Mocking URL to throw IOException when openStream is called
        URL mockUrl = mock(URL.class);
        when(mockUrl.openStream()).thenThrow(new IOException("Stream error"));
        // Use reflection to set the private field xmlURL
        java.lang.reflect.Field field = DocumentContainer.class.getDeclaredField("xmlURL");
        field.setAccessible(true);
        field.set(documentContainer, mockUrl);
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            documentContainer.getValue();
        });
        assertEquals("Cannot read XML from: " + mockUrl.toString(), exception.getMessage());
    }

    @Test
    void testGetValueWhenDocumentIsAlreadySet() throws Exception {
        // Assuming document is already set
        Document mockDocument = mock(Document.class);
        java.lang.reflect.Field documentField = DocumentContainer.class.getDeclaredField("document");
        documentField.setAccessible(true);
        documentField.set(documentContainer, mockDocument);
        Object result = documentContainer.getValue();
        assertSame(mockDocument, result);
    }
}
