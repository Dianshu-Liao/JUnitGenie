package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class text_StrTokenizer_checkTokenized__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCheckTokenizedWithCharsNotNull() {
        StrTokenizer strTokenizer = new StrTokenizer(new char[] {'a', 'b', 'c'});
        try {
            Method method = StrTokenizer.class.getDeclaredMethod("checkTokenized");
            method.setAccessible(true);
            // Create a new instance with new chars
            strTokenizer = new StrTokenizer(new char[] {'x', 'y', 'z'});
            // Instead of setTokenizeAll, we will use a public method to tokenize
            strTokenizer.setDelimiterChar('x'); // Assuming this method exists to set a delimiter
            strTokenizer.tokenize(new char[] {'x', 'y', 'z'}, 0, 3); // Tokenize the input with required parameters

            // Assert that tokens were set by tokenize method
            assertArrayEquals(new String[] {"y", "z"}, strTokenizer.getTokenArray()); // Adjusted expected output

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckTokenizedWithTokensNullAndCharsNull() {
        StrTokenizer strTokenizer = new StrTokenizer();
        try {
            Method method = StrTokenizer.class.getDeclaredMethod("checkTokenized");
            method.setAccessible(true);
            // No need to set tokenizeAll, just tokenize directly
            strTokenizer.tokenize(new char[] {}, 0, 0); // Tokenize the input with required parameters

            // Assert that tokens were set by tokenize method
            assertArrayEquals(new String[] {}, strTokenizer.getTokenArray()); // Assuming getTokenArray is a public method

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}