package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_DefaultIndenter_withLinefeed_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithLinefeedReturnsSameInstanceWhenLinefeedIsEqualToEol() {
        // Arrange
        DefaultIndenter indenter = new DefaultIndenter();
        String eol = indenter.getEol(); // Use the getter method to access eol
        // Act
        DefaultIndenter result = indenter.withLinefeed(eol);
        // Assert
        assertSame(indenter, result);
    }

    @Test(timeout = 4000)
    public void testWithLinefeedReturnsNewInstanceWhenLinefeedIsDifferentFromEol() {
        // Arrange
        DefaultIndenter indenter = new DefaultIndenter("  ", "\n");
        String differentLf = "\r\n"; // A different linefeed
        // Act
        DefaultIndenter result = indenter.withLinefeed(differentLf);
        // Assert
        assertNotSame(indenter, result);
        assertEquals("  ", result.getIndent());
        assertEquals(differentLf, result.getEol()); // Use the getter method to access eol
    }


}