package org.apache.commons.csv;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.junit.Test;
import java.io.IOException;
import java.io.StringReader;
import static org.junit.Assert.assertNull;

public class ExtendedBufferedReader_readLine__cfg_path_37_Test {

    @Test(timeout = 4000)
    public void testReadLineReturnsNullWhenPeekIsEOF() {
        // Arrange
        StringReader stringReader = new StringReader("");
        ExtendedBufferedReader reader = new ExtendedBufferedReader(stringReader);

        try {
            // Act
            String result = reader.readLine();

            // Assert
            assertNull(result);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}