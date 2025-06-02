package org.apache.commons.jxpath.xml;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.xml.DocumentContainer;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class xml_DocumentContainer_getValue__cfg_path_10_Test {

    private DocumentContainer documentContainer;
    private URL mockUrl; // Declare mockUrl as a class member
    private URLConnection mockConnection; // Add a mock for URLConnection

    @Before
    public void setUp() throws Exception {
        // Set up a URL mock for testing
        mockUrl = new URL("http://mockurl.com"); // Create a real URL object
        mockConnection = mock(URLConnection.class); // Mock URLConnection
        InputStream mockInputStream = mock(InputStream.class); // Mock InputStream

        // Set up the connection to return the mock InputStream
        when(mockConnection.getInputStream()).thenThrow(new IOException("Mock IOException"));
        when(mockUrl.openConnection()).thenReturn(mockConnection);

        documentContainer = new DocumentContainer(mockUrl);
    }

    @Test(timeout = 4000)
    public void testGetValue_ThrowsJXPathException_WhenIOExceptionOccurs() {
        try {
            // Act
            documentContainer.getValue();
            fail("Expected JXPathException to be thrown"); // Fail if no exception is thrown
        } catch (JXPathException e) {
            // Assert
            assertEquals("Cannot read XML from: " + mockUrl.toString(), e.getMessage());
            assertNotNull(e.getCause());
            assertTrue(e.getCause() instanceof IOException);
        }
    }


}