package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.apache.commons.lang3.text.StrMatcher;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrTokenizer__init__String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testStrTokenizerWithValidInput() {
        String input = "test input";
        StrTokenizer tokenizer = new StrTokenizer(input);
        assertNotNull(tokenizer);
    }

    @Test(timeout = 4000)
    public void testStrTokenizerWithNullInput() {
        try {
            StrTokenizer tokenizer = new StrTokenizer((String) null); // Explicitly casting to String
            assertNotNull(tokenizer);
        } catch (Exception e) {
            fail("Exception should not be thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testStrTokenizerWithEmptyInput() {
        String input = "";
        StrTokenizer tokenizer = new StrTokenizer(input);
        assertNotNull(tokenizer);
    }


}