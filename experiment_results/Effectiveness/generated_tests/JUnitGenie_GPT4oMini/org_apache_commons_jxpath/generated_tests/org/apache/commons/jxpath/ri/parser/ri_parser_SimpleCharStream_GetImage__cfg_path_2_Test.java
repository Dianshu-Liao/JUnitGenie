package org.apache.commons.jxpath.ri.parser;
import org.apache.commons.jxpath.ri.parser.SimpleCharStream;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ri_parser_SimpleCharStream_GetImage__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetImageWhenBufposGreaterThanTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, 13, 13);
        stream.bufpos = 12; // Set bufpos greater than tokenBegin
        stream.tokenBegin = 0; // Set tokenBegin

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test(timeout = 4000)
    public void testGetImageWhenBufposEqualsTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, 13, 13);
        stream.bufpos = 0; // Set bufpos equal to tokenBegin
        stream.tokenBegin = 0; // Set tokenBegin

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals("H", result);
    }

    @Test(timeout = 4000)
    public void testGetImageWhenBufposLessThanTokenBegin() {
        // Arrange
        char[] buffer = "Hello, World!".toCharArray();
        SimpleCharStream stream = new SimpleCharStream(new java.io.StringReader("Hello, World!"), 0, 13, 13);
        stream.bufpos = 5; // Set bufpos less than tokenBegin
        stream.tokenBegin = 10; // Set tokenBegin

        // Act
        String result = stream.GetImage();

        // Assert
        assertEquals(" World!", result);
    }

}