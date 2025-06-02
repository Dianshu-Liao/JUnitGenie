package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.StringReader;
import java.io.IOException;
import java.nio.charset.Charset;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_readLine__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReadLine() {
        String input = "Hello\nWorld";
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), Charset.defaultCharset(), false);
        
        try {
            String line1 = reader.readLine();
            assertEquals("Hello", line1);
            
            String line2 = reader.readLine();
            assertEquals("World", line2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}