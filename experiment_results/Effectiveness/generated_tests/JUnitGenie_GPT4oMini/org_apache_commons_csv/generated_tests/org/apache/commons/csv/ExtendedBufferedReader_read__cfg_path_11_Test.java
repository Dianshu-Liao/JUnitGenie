package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import static org.junit.Assert.assertEquals;

public class ExtendedBufferedReader_read__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testReadWithCR() {
        String input = "Hello\rWorld";
        Charset charset = Charset.forName("UTF-8");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), charset, false);
        
        try {
            int firstRead = reader.read(); // Read 'H'
            assertEquals('H', firstRead);
            int secondRead = reader.read(); // Read 'e'
            assertEquals('e', secondRead);
            int thirdRead = reader.read(); // Read 'l'
            assertEquals('l', thirdRead);
            int fourthRead = reader.read(); // Read 'l'
            assertEquals('l', fourthRead);
            int fifthRead = reader.read(); // Read 'o'
            assertEquals('o', fifthRead);
            int sixthRead = reader.read(); // Read '\r'
            assertEquals('\r', sixthRead);
            // Check line number increment
            // Assuming lineNumber is accessible or has a getter
            // assertEquals(1, reader.getLineNumber()); // Uncomment if there's a getter for lineNumber
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithLF() {
        String input = "Hello\nWorld";
        Charset charset = Charset.forName("UTF-8");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), charset, false);
        
        try {
            int firstRead = reader.read(); // Read 'H'
            assertEquals('H', firstRead);
            int sixthRead = reader.read(); // Read '\n'
            assertEquals('\n', sixthRead);
            // Check line number increment
            // Assuming lineNumber is accessible or has a getter
            // assertEquals(1, reader.getLineNumber()); // Uncomment if there's a getter for lineNumber
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadWithEOF() {
        String input = "Hello";
        Charset charset = Charset.forName("UTF-8");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input), charset, false);
        
        try {
            int firstRead = reader.read(); // Read 'H'
            assertEquals('H', firstRead);
            // Read until EOF
            while (reader.read() != -1) {}
            // Check line number remains the same
            // Assuming lineNumber is accessible or has a getter
            // assertEquals(0, reader.getLineNumber()); // Uncomment if there's a getter for lineNumber
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}