package org.apache.commons.jxpath.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ClassLoaderUtil;

public class DocumentContainer_getValue_2_0_Test {

    private DocumentContainer documentContainer;

    private URL mockUrl;

    @BeforeEach
    public void setUp() throws Exception {
        mockUrl = mock(URL.class);
        documentContainer = new DocumentContainer(mockUrl);
    }

    @Test
    public void testGetValueWhenDocumentIsNull() throws Exception {
        // Arrange
        InputStream mockStream = mock(InputStream.class);
        when(mockUrl.openStream()).thenReturn(mockStream);
        // Assuming parseXML is a method in DocumentContainer class
        // We'll use reflection to invoke it
        DocumentContainer spyContainer = Mockito.spy(documentContainer);
        doReturn(new Object()).when(spyContainer).parseXML(any(InputStream.class));
        // Act
        Object result = spyContainer.getValue();
        // Assert
        assertNotNull(result);
        // Ensure it returns the same document
        assertEquals(result, spyContainer.getValue());
        // Ensure the stream gets closed
        verify(mockStream).close();
    }

    @Test
    public void testGetValueWhenStreamIsNull() throws Exception {
        // Arrange
        when(mockUrl.openStream()).thenThrow(new IOException("Stream not available"));
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            documentContainer.getValue();
        });
        assertEquals("Cannot read XML from: " + mockUrl.toString(), exception.getMessage());
    }

    @Test
    public void testGetValueWhenDocumentIsAlreadyLoaded() throws Exception {
        // Arrange
        Object mockDocument = new Object();
        DocumentContainer spyContainer = Mockito.spy(documentContainer);
        doReturn(mockDocument).when(spyContainer).parseXML(any(InputStream.class));
        // Act
        // Load the document first
        Object firstCall = spyContainer.getValue();
        // Call again
        Object secondCall = spyContainer.getValue();
        // Assert
        // Should return the loaded document
        assertNotNull(firstCall);
        // Should return the same instance
        assertSame(firstCall, secondCall);
    }
}
