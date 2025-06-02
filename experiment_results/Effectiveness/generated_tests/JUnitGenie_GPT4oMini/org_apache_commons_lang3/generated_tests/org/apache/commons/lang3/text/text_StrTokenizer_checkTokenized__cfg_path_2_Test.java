package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import static org.junit.Assert.assertArrayEquals;

public class text_StrTokenizer_checkTokenized__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckTokenizedWithNullTokensAndChars() {
        StrTokenizer strTokenizer = new StrTokenizer();
        
        // Access the private method using reflection
        try {
            Method method = StrTokenizer.class.getDeclaredMethod("checkTokenized");
            method.setAccessible(true);
            method.invoke(strTokenizer);
            
            // Verify that tokens are set to EMPTY_STRING_ARRAY
            String[] expectedTokens = ArrayUtils.EMPTY_STRING_ARRAY;
            Field tokensField = StrTokenizer.class.getDeclaredField("tokens");
            tokensField.setAccessible(true);
            String[] actualTokens = (String[]) tokensField.get(strTokenizer);
            assertArrayEquals(expectedTokens, actualTokens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testCheckTokenizedWithNullTokensAndNonNullChars() {
        StrTokenizer strTokenizer = new StrTokenizer();
        // Set chars to a non-null value
        try {
            Field charsField = strTokenizer.getClass().getDeclaredField("chars");
            charsField.setAccessible(true);
            charsField.set(strTokenizer, new char[]{'a', 'b', 'c'});

            // Access the private method using reflection
            Method method = StrTokenizer.class.getDeclaredMethod("checkTokenized");
            method.setAccessible(true);
            method.invoke(strTokenizer);
            
            // Verify that tokens are set to EMPTY_STRING_ARRAY
            String[] expectedTokens = ArrayUtils.EMPTY_STRING_ARRAY;
            Field tokensField = StrTokenizer.class.getDeclaredField("tokens");
            tokensField.setAccessible(true);
            String[] actualTokens = (String[]) tokensField.get(strTokenizer);
            assertArrayEquals(expectedTokens, actualTokens);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }


}