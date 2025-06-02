package org.apache.commons.jxpath.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
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
        InputStream mockStream = new ByteArrayInputStream("<xml></xml>".getBytes());
        when(mockUrl.openStream()).thenReturn(mockStream);
        // Mock the parseXML method
        DocumentContainer spyContainer = Mockito.spy(documentContainer);
        doReturn(new Object()).when(spyContainer).parseXML(any(InputStream.class));
        // Act
        Object result = spyContainer.getValue();
        // Assert
        assertNotNull(result);
        verify(spyContainer).parseXML(mockStream);
    }

    @Test
    public void testGetValueWhenDocumentIsNotNull() throws Exception {
        // Arrange
        Object mockDocument = new Object();
        documentContainer.setValue(mockDocument);
        // Act
        Object result = documentContainer.getValue();
        // Assert
        assertEquals(mockDocument, result);
    }

    @Test
    public void testGetValueHandlesIOException() throws Exception {
        // Arrange
        when(mockUrl.openStream()).thenThrow(new IOException("Test IOException"));
        // Act & Assert
        JXPathException exception = assertThrows(JXPathException.class, () -> {
            documentContainer.getValue();
        });
        assertEquals("Cannot read XML from: " + mockUrl.toString(), exception.getMessage());
    }

    @Test
    public void testGetValueClosesStream() throws Exception {
        // Arrange
        InputStream mockStream = mock(InputStream.class);
        when(mockUrl.openStream()).thenReturn(mockStream);
        DocumentContainer spyContainer = Mockito.spy(documentContainer);
        doReturn(new Object()).when(spyContainer).parseXML(any(InputStream.class));
        // Act
        spyContainer.getValue();
        // Assert
        verify(mockStream).close();
    }
}
