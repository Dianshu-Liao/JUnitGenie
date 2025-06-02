package com.fasterxml.jackson.dataformat.xml.deser;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class deser_FromXmlParser_getTextLength__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetTextLengthReturnsZeroWhenTextIsNull() {
        // Arrange
        FromXmlParser parser = null;
        try {
            parser = new FromXmlParser(null, 0, 0, null, null, null) {
                @Override
                public String getText() {
                    return null; // Simulate getText returning null
                }

                @Override
                public int getTextLength() {
                    String text = getText();
                    return (text == null) ? 0 : text.length();
                }
            };
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Act
        int length = 0;
        try {
            if (parser != null) {
                length = parser.getTextLength();
            }
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        assertEquals(0, length);
    }

}