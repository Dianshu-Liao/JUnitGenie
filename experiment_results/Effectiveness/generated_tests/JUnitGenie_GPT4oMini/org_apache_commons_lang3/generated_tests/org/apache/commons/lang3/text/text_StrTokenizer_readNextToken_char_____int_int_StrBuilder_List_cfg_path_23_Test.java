package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class text_StrTokenizer_readNextToken_char_____int_int_StrBuilder_List_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testReadNextToken() {
        try {
            // Create an instance of StrTokenizer
            StrTokenizer tokenizer = new StrTokenizer();

            // Prepare the input parameters
            char[] srcChars = "   ,   ".toCharArray(); // Input with leading whitespace and delimiter
            int start = 0;
            int len = srcChars.length;
            StrBuilder workArea = new StrBuilder();
            List<String> tokenList = new ArrayList<>();

            // Access the private method using reflection
            Method method = StrTokenizer.class.getDeclaredMethod("readNextToken", char[].class, int.class, int.class, StrBuilder.class, List.class);
            method.setAccessible(true);

            // Invoke the method
            int result = (int) method.invoke(tokenizer, srcChars, start, len, workArea, tokenList);

            // Validate the result
            assertEquals(0, result); // Expecting the first token to be at index 0
            assertEquals(1, tokenList.size()); // Expecting one token to be added
            assertEquals("", tokenList.get(0)); // Expecting the token to be an empty string

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}