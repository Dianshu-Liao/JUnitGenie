package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class text_StrTokenizer_readNextToken_char_____int_int_StrBuilder_List_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testReadNextToken() {
        try {
            // Arrange
            StrTokenizer tokenizer = new StrTokenizer();
            char[] srcChars = "   ,   ".toCharArray(); // Input with leading whitespace and delimiter
            int start = 0;
            int len = srcChars.length;
            StrBuilder workArea = new StrBuilder();
            List<String> tokenList = new ArrayList<>();

            // Act
            Method method = StrTokenizer.class.getDeclaredMethod("readNextToken", char[].class, int.class, int.class, StrBuilder.class, List.class);
            method.setAccessible(true);
            int result = (int) method.invoke(tokenizer, srcChars, start, len, workArea, tokenList);

            // Assert
            assertEquals(-1, result); // Expecting -1 since the input is only whitespace and delimiter
            assertEquals(1, tokenList.size()); // Expecting one empty token added to the list
            assertEquals("", tokenList.get(0)); // The token should be empty

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}