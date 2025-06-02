package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.nio.charset.Charset;
import static org.junit.Assert.assertNotNull;

public class ExtendedBufferedReader__init__Reader_Charset_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithCharsetAndTrackBytes() {
        // Arrange
        StringReader stringReader = new StringReader("test input");
        Charset charset = Charset.forName("UTF-8");
        boolean trackBytes = true;

        // Act
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, trackBytes);

        // Assert
        assertNotNull(reader);
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullCharset() {
        // Arrange
        StringReader stringReader = new StringReader("test input");
        Charset charset = null;
        boolean trackBytes = true;

        // Act
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader, charset, trackBytes);

        // Assert
        assertNotNull(reader);
    }

}