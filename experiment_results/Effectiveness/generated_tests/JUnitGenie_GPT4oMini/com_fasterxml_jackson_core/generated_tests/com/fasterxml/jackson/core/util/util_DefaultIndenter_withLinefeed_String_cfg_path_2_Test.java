package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class util_DefaultIndenter_withLinefeed_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithLinefeedReturnsThisWhenLfEqualsEol() {
        // Arrange
        DefaultIndenter indenter = new DefaultIndenter();
        String lf = indenter.getEol(); // Use a public method to access eol
       
        // Act
        DefaultIndenter result = indenter.withLinefeed(lf);
        
        // Assert
        assertSame(indenter, result);
    }


}