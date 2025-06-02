package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class text_StrTokenizer_previousToken__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPreviousTokenWhenNoPreviousToken() {
        // Arrange
        StrTokenizer tokenizer = new StrTokenizer("token1,token2"); // Use a single String with delimiters

        // Act
        String result = tokenizer.previousToken();

        // Assert
        assertNull(result);
    }


}