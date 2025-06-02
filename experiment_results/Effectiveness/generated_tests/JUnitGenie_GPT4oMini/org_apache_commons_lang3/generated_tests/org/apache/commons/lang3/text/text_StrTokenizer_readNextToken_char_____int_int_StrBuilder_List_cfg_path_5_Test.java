package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class text_StrTokenizer_readNextToken_char_____int_int_StrBuilder_List_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testReadNextToken() {
        try {
            // Preparation
            char[] srcChars = "   token1, token2, token3  ".toCharArray();
            int start = 0;
            int len = srcChars.length;
            StrBuilder workArea = new StrBuilder();
            List<String> tokenList = new ArrayList<>();

            // Create an instance of StrTokenizer
            StrTokenizer tokenizer = new StrTokenizer(srcChars);

            // Access the private method using reflection
            Method method = StrTokenizer.class.getDeclaredMethod("readNextToken", char[].class, int.class, int.class, StrBuilder.class, List.class);
            method.setAccessible(true);

            // Execute the method and retrieve the result
            int result = (int) method.invoke(tokenizer, srcChars, start, len, workArea, tokenList);

            // Assertions
            assertEquals(9, result); // Expecting the return to be the position after the first token
            assertEquals(1, tokenList.size()); // Expecting one token in the token list
            assertEquals("token1", tokenList.get(0)); // Verify the first token matches
        } catch (Exception e) {
            e.printStackTrace();
            assert false; // Failing the test if exception occurs
        }
    }

}