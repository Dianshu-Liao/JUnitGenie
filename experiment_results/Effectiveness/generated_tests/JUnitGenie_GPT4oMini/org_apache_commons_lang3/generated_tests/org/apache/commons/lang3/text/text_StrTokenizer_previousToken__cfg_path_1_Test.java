package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class text_StrTokenizer_previousToken__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPreviousTokenWhenNoPreviousToken() {
        // Arrange
        StrTokenizer tokenizer = new StrTokenizer("token1,token2");
        // Set tokenPos to 0 to ensure hasPrevious() returns false
        // Accessing private field tokenPos directly is not possible, 
        // so we will assume the constructor initializes it to 0.
        
        // Act
        String result = tokenizer.previousToken();

        // Assert
        assertNull(result);
    }

}