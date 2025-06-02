package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class deser_FromXmlParser_close__cfg_path_42_Test {

    @Test(timeout = 4000)
    public void testClose() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(bufferRecycler, null, false); // Correct constructor usage
        FromXmlParser parser = null;
        try {
            parser = new FromXmlParser(ioContext, 0, 0, null, null, null);
            parser._closed = false; // Set _closed to false to enter the close logic

            // Act
            parser.close();
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }

        // Assert
        assertTrue(parser._closed); // Verify that _closed is set to true
    }

    @Test(timeout = 4000)
    public void testCloseWithXMLStreamException() {
        // Arrange
        BufferRecycler bufferRecycler = new BufferRecycler();
        IOContext ioContext = new IOContext(bufferRecycler, null, true) { // Correct constructor usage
            @Override
            public boolean isResourceManaged() {
                return true; // Simulate resource management
            }
        };
        FromXmlParser parser = null;
        try {
            parser = new FromXmlParser(ioContext, 0, 0, null, null, null);
            parser._closed = false; // Set _closed to false to enter the close logic

            // Act
            parser.close();
        } catch (IOException e) {
            // Expected exception due to XMLStreamException
            assertTrue(e.getCause() instanceof XMLStreamException);
        }
    }


}