package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_GetImage__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetImageWhenBufposGreaterThanTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, buffer.length);
        stream.bufpos = 12; // bufpos is greater than tokenBegin
        stream.tokenBegin = 0; // tokenBegin is set to 0
        stream.buffer = buffer;

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test(timeout = 4000)
    public void testGetImageWhenBufposEqualsTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, buffer.length);
        stream.bufpos = 0; // bufpos equals tokenBegin
        stream.tokenBegin = 0; // tokenBegin is set to 0
        stream.buffer = buffer;

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals("H", result);
    }

    @Test(timeout = 4000)
    public void testGetImageWhenBufposLessThanTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, buffer.length);
        stream.bufpos = 5; // bufpos is less than tokenBegin
        stream.tokenBegin = 10; // tokenBegin is set to 10
        stream.buffer = buffer;

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals(" World!", result);
    }

}